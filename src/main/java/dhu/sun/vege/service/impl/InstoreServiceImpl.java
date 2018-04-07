package dhu.sun.vege.service.impl;

import dhu.sun.vege.entity.*;
import dhu.sun.vege.mapper.*;
import dhu.sun.vege.model.view.InstorelistView;
import dhu.sun.vege.service.InstoreService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by think on 2018/4/5.
 */
@Service
public class InstoreServiceImpl implements InstoreService {
    @Autowired
    private InstoreMapper instoreMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StoreHouseMapper storeHouseMapper;

    @Autowired
    private ImportMapper importMapper;

    @Autowired
    private InstoreItemMapper instoreItemMapper;

    @Autowired
    private StoreItemMapper storeItemMapper;



    @Override
    public List<InstorelistView> getAllInstorelist(){
        try{
            List<Instore> instores=instoreMapper.selectAll();
            List<InstorelistView> instorelistViews=new ArrayList<>();
            Import impo;

            for(int i=0;i<instores.size();i++){
                InstorelistView instorelistView=new InstorelistView();
                impo=importMapper.selectByPrimaryKey(instores.get(i).getImportId());
                instorelistView.setImpo(importMapper.selectByPrimaryKey(instores.get(i).getImportId()));
                instorelistView.setDriver(userMapper.selectByPrimaryKey(instores.get(i).getDriverId()));
                instorelistView.setInstore(instores.get(i));
                instorelistView.setKeeper(userMapper.selectByPrimaryKey(instores.get(i).getKeeperId()));
                instorelistView.setStoreHouse(storeHouseMapper.selectByPrimaryKey(instores.get(i).getStoreId()));
                instorelistView.setSupplier(userMapper.selectByPrimaryKey(impo.getSupplierId()));
                instorelistView.setBuyer(userMapper.selectByPrimaryKey(impo.getBuyerId()));
                instorelistViews.add(instorelistView);
            }
            return instorelistViews;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<InstorelistView> getAllinstoreBystoreId(Long storeId){
        try{
            List<Instore> instores=instoreMapper.selectAll();
            List<InstorelistView> instorelistViews=new ArrayList<>();
            Import impo;

            for(int i=0;i<instores.size();i++){
                InstorelistView instorelistView=new InstorelistView();
                impo=importMapper.selectByPrimaryKey(instores.get(i).getImportId());
                instorelistView.setImpo(importMapper.selectByPrimaryKey(instores.get(i).getImportId()));
                instorelistView.setDriver(userMapper.selectByPrimaryKey(instores.get(i).getDriverId()));
                instorelistView.setInstore(instores.get(i));
                instorelistView.setKeeper(userMapper.selectByPrimaryKey(instores.get(i).getKeeperId()));
                instorelistView.setStoreHouse(storeHouseMapper.selectByPrimaryKey(instores.get(i).getStoreId()));
                instorelistView.setSupplier(userMapper.selectByPrimaryKey(impo.getSupplierId()));
                instorelistView.setBuyer(userMapper.selectByPrimaryKey(impo.getBuyerId()));
                instorelistViews.add(instorelistView);
            }
            return instorelistViews;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Instore addInstore(Instore instore){
        try{
            if(instore.getDriverId()!=null&&instore.getImportId()!=null&&instore.getKeeperId()!=null&&instore.getStoreId()!=null&&instore.getTotalprice()!=null&&instore.getTotalweight()!=null)
            {
                if(userMapper.selectByPrimaryKey(instore.getKeeperId())!=null&&userMapper.selectByPrimaryKey(instore.getDriverId())!=null&&storeHouseMapper.selectByPrimaryKey(instore.getStoreId())!=null&&importMapper.selectByPrimaryKey(instore.getImportId())!=null){
                    instore.setCreationDate(new Date());
                    instoreMapper.insertUseGeneratedKeys(instore);
                    return instoreMapper.selectByPrimaryKey(instore.getId());
            }
            else {
                    return null;
                }
            }
            else  return null;

        }catch (Exception e){
            return null;
        }
    }
    //将instoreitem加到仓库里面，修改仓库数量
    @Override
    public Instore addInstoreDone(Long instoreId)
    {
        try{
            Instore instore=instoreMapper.selectByPrimaryKey(instoreId);
            instore.setLastUpdateDate(new Date());
            instore.setState("入库完成");
            instoreMapper.updateByPrimaryKey(instore);
            Import impo=importMapper.selectByPrimaryKey(instore.getImportId());
            impo.setLastUpdateDate(new Date());
            impo.setState("配送完成，已入库");
            impo.setKeeperId(instore.getKeeperId());
            importMapper.updateByPrimaryKey(impo);
            boolean bool=true;
            int i,j;

            //修改仓库数量
            List<InstoreItem> instoreItems=instoreItemMapper.getAllByinstoreId(instoreId);
            List<StoreItem> storeItems=storeItemMapper.getStoreItemBystoreId(instore.getStoreId());

            for(i=0;i<instoreItems.size();i++)
            {
                int count=0;
                for(j=0;j<storeItems.size();j++)
                {
                    if(instoreItems.get(i).getName().equals(storeItems.get(j).getName())){
                        bool=true;
                        storeItems.get(j).setNumber(storeItems.get(j).getNumber()+instoreItems.get(i).getNumber());
                        storeItems.get(j).setLastUpdateDate(new Date());
                        storeItemMapper.updateByPrimaryKey(storeItems.get(j));
                    }
                    else {
                        count++;
                    }
                }
                if(count==storeItems.size())
                {
                    InstoreItem instoreItem=instoreItemMapper.selectByPrimaryKey(instoreItems.get(i).getId());
                    StoreItem storeItem=new StoreItem();
                    storeItem.setStoreId(instore.getStoreId());
                    storeItem.setVegesId(instoreItem.getVegesId());
                    storeItem.setName(instoreItem.getName());
                    storeItem.setNumber(instoreItem.getNumber());
                    storeItem.setCreationDate(new Date());

                    storeItemMapper.insertUseGeneratedKeys(storeItem);
                }
            }

            return instoreMapper.selectByPrimaryKey(instoreId);
        }catch (Exception e){
            return null;
        }
    }
}
