package dhu.sun.vege.service;

import dhu.sun.vege.entity.OutstoreItem;

import java.util.List;

/**
 * Created by think on 2018/4/10.
 */
public interface OutstoreItemService {
    List<OutstoreItem> getAllitemByoutstoreId(Long outstoreId);
    OutstoreItem addOutstoreItem(OutstoreItem outstoreItem);
}
