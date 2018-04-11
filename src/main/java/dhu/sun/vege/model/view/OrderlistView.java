package dhu.sun.vege.model.view;

import dhu.sun.vege.entity.Order;
import dhu.sun.vege.entity.User;

/**
 * Created by think on 2018/4/11.
 */
public class OrderlistView {
    private Order order;
    private User customer;
    private User driver;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }
}
