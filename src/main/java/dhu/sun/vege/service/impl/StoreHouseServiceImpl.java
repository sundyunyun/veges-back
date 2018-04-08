package dhu.sun.vege.service.impl;

import dhu.sun.vege.entity.StoreHouse;
import dhu.sun.vege.mapper.StoreHouseMapper;
import dhu.sun.vege.service.StoreHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by think on 2018/4/8.
 */
@Service
public class StoreHouseServiceImpl implements StoreHouseService{
    @Autowired
    private StoreHouseMapper storeHouseMapper;


    @Override
    public List<StoreHouse> getAllstoreInfo(){
        try{
            return storeHouseMapper.selectAll();
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public StoreHouse addStoreHouse(StoreHouse storeHouse){
        try{
            storeHouse.setCreationDate(new Date());
            storeHouseMapper.insertUseGeneratedKeys(storeHouse);
            return storeHouseMapper.selectByPrimaryKey(storeHouse.getId());
        }catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public  StoreHouse changeStoretoAbandon(Long storeId){
        try{
            StoreHouse storeHouse=storeHouseMapper.selectByPrimaryKey(storeId);
            storeHouse.setState("废弃");
            storeHouse.setLastUpdateDate(new Date());
            storeHouseMapper.updateByPrimaryKey(storeHouse);
            return storeHouse;
        }catch (Exception e)
        {
            return null;
        }
    }
}
