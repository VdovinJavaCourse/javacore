package travelagency.common.business.application.serviceFactory;

import travelagency.country.repo.impl.CountryMemoryArrayRepo;
import travelagency.country.service.CountryService;
import travelagency.country.service.impl.CountryDefaultService;
import travelagency.city.repo.impl.CityMemoryArrayRepo;
import travelagency.city.service.CityService;
import travelagency.city.service.impl.CityDefaultService;
import travelagency.order.repo.impl.OrderMemoryArrayRepo;
import travelagency.order.service.OrderService;
import travelagency.order.service.impl.OrderDefaultService;
import travelagency.user.repo.impl.UserMemoryArrayRepo;
import travelagency.user.service.UserService;
import travelagency.user.service.impl.UserDefaultService;

public class MemoryArrayServiceFactory implements ServiceFactory {
    @Override
    public CountryService getCountryService() {
        return new CountryDefaultService(new CountryMemoryArrayRepo(), new CityMemoryArrayRepo());
    }

    @Override
    public CityService getCityService() {
        return new CityDefaultService(new CityMemoryArrayRepo());
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
