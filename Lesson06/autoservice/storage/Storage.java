package autoservice.storage;

import autoservice.mark.domain.Mark;
import autoservice.model.domain.Model;
import autoservice.order.domain.Order;
import autoservice.user.domain.User;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final int CAPACITY = 3;
    public static Mark[] marksArray = new Mark[CAPACITY];
    public static Model[] modelsArray = new Model[CAPACITY];
    public static User[] usersArray = new User[CAPACITY];
    public static Order[] ordersArray = new Order[CAPACITY];

    public static List<Mark> marksList = new ArrayList<>();
    public static List<Model> modelsList = new ArrayList<>();
    public static List<User> usersList = new ArrayList<>();
    public static List<Order> ordersList = new ArrayList<>();

}
