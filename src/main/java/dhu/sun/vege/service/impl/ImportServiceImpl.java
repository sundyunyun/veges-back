package dhu.sun.vege.service.impl;

import dhu.sun.vege.entity.Import;
import dhu.sun.vege.entity.StoreHouse;
import dhu.sun.vege.entity.User;
import dhu.sun.vege.mapper.ImportMapper;
import dhu.sun.vege.mapper.StoreHouseMapper;
import dhu.sun.vege.mapper.UserMapper;
import dhu.sun.vege.model.view.ImpolistView;
import dhu.sun.vege.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by think on 2018/3/30.
 */
@Service
public class ImportServiceImpl implements ImportService {
    @Autowired
    private ImportMapper importMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StoreHouseMapper storeHouseMapper;

    @Override
    public Import addImport(Import impo)
    {
        User user;
        try{
            if(impo.getTotalweight()!=null&&impo.getSupplierId()!=null&&impo.getTotalprice()!=null&&impo.getStoreId()!=null&&impo.getDriverId()!=null){

                if(userMapper.selectByPrimaryKey(impo.getSupplierId())!=null&&userMapper.selectByPrimaryKey(impo.getDriverId())!=null&&storeHouseMapper.selectByPrimaryKey(impo.getStoreId())!=null){
                    impo.setCreationDate(new Date());
                    importMapper.insertUseGeneratedKeys(impo);
                    //更新采购员状态
                    user =userMapper.selectByPrimaryKey(impo.getBuyerId());
                    user.setState("进货中");
                    userMapper.updateByPrimaryKey(user);
                    return importMapper.selectByPrimaryKey(impo.getId());
                }
               else
                {
                    return null;
                }
            }
            else
            return null;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Import addImportDone(Long importId){
        try{
           Import impo;
           impo=importMapper.selectByPrimaryKey(importId);
           impo.setState("进货已完成");
           importMapper.updateByPrimaryKey(impo);
            return importMapper.selectByPrimaryKey(impo.getId());
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<ImpolistView> getImpoBybuyerId(Long buyerId){
        try{
            StoreHouse storeHouse;
            List<ImpolistView> impolistViews =new ArrayList<>();
            List<Import> impolist=importMapper.getImpoBybuyerId(buyerId);
            int i=impolist.size();

            for(i=i-1;i>=0;i--)
            {
                ImpolistView impolistView=new ImpolistView();
                impolistView.setImpo(impolist.get(i));
                storeHouse =storeHouseMapper.selectByPrimaryKey(impolist.get(i).getStoreId());
                impolistView.setStorename(storeHouse.getName());
                impolistView.setBuyername(userMapper.selectByPrimaryKey(impolist.get(i).getBuyerId()).getName());
                impolistView.setDrivname(userMapper.selectByPrimaryKey(impolist.get(i).getDriverId()).getName());
                impolistView.setSuppname(userMapper.selectByPrimaryKey(impolist.get(i).getSupplierId()).getName());

                impolistViews.add(impolistView);

            }
            return impolistViews;
        }catch (Exception e)
        {
            return null;
        }
    }
}
