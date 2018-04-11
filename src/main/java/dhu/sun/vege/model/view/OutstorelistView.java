package dhu.sun.vege.model.view;

import dhu.sun.vege.entity.Order;
import dhu.sun.vege.entity.Outstore;
import dhu.sun.vege.entity.StoreHouse;
import dhu.sun.vege.entity.User;

/**
 * Created by think on 2018/4/9.
 */
public class OutstorelistView {
    private User keeper;
    private User driver;
    private Outstore outstore;
    private Order order;
    private StoreHouse storeHouse;

    public User getKeeper() {
        return keeper;
    }

    public void setKeeper(User keeper) {
        this.keeper = keeper;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public Outstore getOutstore() {
        return outstore;
    }

    public void setOutstore(Outstore outstore) {
        this.outstore = outstore;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public StoreHouse getStoreHouse() {
        return storeHouse;
    }

    public void setStoreHouse(StoreHouse storeHouse) {
        this.storeHouse = storeHouse;
    }
}
