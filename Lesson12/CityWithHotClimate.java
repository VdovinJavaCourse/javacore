package Lesson121;

public class CityWithHotClimate extends City {

    private String hottestMonth;
    private Double averageTemperature;

    public String getHottestMonth() {
        return hottestMonth;
    }

    public void setHottestMonth(String hottestMonth) {
        this.hottestMonth = hottestMonth;
    }

    public Double getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(Double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    @Override
    protected void initDiscriminator() {
        discriminator = CityDiscriminator.HOT;
    }

    @Override
    public String toString() {
        return super.toString() +
                " hottestMonth='" + hottestMonth + '\'' +
                ", averageTemperature=" + averageTemperature
                ;
    }
}
