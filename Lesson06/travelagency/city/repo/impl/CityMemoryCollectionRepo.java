package travelagency.city.repo.impl;

import travelagency.city.domain.City;
import travelagency.city.repo.CityRepo;
import travelagency.city.search.CitySearchCondition;

import java.util.Collections;
import java.util.List;

import static travelagency.storage.Storage.citiesList;

public class CityMemoryCollectionRepo implements CityRepo {
    @Override
    public void add(City city) {
        citiesList.add(city);
    }

    @Override
    public City findById(long id) {
        return findCityById(id);
    }

    @Override
    public List<City> search(CitySearchCondition searchCondition) {
        return Collections.emptyList();
    }

    @Override
    public void deleteById(Long id) {
        City found = findCityById(id);

        if(found!=null){
            citiesList.remove(found);
        }
    }

    @Override
    public void printAll() {
        for(City city : citiesList){
            System.out.println(city);
        }
    }

    private City findCityById(long id){
        for(City city : citiesList){
            if(Long.valueOf(id).equals(city.getId())){
                return city;
            }
        }
        return null;
    }
}
