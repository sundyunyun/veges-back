package dhu.sun.vege.service;

import dhu.sun.vege.entity.InstoreItem;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * Created by think on 2018/4/5.
 */
public interface InstoreItemService {
    List<InstoreItem> getAllByinstoreId(Long instoreId);
    InstoreItem addInstoreItem(InstoreItem instoreItem);
}
