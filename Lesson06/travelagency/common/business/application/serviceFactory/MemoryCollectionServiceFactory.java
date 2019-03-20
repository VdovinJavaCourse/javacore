package travelagency.common.business.application.serviceFactory;


import travelagency.country.repo.impl.CountryMemoryCollectionRepo;
import travelagency.country.service.CountryService;
import travelagency.country.service.impl.CountryDefaultService;
import travelagency.city.repo.impl.CityMemoryCollectionRepo;
import travelagency.city.service.CityService;
import travelagency.city.service.impl.CityDefaultService;
import travelagency.order.repo.impl.OrderMemoryCollectionRepo;
import travelagency.order.service.OrderService;
import travelagency.order.service.impl.OrderDefaultService;
import travelagency.user.repo.impl.UserMemoryCollectionRepo;
import travelagency.user.service.UserService;
import travelagency.user.service.impl.UserDefaultService;

public class MemoryCollectionServiceFactory implements ServiceFactory{

    @Override
    public CountryService getCountryService() {
        return new CountryDefaultService(new CountryMemoryCollectionRepo(), new CityMemoryCollectionRepo());
    }

    @Override
    public CityService getCityService() {
        return new CityDefaultService(new CityMemoryCollectionRepo());
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
