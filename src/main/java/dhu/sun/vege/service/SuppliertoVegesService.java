package dhu.sun.vege.service;

import dhu.sun.vege.entity.Veges;

/**
 * Created by think on 2018/3/28.
 */
public interface SuppliertoVegesService {

    //根据蔬菜id和供应商id删除记录
    Veges deleteByvegesIdsuppId(Long vegesId, Long supplierId);

    //根据蔬菜名和供应商插入记录
    String addByvegesNamesuppId(Long supplierId,String name);
}
