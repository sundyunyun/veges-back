package dhu.sun.vege.service.impl;

import dhu.sun.vege.entity.Order;
import dhu.sun.vege.entity.Outstore;
import dhu.sun.vege.entity.StoreHouse;
import dhu.sun.vege.entity.User;
import dhu.sun.vege.mapper.OrderMapper;
import dhu.sun.vege.mapper.OutStoreMapper;
import dhu.sun.vege.mapper.StoreHouseMapper;
import dhu.sun.vege.mapper.UserMapper;
import dhu.sun.vege.model.view.OutstorelistView;
import dhu.sun.vege.service.OutstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by think on 2018/4/9.
 */
@Service
public class OutstoreServiceImpl implements OutstoreService{
    @Autowired
    private OutStoreMapper outStoreMapper;

    @Autowired
    private StoreHouseMapper storeHouseMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;


    @Override
    public List<OutstorelistView> getAllOutstore(){
        try {
            List<Outstore> outstores=outStoreMapper.selectAll();
            List<OutstorelistView> outstorelistViews=new ArrayList<>();

            for(int i=0;i<outstores.size();i++)
            {
                OutstorelistView outstorelistView=new OutstorelistView();
                outstorelistView.setOutstore(outstores.get(i));
                outstorelistView.setOrder(orderMapper.selectByPrimaryKey(outstores.get(i).getOrderId()));
                outstorelistView.setDriver(userMapper.selectByPrimaryKey(outstores.get(i).getDriverId()));
                outstorelistView.setKeeper(userMapper.selectByPrimaryKey(outstores.get(i).getKeeperId()));
                outstorelistView.setStoreHouse(storeHouseMapper.selectByPrimaryKey(outstores.get(i).getStoreId()));

                outstorelistViews.add(outstorelistView);
            }
            return  outstorelistViews;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<OutstorelistView> getAllBystoreId(Long storeId)
    {
        try{
            List<Outstore> outstores=outStoreMapper.getAllByStoreId(storeId);
            List<OutstorelistView> outstorelistViews=new ArrayList<>();

            for(int i=0;i<outstores.size();i++)
            {
                OutstorelistView outstorelistView=new OutstorelistView();
                outstorelistView.setOutstore(outstores.get(i));
                outstorelistView.setStoreHouse(storeHouseMapper.selectByPrimaryKey(outstores.get(i).getStoreId()));
                outstorelistView.setKeeper(userMapper.selectByPrimaryKey(outstores.get(i).getKeeperId()));
                outstorelistView.setDriver(userMapper.selectByPrimaryKey(outstores.get(i).getDriverId()));
                outstorelistView.setOrder(orderMapper.selectByPrimaryKey(outstores.get(i).getOrderId()));

                outstorelistViews.add(outstorelistView);
            }
            return outstorelistViews;
        }catch (Exception e)
        {
            return  null;
        }
    }

    @Override
    public Outstore addOutstore(Outstore outstore){
        try {
            if(outstore.getTotalweight()!=null)
            {
                outstore.setCreationDate(new Date());
               outStoreMapper.insertUseGeneratedKeys(outstore);
                return outStoreMapper.selectByPrimaryKey(outstore.getId());
            }
            else
            {
                return null;
            }
        }catch (Exception e)
        {
            return null;
        }
    }
    @Override
    public Outstore addOutstoreDone(Long outstoreId)
    {
        try{

        }catch (Exception e)
        {
            return null;
        }
    }
}
