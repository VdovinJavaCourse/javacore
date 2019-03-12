package autoservice.storage;

import autoservice.mark.domain.Mark;
import autoservice.model.domain.Model;
import autoservice.order.domain.Order;
import autoservice.user.domain.User;

public class Storage {
    private static final int CAPACITY = 3;
    public static Mark[] marks = new Mark[CAPACITY];
    public static Model[] models = new Model[CAPACITY];
    public static User[] users = new User[CAPACITY];
    public static Order[] orders = new Order[CAPACITY];
}
