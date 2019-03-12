package travelagency.storage;

import travelagency.city.City;
import travelagency.country.Country;
import travelagency.order.Order;
import travelagency.user.User;

public class Storage {
    private static final int CAPACITY = 3;
    public static Country[] countries = new Country[CAPACITY];
    public static City[] cities = new City[CAPACITY];
    public static User[] users = new User[CAPACITY];
    public static Order[] orders = new Order[CAPACITY];
}
