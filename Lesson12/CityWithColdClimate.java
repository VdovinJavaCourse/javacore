package Lesson121;

public class CityWithColdClimate extends City {

    private String coldestMonth;
    private Double averageTemperature;
    private boolean polarLights;

    public String getColdestMonth() {
        return coldestMonth;
    }

    public void setColdestMonth(String coldestMonth) {
        this.coldestMonth = coldestMonth;
    }

    public Double getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(Double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public boolean isPolarLights() {
        return polarLights;
    }

    public void setPolarLights(boolean polarLights) {
        this.polarLights = polarLights;
    }

    @Override
    protected void initDiscriminator() {
        discriminator = CityDiscriminator.COLD;
    }

    @Override
    public String toString() {
        return super.toString() +
                " coldestMonth='" + coldestMonth + '\'' +
                ", averageTemperature=" + averageTemperature +
                ", polarLights=" + polarLights
                ;
    }
}
