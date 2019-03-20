package travelagency.order.repo.impl;

import travelagency.common.solutions.utils.ArrayUtils;
import travelagency.order.domain.Order;
import travelagency.order.repo.OrderRepo;
import travelagency.order.search.OrderSearchCondition;

import java.util.Collections;
import java.util.List;

import static travelagency.storage.Storage.ordersArray;

public class OrderMemoryArrayRepo implements OrderRepo {

    private static final Order[] EMPTY_ORDER_ARR = new Order[0];
    private int orderIndex = -1;

    public void add(Order order) {
        if (orderIndex == ordersArray.length - 1) {
            Order[] newArrOrders = new Order[ordersArray.length];
            System.arraycopy(ordersArray, 0, newArrOrders, 0, ordersArray.length);
            ordersArray = newArrOrders;
        }
        orderIndex++;
        ordersArray[orderIndex] = order;
    }

    public Order findById(long id) {
        Integer foundIndex = findOrderIndexById(id);
        if (foundIndex != null) {
            return ordersArray[foundIndex];
        }
        return null;
    }

    @Override
    public List<Order> search(OrderSearchCondition searchCondition) {
        return Collections.emptyList();
    }

    private Integer findOrderIndexById(Long id) {
        for (int i = 0; i < ordersArray.length; i++) {
            if (ordersArray[i] != null && ordersArray[i].getId().equals(id)) {
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
        for(int i = 0;i<ordersArray.length;i++){
            if(ordersArray[i].equals(order)){
                return i;
            }
        }
        return null;
    }*/

    private void deleteOrderByIndex(int index) {
        ArrayUtils.removeElement(ordersArray, index);
        orderIndex--;
    }

    public void deleteById(Long id) {
        Integer foundIndex = findOrderIndexById(id);
        if (foundIndex != null) {
            deleteOrderByIndex(foundIndex);
        }
    }

    public void printAll() {
        for (Order order : ordersArray) {
            System.out.println(order);
        }
    }

}

