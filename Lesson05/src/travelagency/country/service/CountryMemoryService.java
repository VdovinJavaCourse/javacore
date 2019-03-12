package travelagency.country.service;

import travelagency.city.domain.City;
import travelagency.city.repo.impl.CityMemoryRepo;
import travelagency.country.domain.Country;
import travelagency.country.repo.impl.CountryMemoryRepo;

public class CountryMemoryService {

    private CountryMemoryRepo countryRepo = new CountryMemoryRepo();
    private CityMemoryRepo cityRepo = new CityMemoryRepo();

    public void addCountry(Country country) {
        countryRepo.addCountry(country);

        if (country.getCities() != null) {
            for (City city : country.getCities()) {
                cityRepo.add(city);
            }
        }
    }

    public Country findCountryById(Long id) {
        return countryRepo.findCountryById(id);
    }

    public void deleteCountry(Country country) {
        countryRepo.deleteCountry(country);
    }

    public void deleteCountry(Long id) {
        countryRepo.deleteCountry(id);
    }

    public void printCountries() {
        countryRepo.printCountries();
    }
}
