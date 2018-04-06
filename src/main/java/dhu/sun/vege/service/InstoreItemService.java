package dhu.sun.vege.service;

import dhu.sun.vege.entity.InstoreItem;

import java.util.List;

/**
 * Created by think on 2018/4/5.
 */
public interface InstoreItemService {
    List<InstoreItem> getAllByinstoreId(Long instoreId);
}
