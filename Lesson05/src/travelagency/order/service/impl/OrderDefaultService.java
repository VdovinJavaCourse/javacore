package travelagency.order.service.impl;

import travelagency.order.domain.Order;
import travelagency.order.repo.OrderRepo;
import travelagency.order.service.OrderService;

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

    public void deleteById(Long id) {
        if (id != null) {
            orderRepo.deleteById(id);
        }
    }

    public void printAll() {
        orderRepo.printAll();
    }
}