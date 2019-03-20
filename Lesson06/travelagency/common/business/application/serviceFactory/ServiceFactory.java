package travelagency.common.business.application.serviceFactory;

import travelagency.country.service.CountryService;
import travelagency.city.service.CityService;
import travelagency.order.service.OrderService;
import travelagency.user.service.UserService;

public interface ServiceFactory {
    CountryService getCountryService();
    CityService getCityService();
    OrderService getOrderService();
    UserService getUserService();
}
