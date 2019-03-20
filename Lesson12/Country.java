package Lesson121;

import java.util.List;

public class Country {
    private String name;
    private String language;
    private List<City> cities;

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

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "-----------------\nCountry\n" +
                "name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", \n\ncitiesArray:\n" + getCitiesAsStr();
    }

    private String getCitiesAsStr() {
        StringBuilder stringBuilder = new StringBuilder();
        for (City city : cities) {
            stringBuilder.append(city.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
