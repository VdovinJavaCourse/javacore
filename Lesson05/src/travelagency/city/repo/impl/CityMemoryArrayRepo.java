package travelagency.city.repo.impl;

import autoservice.common.solutions.utils.ArrayUtils;
import travelagency.city.domain.City;
import travelagency.city.repo.CityRepo;
import travelagency.city.search.CitySearchCondition;

import static travelagency.storage.Storage.cities;

public class CityMemoryArrayRepo implements CityRepo {

    private static final City[] EMPTY_CITY_ARR = new City[0];
    private int cityIndex = -1;

    public void add(City city) {
        if (cityIndex == cities.length - 1) {
            City[] newArrCities = new City[cities.length * 2];
            System.arraycopy(cities, 0, newArrCities, 0, cities.length);
            cities = newArrCities;
        }
        cityIndex++;
        cities[cityIndex] = city;
    }

    public City findById(long id) {
        Integer foundIndex = findCityIndexById(id);
        if (foundIndex != null) {
            return cities[foundIndex];
        }
        return null;
    }

    @Override
    public City[] search(CitySearchCondition searchCondition) {
        return EMPTY_CITY_ARR;
    }

    private Integer findCityIndexById(Long id) {
        for (int i = 0; i < cities.length; i++) {
            if (cities[i] != null && cities[i].getId().equals(id)) {
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
        for (int i = 0; i < cities.length; i++) {
            if (cities[i].equals(city)) {
                return i;
            }
        }
        return null;
    }*/

    private void deleteCityByIndex(int index) {
        ArrayUtils.removeElement(cities, index);
        cityIndex--;
    }

    public void deleteById(Long id) {
        Integer foundIndex = findCityIndexById(id);
        if (foundIndex != null) {
            deleteCityByIndex(foundIndex);
        }
    }

    public void printAll() {
        for (City city : cities) {
            System.out.println(city);
        }
    }
}
