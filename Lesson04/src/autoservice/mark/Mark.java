package autoservice.mark;

import autoservice.model.Model;

import java.util.Arrays;
import java.util.Objects;

public class Mark {

    private Long id;
    private String name;
    private String country;
    private Model[] models;

    public Mark() {

    }

    public Mark(String name) {
        this.name = name;
    }

    public Mark(String name, String country) {
        this.name = name;
        this.country = country;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Model[] getModels() {
        return models;
    }

    public void setModels(Model[] models) {
        this.models = models;
    }

    @Override
    public String toString() {
        return "-----------------------\nMark\n" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", \n\nmodels:\n" + getModelsAsStr();
    }

    private String getModelsAsStr() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Model model : models) {
            stringBuilder.append(model.toString()).append("\n");
        }

        return stringBuilder.toString();
    }


}
