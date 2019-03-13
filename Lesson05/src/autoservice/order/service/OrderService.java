package autoservice.order.service;

import autoservice.common.business.service.BaseService;
import autoservice.order.domain.Order;

public interface OrderService extends BaseService {

    void add(Order order);

    Order findById(Long id);

    void delete(Order order);
}
