package travelagency.city.service;

import travelagency.city.domain.City;
import travelagency.city.search.CitySearchCondition;
import travelagency.common.business.service.BaseService;

import java.util.List;

public interface CityService extends BaseService {
    void add(City city);

    City findById(Long id);

    void delete(City country);

    List<City> search(CitySearchCondition searchCondition);
}
