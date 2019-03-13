package travelagency.order.service;

import travelagency.common.business.service.BaseService;
import travelagency.order.domain.Order;

public interface OrderService extends BaseService {
    void add(Order order);

    Order findById(Long id);

    void delete(Order order);
}
