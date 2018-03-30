package dhu.sun.vege.service.impl;

import dhu.sun.vege.entity.Import;
import dhu.sun.vege.mapper.ImportMapper;
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

    @Override
    public Import addImport(Import impo)
    {
        try{
            if(impo.getTotalweight()!=null&&impo.getSupplierId()!=null&&impo.getTotalprice()!=null&&impo.getStoreId()!=null&&impo.getDriverId()!=null){
                impo.setCreationDate(new Date());
                importMapper.insertUseGeneratedKeys(impo);
                return importMapper.selectByPrimaryKey(impo.getId());
            }
            else
            return null;
        }catch (Exception e){
            return null;
        }
    }

}
