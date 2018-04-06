package dhu.sun.vege.service.impl;

import dhu.sun.vege.entity.InstoreItem;
import dhu.sun.vege.mapper.InstoreItemMapper;
import dhu.sun.vege.mapper.InstoreMapper;
import dhu.sun.vege.service.InstoreItemService;
import dhu.sun.vege.service.InstoreService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by think on 2018/4/5.
 */
@Service
public class InstoreItemServiceImpl implements InstoreItemService{
    @Autowired
    private InstoreItemMapper instoreItemMapper;


    @Override
    public List<InstoreItem> getAllByinstoreId(Long instoreId){
        try{
            return instoreItemMapper.getAllByinstoreId(instoreId);
        }catch (Exception e){
            return  null;
        }
    }
}
