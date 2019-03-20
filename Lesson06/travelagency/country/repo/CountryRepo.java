package travelagency.country.repo;

import travelagency.common.business.repo.BaseRepo;
import travelagency.country.domain.Country;
import travelagency.country.search.CountrySearchCondition;

import java.util.List;

public interface CountryRepo extends BaseRepo {

    void add(Country country);

    Country findById(long id);

    List<Country> search(CountrySearchCondition searchCondition);
}
