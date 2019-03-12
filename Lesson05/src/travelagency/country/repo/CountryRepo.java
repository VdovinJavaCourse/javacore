package travelagency.country.repo;

import travelagency.common.business.repo.BaseRepo;
import travelagency.country.domain.Country;
import travelagency.country.search.CountrySearchCondition;

public interface CountryRepo extends BaseRepo {

    void add(Country country);

    Country findById(long id);

    Country[] search(CountrySearchCondition searchCondition);
}
