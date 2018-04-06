package dhu.sun.vege.service;

import dhu.sun.vege.entity.StoreItem;

import java.util.List;

/**
 * Created by think on 2018/4/6.
 */
public interface StoreItemService {
    List<StoreItem> getStoreItemBystoreId(Long storeId);
    String delStoreitemByid(Long storeitemId);
    StoreItem updateStoreitemByid(Long storeitemId,Double number);
}
