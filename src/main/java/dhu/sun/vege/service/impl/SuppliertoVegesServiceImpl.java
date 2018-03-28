package dhu.sun.vege.service.impl;

import dhu.sun.vege.entity.SuppliertoVeges;
import dhu.sun.vege.entity.Veges;
import dhu.sun.vege.mapper.SuppliertoVegesMapper;
import dhu.sun.vege.mapper.VegesMapper;
import dhu.sun.vege.service.SuppliertoVegesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by think on 2018/3/28.
 */
@Service
public class SuppliertoVegesServiceImpl implements SuppliertoVegesService {
    @Autowired
    private SuppliertoVegesMapper suppliertoVegesMapper;

    @Autowired
    private VegesMapper vegesMapper;


    @Override
    public Veges deleteByvegesIdsuppId(Long vegesId, Long supplierId){
        try {
            suppliertoVegesMapper.deleteByvegesIdsuppId(vegesId, supplierId);
            return vegesMapper.selectByPrimaryKey(vegesId);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public String addByvegesNamesuppId(Long supplierId,String name)
    {
        try{
            SuppliertoVeges suppliertoVeges=new SuppliertoVeges();
            Veges veges=vegesMapper.selectVegesByName(name);
            suppliertoVeges.setSupplierId(supplierId);
            suppliertoVeges.setVegesId(veges.getId());

            if(suppliertoVegesMapper.selectCount(suppliertoVeges)!=0){
                return "error";
            }
            else {
                suppliertoVegesMapper.insert(suppliertoVeges);
                return "success";
            }

        }catch (Exception e){
            return null;
        }
    }
}
