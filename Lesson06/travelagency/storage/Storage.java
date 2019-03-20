package travelagency.storage;

import travelagency.city.domain.City;
import travelagency.country.domain.Country;
import travelagency.order.domain.Order;
import travelagency.user.domain.User;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final int CAPACITY = 3;
    public static Country[] countriesArray = new Country[CAPACITY];
    public static City[] citiesArray = new City[CAPACITY];
    public static User[] usersArray = new User[CAPACITY];
    public static Order[] ordersArray = new Order[CAPACITY];

    public static List<Country> countriesList = new ArrayList<>();
    public static List<City> citiesList = new ArrayList<>();
    public static List<User> usersList = new ArrayList<>();
    public static List<Order> ordersList = new ArrayList<>();

}
