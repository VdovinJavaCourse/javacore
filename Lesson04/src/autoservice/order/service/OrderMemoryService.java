package autoservice.order.service;

import autoservice.order.Order;
import autoservice.order.repo.OrderMemoryRepo;

public class OrderMemoryService {

    private OrderMemoryRepo orderRepo = new OrderMemoryRepo();

    public void addOrder(Order order) {
        orderRepo.add(order);
    }

    public Order findOrderById(Long id) {
        return orderRepo.findOrderById(id);
    }

    public void deleteOrder(Order order) {
        orderRepo.deleteOrder(order);
    }

    public void deleteOrder(Long id) {
        orderRepo.deleteOrder(id);
    }

    public void printOrders() {
        orderRepo.printOrders();
    }
}
