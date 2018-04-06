package dhu.sun.vege.service;

import dhu.sun.vege.model.view.InstorelistView;

import java.util.List;

/**
 * Created by think on 2018/4/5.
 */
public interface InstoreService {
    List<InstorelistView> getAllInstorelist();
    List<InstorelistView> getAllinstoreBystoreId(Long storeId);
}
