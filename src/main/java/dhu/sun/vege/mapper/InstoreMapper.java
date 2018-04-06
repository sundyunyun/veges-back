package dhu.sun.vege.mapper;

import dhu.sun.vege.entity.Instore;
import dhu.sun.vege.util.core.BaseMapper;

import java.util.List;

/**
 * Created by think on 2018/3/20.
 */
public interface InstoreMapper extends BaseMapper<Instore> {
    List<Instore> getAllinstoreBystoreId(Long storeId);
}
