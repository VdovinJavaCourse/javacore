package Lesson121;

public abstract class City {

    private String name;
    private int population;
    private boolean isCapital;
    protected CityDiscriminator discriminator;

    public City() {
        initDiscriminator();
    }

    protected abstract void initDiscriminator();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    public CityDiscriminator getDiscriminator() {
        return discriminator;
    }

    @Override
    public String toString() {
        return "City: " + " discriminator=" + discriminator +
                "    name='" + name + '\'' +
                ", population=" + population +
                ", isCapital=" + isCapital + ", "

                ;
    }
}
