package travelagency.city.service;

import travelagency.city.domain.City;
import travelagency.city.repo.impl.CityMemoryRepo;

public class CityMemoryService {

    private CityMemoryRepo cityRepo = new CityMemoryRepo();

    public void addCity(City city){
        cityRepo.add(city);
    }

    public City findCityById(Long id){
        return cityRepo.findCityById(id);
    }

    public void deleteCity(City city){
        cityRepo.deleteCity(city);
    }

    public void deleteCity(Long id){
        cityRepo.deleteCity(id);
    }

    public void printCities(){
        cityRepo.printCities();
    }
}
