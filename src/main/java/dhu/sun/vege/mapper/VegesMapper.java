package dhu.sun.vege.mapper;

import dhu.sun.vege.entity.Veges;
import dhu.sun.vege.util.core.BaseMapper;

import java.util.List;

/**
 * Created by think on 2018/3/20.
 */
public interface VegesMapper extends BaseMapper<Veges> {
    List<Veges> getVegesListBySupplierId(Long supplierId);

    Veges selectVegesByName(String name);

    List<Veges> getOnVeges();
}
