package autoservice.common.business.application.serviceFactory;

import autoservice.mark.repo.impl.MarkMemoryArrayRepo;
import autoservice.mark.service.MarkService;
import autoservice.mark.service.impl.MarkDefaultService;
import autoservice.model.repo.impl.ModelMemoryArrayRepo;
import autoservice.model.service.ModelService;
import autoservice.model.service.impl.ModelDefaultService;
import autoservice.order.repo.impl.OrderMemoryArrayRepo;
import autoservice.order.service.OrderService;
import autoservice.order.service.impl.OrderDefaultService;
import autoservice.user.repo.impl.UserMemoryArrayRepo;
import autoservice.user.service.UserService;
import autoservice.user.service.impl.UserDefaultService;

public class MemoryArrayServiceFactory implements ServiceFactory {
    @Override
    public MarkService getMarkService() {
        return new MarkDefaultService(new MarkMemoryArrayRepo(), new ModelMemoryArrayRepo());
    }

    @Override
    public ModelService getModelService() {
        return new ModelDefaultService(new ModelMemoryArrayRepo());
    }

    @Override
    public OrderService getOrderService() {
        return new OrderDefaultService(new OrderMemoryArrayRepo());
    }

    @Override
    public UserService getUserService() {
        return new UserDefaultService(new UserMemoryArrayRepo());
    }
}
