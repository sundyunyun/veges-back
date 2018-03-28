package dhu.sun.vege.service;

import dhu.sun.vege.entity.Veges;

import java.util.List;

/**
 * Created by think on 2018/3/27.
 */
public interface VegesService {

    //根据供应商Id查询可提供蔬菜信息
    List<Veges> getVegesListBySupplierId(Long supplierId);



}
