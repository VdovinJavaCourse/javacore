package autoservice.order.service;

import autoservice.common.business.service.BaseService;
import autoservice.order.domain.Order;
import autoservice.order.search.OrderSearchCondition;

import java.util.List;

public interface OrderService extends BaseService {

    void add(Order order);

    Order findById(Long id);

    void delete(Order order);

    List<Order> search(OrderSearchCondition searchCondition);
}
