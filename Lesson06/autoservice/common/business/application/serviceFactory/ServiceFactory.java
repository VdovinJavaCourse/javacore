package autoservice.common.business.application.serviceFactory;

import autoservice.mark.service.MarkService;
import autoservice.model.service.ModelService;
import autoservice.order.service.OrderService;
import autoservice.user.service.UserService;

public interface ServiceFactory {
    MarkService getMarkService();
    ModelService getModelService();
    OrderService getOrderService();
    UserService getUserService();
}
