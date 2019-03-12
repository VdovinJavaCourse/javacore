package travelagency.storage;

import travelagency.city.domain.City;
import travelagency.country.domain.Country;
import travelagency.order.domain.Order;
import travelagency.user.domain.User;

public class Storage {
    private static final int CAPACITY = 3;
    public static Country[] countries = new Country[CAPACITY];
    public static City[] cities = new City[CAPACITY];
    public static User[] users = new User[CAPACITY];
    public static Order[] orders = new Order[CAPACITY];
}
