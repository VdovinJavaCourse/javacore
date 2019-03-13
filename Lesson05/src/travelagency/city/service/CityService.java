package travelagency.city.service;

import travelagency.city.domain.City;
import travelagency.common.business.service.BaseService;

public interface CityService extends BaseService {
    void add(City city);

    City findById(Long id);

    void delete(City country);
}
