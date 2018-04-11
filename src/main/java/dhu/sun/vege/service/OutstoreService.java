package dhu.sun.vege.service;

import dhu.sun.vege.entity.Outstore;
import dhu.sun.vege.model.view.OutstorelistView;

import java.util.List;

/**
 * Created by think on 2018/4/9.
 */
public interface OutstoreService {
    List<OutstorelistView> getAllOutstore();
    List<OutstorelistView> getAllBystoreId(Long storeId);
    Outstore addOutstore(Outstore outstore);
    Outstore addOustoreDone(Long outstoreId);
}
