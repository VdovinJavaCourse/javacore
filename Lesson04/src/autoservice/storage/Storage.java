package autoservice.storage;

import autoservice.mark.Mark;
import autoservice.model.Model;
import autoservice.order.Order;
import autoservice.user.User;

public class Storage {
    private static final int CAPACITY = 3;
    public static Mark[] marks = new Mark[CAPACITY];
    public static Model[] models = new Model[CAPACITY];
    public static User[] users = new User[CAPACITY];
    public static Order[] orders = new Order[CAPACITY];
}
