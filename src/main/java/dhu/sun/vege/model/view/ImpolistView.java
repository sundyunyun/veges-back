package dhu.sun.vege.model.view;

import dhu.sun.vege.entity.*;

import java.util.List;

/**
 * Description
 *
 * @author Tan Jie
 * @date 2017/12/9
 */

public class ImpolistView {

   private Import impo;
   private User supplier;
   private StoreHouse storeHouse;
   private String suppname;
   private String drivname;
   private String storename;
   private String buyername;

    public Import getImpo() {
        return impo;
    }

    public void setImpo(Import impo) {
        this.impo = impo;
    }

    public User getSupplier() {
        return supplier;
    }

    public void setSupplier(User supplier) {
        this.supplier = supplier;
    }

    public StoreHouse getStoreHouse() {
        return storeHouse;
    }

    public void setStoreHouse(StoreHouse storeHouse) {
        this.storeHouse = storeHouse;
    }

    public String getSuppname() {
        return suppname;
    }

    public void setSuppname(String suppname) {
        this.suppname = suppname;
    }

    public String getDrivname() {
        return drivname;
    }

    public void setDrivname(String drivname) {
        this.drivname = drivname;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getBuyername() {
        return buyername;
    }

    public void setBuyername(String buyername) {
        this.buyername = buyername;
    }
}
