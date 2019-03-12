package travelagency.order.domain;

import travelagency.city.domain.City;
import travelagency.common.business.domain.BaseDomain;
import travelagency.country.domain.Country;
import travelagency.user.domain.User;

public class Order extends BaseDomain {

    private Country country;
    private City city;
    private User user;
    private int price;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
