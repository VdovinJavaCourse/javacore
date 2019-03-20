package travelagency.city.repo.impl;

import autoservice.common.solutions.utils.ArrayUtils;
import travelagency.city.domain.City;
import travelagency.city.repo.CityRepo;
import travelagency.city.search.CitySearchCondition;

import java.util.Collections;
import java.util.List;

import static travelagency.storage.Storage.citiesArray;

public class CityMemoryArrayRepo implements CityRepo {

    private static final City[] EMPTY_CITY_ARR = new City[0];
    private int cityIndex = -1;

    public void add(City city) {
        if (cityIndex == citiesArray.length - 1) {
            City[] newArrCities = new City[citiesArray.length * 2];
            System.arraycopy(citiesArray, 0, newArrCities, 0, citiesArray.length);
            citiesArray = newArrCities;
        }
        cityIndex++;
        citiesArray[cityIndex] = city;
    }

    public City findById(long id) {
        Integer foundIndex = findCityIndexById(id);
        if (foundIndex != null) {
            return citiesArray[foundIndex];
        }
        return null;
    }

    @Override
    public List<City> search(CitySearchCondition searchCondition) {
        return Collections.emptyList();
    }

    private Integer findCityIndexById(Long id) {
        for (int i = 0; i < citiesArray.length; i++) {
            if (citiesArray[i] != null && citiesArray[i].getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    /*public void deleteCity(City city) {
        Integer foundIndex = findCityIndexByEntity(city);
        if (foundIndex != null) {
            deleteCityByIndex(foundIndex);
        }
    }

    private Integer findCityIndexByEntity(City city) {
        for (int i = 0; i < citiesArray.length; i++) {
            if (citiesArray[i].equals(city)) {
                return i;
            }
        }
        return null;
    }*/

    private void deleteCityByIndex(int index) {
        ArrayUtils.removeElement(citiesArray, index);
        cityIndex--;
    }

    public void deleteById(Long id) {
        Integer foundIndex = findCityIndexById(id);
        if (foundIndex != null) {
            deleteCityByIndex(foundIndex);
        }
    }

    public void printAll() {
        for (City city : citiesArray) {
            System.out.println(city);
        }
    }
}
