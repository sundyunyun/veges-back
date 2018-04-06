package dhu.sun.vege.service.impl;

import dhu.sun.vege.entity.Import;
import dhu.sun.vege.entity.Instore;
import dhu.sun.vege.mapper.ImportMapper;
import dhu.sun.vege.mapper.InstoreMapper;
import dhu.sun.vege.mapper.StoreHouseMapper;
import dhu.sun.vege.mapper.UserMapper;
import dhu.sun.vege.model.view.InstorelistView;
import dhu.sun.vege.service.InstoreService;
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
}
