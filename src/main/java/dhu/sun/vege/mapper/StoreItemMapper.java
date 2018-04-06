package dhu.sun.vege.mapper;

import dhu.sun.vege.entity.StoreItem;
import dhu.sun.vege.util.core.BaseMapper;

import java.util.List;

/**
 * Created by think on 2018/3/20.
 */
public interface StoreItemMapper extends BaseMapper<StoreItem> {
    List<StoreItem> getStoreItemBystoreId(Long storeId);
}
