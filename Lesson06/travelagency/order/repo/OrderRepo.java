package travelagency.order.repo;

import travelagency.common.business.repo.BaseRepo;
import travelagency.order.domain.Order;
import travelagency.order.search.OrderSearchCondition;

import java.util.List;

public interface OrderRepo extends BaseRepo {

    void add(Order order);

    Order findById(long id);

    List<Order> search(OrderSearchCondition searchCondition);
}
