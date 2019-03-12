package travelagency.order.repo;

import travelagency.common.business.repo.BaseRepo;
import travelagency.order.domain.Order;
import travelagency.order.search.OrderSearchCondition;

public interface OrderRepo extends BaseRepo {

    void add(Order order);

    Order findById(long id);

    Order[] search(OrderSearchCondition searchCondition);
}
