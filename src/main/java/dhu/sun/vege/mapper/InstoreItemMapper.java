package dhu.sun.vege.mapper;

import dhu.sun.vege.entity.InstoreItem;
import dhu.sun.vege.util.core.BaseMapper;

import java.util.List;

/**
 * Created by think on 2018/3/20.
 */
public interface InstoreItemMapper extends BaseMapper<InstoreItem> {
    List<InstoreItem> getAllByinstoreId(Long instoreId);
}
