package dhu.sun.vege.service;

import dhu.sun.vege.entity.StoreHouse;

import java.util.List;

/**
 * Created by think on 2018/4/8.
 */
public interface StoreHouseService {
    List<StoreHouse> getAllstoreInfo();
    StoreHouse addStoreHouse(StoreHouse storeHouse);
    StoreHouse changeStoretoAbandon(Long storeId);
}
