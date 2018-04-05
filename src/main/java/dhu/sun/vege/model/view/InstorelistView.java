package dhu.sun.vege.model.view;

import dhu.sun.vege.entity.Import;
import dhu.sun.vege.entity.Instore;
import dhu.sun.vege.entity.StoreHouse;
import dhu.sun.vege.entity.User;

/**
 * Created by think on 2018/4/5.
 */
public class InstorelistView {
    private Instore instore;
    private User supplier;
    private User buyer;
    private User driver;
    private User keeper;
    private StoreHouse storeHouse;
    private Import impo;

    public Instore getInstore() {
        return instore;
    }

    public void setInstore(Instore instore) {
        this.instore = instore;
    }

    public User getSupplier() {
        return supplier;
    }

    public void setSupplier(User supplier) {
        this.supplier = supplier;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public User getKeeper() {
        return keeper;
    }

    public void setKeeper(User keeper) {
        this.keeper = keeper;
    }

    public StoreHouse getStoreHouse() {
        return storeHouse;
    }

    public void setStoreHouse(StoreHouse storeHouse) {
        this.storeHouse = storeHouse;
    }

    public Import getImpo() {
        return impo;
    }

    public void setImpo(Import impo) {
        this.impo = impo;
    }
}
