package autoservice.order.service.impl;

import autoservice.order.domain.Order;
import autoservice.order.repo.OrderRepo;
import autoservice.order.search.OrderSearchCondition;
import autoservice.order.service.OrderService;

import java.util.List;

public class OrderDefaultService implements OrderService {

    private final OrderRepo orderRepo;

    public OrderDefaultService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public void add(Order order) {
        if (order != null) {
            orderRepo.add(order);
        }
    }

    public Order findById(Long id) {
        if (id != null) {
            return orderRepo.findById(id);
        } else {
            return null;
        }
    }

    public void delete(Order order) {
        if (order.getId() != null) {
            this.deleteById(order.getId());
        }
    }

    @Override
    public List<Order> search(OrderSearchCondition searchCondition) {
        return orderRepo.search(searchCondition);
    }

    public void deleteById(Long id) {
        if (id != null) {
            orderRepo.deleteById(id);
        }
    }

    public void printAll() {
        orderRepo.printAll();
    }
}
