package travelagency.city.repo;

import travelagency.city.domain.City;
import travelagency.city.search.CitySearchCondition;
import travelagency.common.business.repo.BaseRepo;

import java.util.List;

public interface CityRepo extends BaseRepo {

    void add(City city);

    City findById(long id);

    List<City> search(CitySearchCondition searchCondition);
}
