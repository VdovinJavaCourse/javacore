package autoservice.common.business.application.serviceFactory;


import autoservice.mark.repo.impl.MarkMemoryCollectionRepo;
import autoservice.mark.service.MarkService;
import autoservice.mark.service.impl.MarkDefaultService;
import autoservice.model.repo.impl.ModelMemoryCollectionRepo;
import autoservice.model.service.ModelService;
import autoservice.model.service.impl.ModelDefaultService;
import autoservice.order.repo.impl.OrderMemoryCollectionRepo;
import autoservice.order.service.OrderService;
import autoservice.order.service.impl.OrderDefaultService;
import autoservice.user.repo.impl.UserMemoryCollectionRepo;
import autoservice.user.service.UserService;
import autoservice.user.service.impl.UserDefaultService;

public class MemoryCollectionServiceFactory implements ServiceFactory{
    @Override
    public MarkService getMarkService() {
        return new MarkDefaultService(new MarkMemoryCollectionRepo(), new ModelMemoryCollectionRepo());
    }

    @Override
    public ModelService getModelService() {
        return new ModelDefaultService(new ModelMemoryCollectionRepo());
    }

    @Override
    public OrderService getOrderService() {
        return new OrderDefaultService(new OrderMemoryCollectionRepo());
    }

    @Override
    public UserService getUserService() {
        return new UserDefaultService(new UserMemoryCollectionRepo());
    }
}
