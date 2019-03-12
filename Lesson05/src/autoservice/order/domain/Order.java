package autoservice.order.domain;

import autoservice.common.business.domain.BaseDomain;
import autoservice.mark.domain.Mark;
import autoservice.model.domain.Model;
import autoservice.user.domain.User;

public class Order extends BaseDomain {


    private Model model;
    private Mark mark;
    private User user;
    private String description;
    private int price;

    public Order() {

    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
