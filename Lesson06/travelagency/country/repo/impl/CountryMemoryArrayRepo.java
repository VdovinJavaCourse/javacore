package travelagency.country.repo.impl;

import autoservice.common.solutions.utils.ArrayUtils;
import travelagency.common.solutions.utils.StringUtils;
import travelagency.country.domain.Country;
import travelagency.country.repo.CountryRepo;
import travelagency.country.search.CountrySearchCondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static travelagency.storage.Storage.countriesArray;
import static travelagency.storage.Storage.countriesList;

public class CountryMemoryArrayRepo implements CountryRepo {

    private static final Country[] EMPTY_COUNTRY_ARR = new Country[0];
    private int countryIndex = -1;

    public void add(Country country) {
        if (countryIndex == countriesArray.length - 1) {
            Country[] newArrCountries = new Country[countriesArray.length * 2];
            System.arraycopy(countriesArray, 0, newArrCountries, 0, countriesArray.length);
            countriesArray = newArrCountries;
        }
        countryIndex++;
        countriesArray[countryIndex] = country;
    }

    public Country findById(long id) {
        Integer foundIndex = findCountryIndexById(id);
        if (foundIndex != null) {
            return countriesArray[foundIndex];
        }

        return null;
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


    private Integer findCountryIndexById(Long id) {
        for (int i = 0; i < countriesArray.length; i++) {
            if (countriesArray[i] != null && countriesArray[i].getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    /*private Integer findCountryIndexByEntity(Country country) {
        for (int i = 0; i < countriesArray.length; i++) {
            if (countriesArray[i].equals(country)) {
                return i;
            }
        }
        return null;
    }

    public void deleteCountry(Country country) {
        Integer foundIndex = findCountryIndexByEntity(country);
        if (foundIndex != null) {
            deleteCountryByIndex(foundIndex);
        }
    }*/

    public void deleteById(Long id) {
        Integer foundIndex = findCountryIndexById(id);

        if (foundIndex != null) {
            deleteCountryByIndex(foundIndex);
        }

    }

    private void deleteCountryByIndex(int index) {
        ArrayUtils.removeElement(countriesArray, index);
        countryIndex--;
    }

    public void printAll() {
        for (Country country : countriesArray) {
            System.out.println(country);
        }
    }
}
