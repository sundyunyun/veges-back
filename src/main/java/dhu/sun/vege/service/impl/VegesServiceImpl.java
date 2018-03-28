package dhu.sun.vege.service.impl;

import dhu.sun.vege.entity.Type;
import dhu.sun.vege.entity.Veges;
import dhu.sun.vege.mapper.TypeMapper;
import dhu.sun.vege.mapper.VegesMapper;
import dhu.sun.vege.service.VegesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by think on 2018/3/27.
 */
@Service
public class VegesServiceImpl implements VegesService {

    @Autowired
    private VegesMapper vegesMapper;

    @Autowired
    private TypeMapper typeMapper;




    //根据供应商获取菜品信息
    @Override
    public List<Veges> getVegesListBySupplierId(Long supplierId)
    {
        Type type;
        List<Veges> veges= vegesMapper.getVegesListBySupplierId(supplierId);
        for(int i=0;i<veges.size();i++)
        {
            type=typeMapper.selectByPrimaryKey(veges.get(i).getTypeId());
            veges.get(i).setDes(type.getType());
        }
        return veges;
    }
}
