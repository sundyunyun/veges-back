package dhu.sun.vege.service.impl;

import dhu.sun.vege.entity.StoreItem;
import dhu.sun.vege.mapper.StoreItemMapper;
import dhu.sun.vege.service.StoreItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by think on 2018/4/6.
 */
@Service
public class StoreItemServiceImpl implements StoreItemService {
    @Autowired
    private StoreItemMapper storeItemMapper;

    @Override
    public List<StoreItem> getStoreItemBystoreId(Long storeId){
        try{
            return storeItemMapper.getStoreItemBystoreId(storeId);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public String  delStoreitemByid(Long storeitemId){
        try{
            storeItemMapper.deleteByPrimaryKey(storeitemId);
            return "success";
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public StoreItem updateStoreitemByid(Long storeitemId,Double number){
        try{
            StoreItem storeItem=storeItemMapper.selectByPrimaryKey(storeitemId);
            storeItem.setNumber(number);
            storeItem.setLastUpdateDate(new Date());
            storeItemMapper.updateByPrimaryKey(storeItem);
            return storeItemMapper.selectByPrimaryKey(storeitemId);
        }catch (Exception e){
            return null;
        }
    }
}
