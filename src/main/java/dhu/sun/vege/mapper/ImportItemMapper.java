package dhu.sun.vege.mapper;

import dhu.sun.vege.entity.ImportItem;
import dhu.sun.vege.util.core.BaseMapper;

import java.util.List;

/**
 * Created by think on 2018/3/20.
 */
public interface ImportItemMapper extends BaseMapper<ImportItem> {
    //根据ImportId获取
    List<ImportItem> getAllByImportId(Long importId);
}
