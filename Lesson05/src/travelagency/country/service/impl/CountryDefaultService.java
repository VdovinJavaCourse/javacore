package travelagency.country.service.impl;

import travelagency.city.domain.City;
import travelagency.city.repo.CityRepo;
import travelagency.city.repo.impl.CityMemoryArrayRepo;
import travelagency.country.domain.Country;
import travelagency.country.repo.CountryRepo;
import travelagency.country.repo.impl.CountryMemoryArrayRepo;
import travelagency.country.search.CountrySearchCondition;
import travelagency.country.service.CountryService;

public class CountryDefaultService implements CountryService {

    private final CountryRepo countryRepo;
    private final CityRepo cityRepo;

    public CountryDefaultService(CountryRepo countryRepo, CityRepo cityRepo) {
        this.countryRepo = countryRepo;
        this.cityRepo = cityRepo;
    }

    public void add(Country country) {
        if (country != null) {
            countryRepo.add(country);


            if (country.getCities() != null) {
                for (City city : country.getCities()) {
                    if (city != null) {
                        cityRepo.add(city);
                    }
                }
            }
        }
    }

    public Country findById(Long id) {
        if (id != null) {
            return countryRepo.findById(id);
        } else {
            return null;
        }
    }

    @Override
    public Country[] search(CountrySearchCondition searchCondition) {
        return countryRepo.search(searchCondition);
    }

    public void delete(Country country) {
        if(country!=null && country.getId()!=null){
           this.deleteById(country.getId());
        }

    }

    public void deleteById(Long id) {
        if (id != null) {
            countryRepo.deleteById(id);
        }
    }

    public void printAll() {
        countryRepo.printAll();
    }
}
