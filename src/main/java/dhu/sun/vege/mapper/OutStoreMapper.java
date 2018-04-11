package dhu.sun.vege.mapper;

import dhu.sun.vege.entity.Outstore;
import dhu.sun.vege.model.view.OutstorelistView;
import dhu.sun.vege.util.core.BaseMapper;

import java.security.acl.LastOwnerException;
import java.util.List;

/**
 * Created by think on 2018/3/20.
 */
public interface OutStoreMapper extends BaseMapper<Outstore> {
    List<Outstore> getAllByStoreId(Long storeId);
}
