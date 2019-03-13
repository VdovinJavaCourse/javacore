package travelagency.city.service.impl;

import travelagency.city.domain.City;
import travelagency.city.repo.CityRepo;
import travelagency.city.repo.impl.CityMemoryArrayRepo;
import travelagency.city.service.CityService;

public class CityDefaultService implements CityService {

    private final CityRepo cityRepo;

    public CityDefaultService(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    public void add(City city) {
        if(city!=null) {
            cityRepo.add(city);
        }
    }

    public City findById(Long id) {
        if (id != null) {
            return cityRepo.findById(id);
        }else{
            return null;
        }

    }

    public void delete(City city) {
        if(city!=null && city.getId()!=null) {
            this.deleteById(city.getId());
        }
    }

    public void deleteById(Long id) {
        if (id != null) {
            cityRepo.deleteById(id);
        }
    }

    public void printAll() {
        cityRepo.printAll();
    }
}
