package autoservice.order.service;

import autoservice.common.business.application.StorageType;
import autoservice.order.repo.impl.OrderMemoryArrayRepo;
import autoservice.order.service.impl.OrderDefaultService;

public final class OrderServiceCreator {

    private OrderServiceCreator(){

    }

    public static OrderService getOrderService(StorageType storageType) {
        switch (storageType) {

            case MEMORY_ARRAY:
                return new OrderDefaultService(new OrderMemoryArrayRepo());

            case MEMORY_COLLECTION:{
                return null;
            }

            default: {
                return null;
            }
        }
    }
}
