package travelagency.city.repo;

import autoservice.common.ArrayUtils;
import travelagency.city.City;

import static travelagency.storage.Storage.cities;

public class CityMemoryRepo {

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

    public City findCityById(long id) {
        Integer foundIndex = findCityIndexById(id);
        if (foundIndex != null) {
            return cities[foundIndex];
        }
        return null;
    }

    private Integer findCityIndexById(Long id) {
        for (int i = 0; i < cities.length; i++) {
            if (cities[i].getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    public void deleteCity(City city) {
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
    }

    private void deleteCityByIndex(int index) {
        ArrayUtils.removeElement(cities, index);
        cityIndex--;
    }

    public void deleteCity(Long id) {
        Integer foundIndex = findCityIndexById(id);
        if (foundIndex != null) {
            deleteCityByIndex(foundIndex);
        }
    }

    public void printCities() {
        for (City city : cities) {
            System.out.println(city);
        }
    }
}
