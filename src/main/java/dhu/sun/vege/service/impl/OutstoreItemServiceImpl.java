package dhu.sun.vege.service.impl;

import dhu.sun.vege.entity.OutstoreItem;
import dhu.sun.vege.mapper.OutstoreItemMapper;
import dhu.sun.vege.mapper.VegesMapper;
import dhu.sun.vege.service.OutstoreItemService;
import dhu.sun.vege.service.OutstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by think on 2018/4/10.
 */
@Service
public class OutstoreItemServiceImpl implements OutstoreItemService {
    @Autowired
    private OutstoreItemMapper outstoreItemMapper;

    @Autowired
    private VegesMapper vegesMapper;


    @Override
    public List<OutstoreItem> getAllitemByoutstoreId(Long outstoreId){
        try{
            return outstoreItemMapper.getAllitemByoutstoreId(outstoreId);
        }catch (Exception e)
        {
            return  null;
        }
    }

    @Override
    public OutstoreItem addOutstoreItem(OutstoreItem outstoreItem)
    {
        try{
            if(outstoreItem.getName()!=null&&outstoreItem.getNumber()!=null&&outstoreItem.getPrice()!=null&&outstoreItem.getOutstoreId()!=null)
            {
                outstoreItem.setTotal(outstoreItem.getNumber()*outstoreItem.getPrice());
                outstoreItem.setCreationDate(new Date());
                outstoreItem.setVegesId(vegesMapper.selectVegesByName(outstoreItem.getName()).getId());
                outstoreItemMapper.insertUseGeneratedKeys(outstoreItem);
                return outstoreItemMapper.selectByPrimaryKey(outstoreItem.getId());
            }
            else {
                return null;
            }
        }catch (Exception e)
        {
            return null;
        }
    }
}
