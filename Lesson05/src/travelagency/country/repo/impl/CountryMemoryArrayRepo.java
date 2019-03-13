package travelagency.country.repo.impl;

import autoservice.common.solutions.utils.ArrayUtils;
import travelagency.country.domain.Country;
import travelagency.country.repo.CountryRepo;
import travelagency.country.search.CountrySearchCondition;

import static travelagency.storage.Storage.countries;

public class CountryMemoryArrayRepo implements CountryRepo {

    private static final Country[] EMPTY_COUNTRY_ARR = new Country[0];
    private int countryIndex = -1;

    public void add(Country country) {
        if (countryIndex == countries.length - 1) {
            Country[] newArrCountries = new Country[countries.length * 2];
            System.arraycopy(countries, 0, newArrCountries, 0, countries.length);
            countries = newArrCountries;
        }
        countryIndex++;
        countries[countryIndex] = country;
    }

    public Country findById(long id) {
        Integer foundIndex = findCountryIndexById(id);
        if (foundIndex != null) {
            return countries[foundIndex];
        }

        return null;
    }

    @Override
    public Country[] search(CountrySearchCondition searchCondition) {
        return EMPTY_COUNTRY_ARR;
    }

    private Integer findCountryIndexById(Long id) {
        for (int i = 0; i < countries.length; i++) {
            if (countries[i] != null && countries[i].getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    /*private Integer findCountryIndexByEntity(Country country) {
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].equals(country)) {
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
        ArrayUtils.removeElement(countries, index);
        countryIndex--;
    }

    public void printAll() {
        for (Country country : countries) {
            System.out.println(country);
        }
    }
}
