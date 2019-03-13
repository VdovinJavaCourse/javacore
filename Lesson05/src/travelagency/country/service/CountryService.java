package travelagency.country.service;

import travelagency.common.business.service.BaseService;
import travelagency.country.domain.Country;
import travelagency.country.search.CountrySearchCondition;

public interface CountryService extends BaseService {

    void add(Country country);

    Country findById(Long id);

    void delete(Country country);

    Country[] search (CountrySearchCondition searchCondition);
}
