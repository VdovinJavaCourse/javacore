package travelagency.order.repo.impl;

import travelagency.common.solutions.utils.ArrayUtils;
import travelagency.order.domain.Order;
import travelagency.order.repo.OrderRepo;
import travelagency.order.search.OrderSearchCondition;

import static travelagency.storage.Storage.orders;

public class OrderMemoryArrayRepo implements OrderRepo {

    private static final Order[] EMPTY_ORDER_ARR = new Order[0];
    private int orderIndex = -1;

    public void add(Order order) {
        if (orderIndex == orders.length - 1) {
            Order[] newArrOrders = new Order[orders.length];
            System.arraycopy(orders, 0, newArrOrders, 0, orders.length);
            orders = newArrOrders;
        }
        orderIndex++;
        orders[orderIndex] = order;
    }

    public Order findById(long id) {
        Integer foundIndex = findOrderIndexById(id);
        if (foundIndex != null) {
            return orders[foundIndex];
        }
        return null;
    }

    @Override
    public Order[] search(OrderSearchCondition searchCondition) {
        return EMPTY_ORDER_ARR;
    }

    private Integer findOrderIndexById(Long id) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] != null && orders[i].getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    /*public void deleteOrder(Order order){
        Integer foundIndex = findOrderIndexByEntity(order);
        if(foundIndex!=null){
            deleteOrderByIndex(foundIndex);
        }
    }

    private Integer findOrderIndexByEntity(Order order){
        for(int i = 0;i<orders.length;i++){
            if(orders[i].equals(order)){
                return i;
            }
        }
        return null;
    }*/

    private void deleteOrderByIndex(int index) {
        ArrayUtils.removeElement(orders, index);
        orderIndex--;
    }

    public void deleteById(Long id) {
        Integer foundIndex = findOrderIndexById(id);
        if (foundIndex != null) {
            deleteOrderByIndex(foundIndex);
        }
    }

    public void printAll() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

}

