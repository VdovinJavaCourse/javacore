package autoservice.order.repo;

import autoservice.common.business.repo.BaseRepo;
import autoservice.order.domain.Order;
import autoservice.order.search.OrderSearchCondition;

public interface OrderRepo extends BaseRepo {

    void add(Order order);

    Order findById(long id);

    Order[] search(OrderSearchCondition searchCondition);
}
