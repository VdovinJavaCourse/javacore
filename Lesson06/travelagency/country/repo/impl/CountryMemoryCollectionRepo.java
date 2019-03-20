package travelagency.country.repo.impl;

import travelagency.common.solutions.utils.StringUtils;
import travelagency.country.domain.Country;
import travelagency.country.repo.CountryRepo;
import travelagency.country.search.CountrySearchCondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static travelagency.storage.Storage.countriesList;

public class CountryMemoryCollectionRepo implements CountryRepo {
    @Override
    public void add(Country country) {
        countriesList.add(country);
    }

    @Override
    public Country findById(long id) {
        return findCountryById(id);
    }

    @Override
    public List<Country> search(CountrySearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            return Collections.singletonList(findById(searchCondition.getId()));
        } else {

            boolean searchByName = StringUtils.isNotBlank(searchCondition.getName());
            boolean searchByLanguage = StringUtils.isNotBlank(searchCondition.getLanguage());

            List<Country> result = new ArrayList<>();

            for (Country country : countriesList) {
                if (country != null) {
                    boolean found = false;

                    if (searchByName) {
                        found = searchCondition.getName().equals(country.getName());
                    }
                    if (found && searchByLanguage) {
                        found = searchCondition.getLanguage().equals(country.getLanguage());
                    }
                    if (found) {
                        result.add(country);

                    }
                }

            }

            return result;
        }
    }


    @Override
    public void deleteById(Long id) {
        Country found = findCountryById(id);
        if (found != null) {
            countriesList.remove(found);
        }
    }

    @Override
    public void printAll() {
        for (Country country : countriesList) {
            System.out.println(country);
        }
    }

    private Country findCountryById(long id) {
        for (Country country : countriesList) {
            if (Long.valueOf(id).equals(country.getId())) {
                return country;
            }
        }
        return null;
    }
}
