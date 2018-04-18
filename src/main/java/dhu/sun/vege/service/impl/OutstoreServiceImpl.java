package dhu.sun.vege.service.impl;

import dhu.sun.vege.entity.*;
import dhu.sun.vege.mapper.*;
import dhu.sun.vege.model.view.OutstorelistView;
import dhu.sun.vege.service.OutstoreService;
import org.springframework.aop.target.LazyInitTargetSource;
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

    @Autowired
    private OutstoreItemMapper outstoreItemMapper;

    @Autowired
    private StoreItemMapper storeItemMapper;


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
            Outstore outstore=outStoreMapper.selectByPrimaryKey(outstoreId);
            outstore.setLastUpdateDate(new Date());
            outstore.setState("入库完成");
            outStoreMapper.updateByPrimaryKey(outstore);

            Order order=orderMapper.selectByPrimaryKey(outstore.getOrderId());
            order.setState("配送中");
            order.setLastUpdateDate(new Date());
            orderMapper.updateByPrimaryKey(order);

            //修改仓库菜品数量
            List<OutstoreItem> outstoreItems=outstoreItemMapper.getAllitemByoutstoreId(outstoreId);
            List<StoreItem> storeItems=storeItemMapper.getStoreItemBystoreId(outstore.getStoreId());

            for(int i=0;i<outstoreItems.size();i++)
            {
                for(int j=0;j<storeItems.size();j++)
                {
                    if(outstoreItems.get(i).getName().equals(storeItems.get(j).getName()))
                    {
                        storeItems.get(j).setNumber(storeItems.get(j).getNumber()-outstoreItems.get(i).getNumber());
                        storeItems.get(j).setLastUpdateDate(new Date());
                        storeItemMapper.updateByPrimaryKey(storeItems.get(j));
                    }
                }
            }
            return outstore;
        }catch (Exception e)
        {
            return null;
        }
    }
}
