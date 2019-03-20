package travelagency.order.service;

import travelagency.common.business.service.BaseService;
import travelagency.order.domain.Order;
import travelagency.order.search.OrderSearchCondition;

import java.util.List;

public interface OrderService extends BaseService {
    void add(Order order);

    Order findById(Long id);

    void delete(Order order);

    List<Order> search(OrderSearchCondition searchCondition);
}
