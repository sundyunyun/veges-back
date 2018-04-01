package dhu.sun.vege.mapper;

import dhu.sun.vege.entity.Import;
import dhu.sun.vege.util.core.BaseMapper;

import java.util.List;

/**
 * Created by think on 2018/3/20.
 */
public interface ImportMapper extends BaseMapper<Import> {
    List<Import> getImpoBybuyerId(Long buyerId);
}
