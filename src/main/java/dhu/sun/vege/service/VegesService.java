package dhu.sun.vege.service;

import dhu.sun.vege.entity.Veges;
import dhu.sun.vege.model.view.Vegeslist;

import java.util.List;

/**
 * Created by think on 2018/3/27.
 */
public interface VegesService {

    //根据供应商Id查询可提供蔬菜信息
    List<Veges> getVegesListBySupplierId(Long supplierId);

    /**
     * 获取所有蔬菜信息
     */
    List<Veges> getAllVeges();

    Veges addVeges(Veges veges);

    Veges getVegesById(Long vegesId);

    Veges changeVeges(Veges veges);

    Veges changeStateOn(Long vegesId);

    Veges changeStateOff(Long vegesId);

    List<Vegeslist> getOnVeges();

    Veges addPicpath(String pth,Long vegesId);

    Veges addVegesPath(Long vegesId,String pth);


}
