package travelagency.country.repo;

import autoservice.common.ArrayUtils;
import travelagency.country.Country;

import static travelagency.storage.Storage.countries;

public class CountryMemoryRepo {

    private int countryIndex = -1;

    public void addCountry(Country country) {
        if (countryIndex == countries.length - 1) {
            Country[] newArrCountries = new Country[countries.length * 2];
            System.arraycopy(countries, 0, newArrCountries, 0, countries.length);
            countries = newArrCountries;
        }
        countryIndex++;
        countries[countryIndex] = country;
    }

    public Country findCountryById(long id) {
        Integer foundIndex = findCountryIndexById(id);
        if (foundIndex != null) {
            return countries[foundIndex];
        }

        return null;
    }

    private Integer findCountryIndexById(Long id) {
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    private Integer findCountryIndexByEntity(Country country) {
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
    }

    public void deleteCountry(Long id) {
        Integer foundIndex = findCountryIndexById(id);

        if (foundIndex != null) {
            deleteCountryByIndex(foundIndex);
        }

    }

    private void deleteCountryByIndex(int index) {
        ArrayUtils.removeElement(countries, index);
        countryIndex--;
    }

    public void printCountries() {
        for (Country country : countries) {
            System.out.println(country);
        }
    }
}
