package dhu.sun.vege.service.impl;

import dhu.sun.vege.entity.Import;
import dhu.sun.vege.entity.User;
import dhu.sun.vege.mapper.ImportMapper;
import dhu.sun.vege.mapper.UserMapper;
import dhu.sun.vege.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by think on 2018/3/30.
 */
@Service
public class ImportServiceImpl implements ImportService {
    @Autowired
    private ImportMapper importMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Import addImport(Import impo)
    {
        User user;
        try{
            if(impo.getTotalweight()!=null&&impo.getSupplierId()!=null&&impo.getTotalprice()!=null&&impo.getStoreId()!=null&&impo.getDriverId()!=null){
                impo.setCreationDate(new Date());
                importMapper.insertUseGeneratedKeys(impo);
                //更新采购员状态
                user =userMapper.selectByPrimaryKey(impo.getBuyerId());
                user.setState("进货中");
                userMapper.updateByPrimaryKey(user);

                return importMapper.selectByPrimaryKey(impo.getId());
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
}
