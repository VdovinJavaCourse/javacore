package travelagency.country;

import travelagency.city.City;

import java.util.Arrays;

public class Country {

    private Long id;
    private String name;
    private String language;
    private City[] cities;

    public Country() {

    }

    public Country(String name) {
        this.name = name;
    }

    public Country(String name, String language) {
        this.name = name;
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public City[] getCities() {
        return cities;
    }

    public void setCities(City[] cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "-----------------\nCountry\n" +
                "id=" + id + ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", \n\ncities:\n" + getCitiesAsStr();
    }

    private String getCitiesAsStr() {
        StringBuilder stringBuilder = new StringBuilder();
        for (City city : cities) {
            stringBuilder.append(city.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
