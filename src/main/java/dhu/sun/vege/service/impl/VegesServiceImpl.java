package dhu.sun.vege.service.impl;

import dhu.sun.vege.entity.Type;
import dhu.sun.vege.entity.Veges;
import dhu.sun.vege.mapper.TypeMapper;
import dhu.sun.vege.mapper.VegesMapper;
import dhu.sun.vege.model.view.Vegeslist;
import dhu.sun.vege.service.VegesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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

    @Override
    public List<Veges> getAllVeges(){
        return vegesMapper.selectAll();
    }

    @Override
    public Veges addVeges(Veges veges){
        try{
            veges.setCreationDate(new Date());
            vegesMapper.insertUseGeneratedKeys(veges);
            return vegesMapper.selectByPrimaryKey(veges.getId());
        }catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public Veges getVegesById(Long vegesId){
        try{
            return vegesMapper.selectByPrimaryKey(vegesId);
        }catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public Veges changeVeges(Veges veges){
        try{

            veges.setLastUpdateDate(new Date());
            vegesMapper.updateByPrimaryKey(veges);
            return vegesMapper.selectByPrimaryKey(veges.getId());
        }catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public Veges changeStateOn(Long vegesId)
    {
        try{
            Veges veges=vegesMapper.selectByPrimaryKey(vegesId);
            veges.setLastUpdateDate(new Date());
            veges.setState("上架");
            vegesMapper.updateByPrimaryKey(veges);
            return vegesMapper.selectByPrimaryKey(vegesId);
        }catch (Exception e)
        {
            return  null;
        }
    }

    @Override
    public Veges changeStateOff(Long vegesId)
    {
        try {
            Veges veges=vegesMapper.selectByPrimaryKey(vegesId);
            veges.setLastUpdateDate(new Date());
            veges.setState("下架");
            vegesMapper.updateByPrimaryKey(veges);
            return vegesMapper.selectByPrimaryKey(vegesId);
        }catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<Vegeslist> getOnVeges()
    {
        try{
            List<Veges> veges=vegesMapper.getOnVeges();
            List<Vegeslist> vegeslists=new ArrayList<>();

            for(int i=0;i<veges.size();i++)
            {
                Vegeslist vegeslist=new Vegeslist();
                vegeslist.setVeges(veges.get(i));
                vegeslist.setType(typeMapper.selectByPrimaryKey(veges.get(i).getTypeId()));
                vegeslists.add(vegeslist);
            }

            return vegeslists;
        }catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public Veges addPicpath(String pth,Long vegesId){
        try{
            Veges veges=vegesMapper.selectByPrimaryKey(vegesId);
            veges.setPth(pth);
            veges.setLastUpdateDate(new Date());
            vegesMapper.updateByPrimaryKey(veges);
            return veges;
        }catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public Veges addVegesPath(Long vegesId,String pth)
    {
        try{
            Veges veges=vegesMapper.selectByPrimaryKey(vegesId);
            veges.setLastUpdateDate(new Date());
            veges.setPth(pth);
            vegesMapper.updateByPrimaryKey(veges);

            return vegesMapper.selectByPrimaryKey(vegesId);
        }catch (Exception e)
        {
            return null;
        }
    }
}
