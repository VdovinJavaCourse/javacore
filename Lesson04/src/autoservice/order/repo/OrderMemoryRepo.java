package autoservice.order.repo;

import autoservice.common.ArrayUtils;
import autoservice.order.Order;

import static autoservice.storage.Storage.orders;

public class OrderMemoryRepo {

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

    public Order findOrderById(long id){
        Integer foundIndex = findOrderIndexById(id);
        if (foundIndex != null) {
            return orders[foundIndex];
        }
        return null;
    }

    private Integer findOrderIndexById(Long id){
        for(int i=0;i<orders.length;i++){
            if(orders[i].getId().equals(id)){
                return i;
            }
        }
        return null;
    }

    public void deleteOrder(Order order){
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
    }

    private void deleteOrderByIndex(int index){
        ArrayUtils.removeElement(orders,index);
        orderIndex--;
    }

    public void deleteOrder(Long id){
        Integer foundIndex = findOrderIndexById(id);
        if(foundIndex!=null){
            deleteOrderByIndex(foundIndex);
        }
    }

    public void printOrders(){
        for(Order order :orders){
            System.out.println(order);
        }
    }

}
