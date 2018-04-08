package dhu.sun.vege.service.impl;

import dhu.sun.vege.entity.Type;
import dhu.sun.vege.mapper.TypeMapper;
import dhu.sun.vege.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by think on 2018/4/8.
 */
@Service
public class TypeServiceImpl implements TypeService{
    @Autowired
    private TypeMapper typeMapper;



    @Override
    public Type addType(Type type)
    {
        try{
            type.setCreationDate(new Date());
            typeMapper.insertUseGeneratedKeys(type);
            return typeMapper.selectByPrimaryKey(type);
        }catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<Type> getAlltype()
    {
        try{
            return typeMapper.selectAll();
        }catch (Exception e){
            return  null;
        }
    }
}
