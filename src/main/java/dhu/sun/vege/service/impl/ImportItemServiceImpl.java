package dhu.sun.vege.service.impl;

import dhu.sun.vege.entity.ImportItem;
import dhu.sun.vege.mapper.ImportItemMapper;
import dhu.sun.vege.service.ImportItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by think on 2018/4/1.
 */@Service
public class ImportItemServiceImpl implements ImportItemService {

     @Autowired
     private ImportItemMapper importItemMapper;


     @Override
    public ImportItem addImportItem(ImportItem importItem){

         try {
             if(importItem.getNumber()!=null&&importItem.getPrice()!=null&&importItem.getImportId()!=null&&importItem.getVegesId()!=null)
             {
                 importItem.setTotal(importItem.getPrice()*importItem.getNumber());
                 importItem.setCreationDate(new Date());
                 importItemMapper.insertUseGeneratedKeys(importItem);
                 return importItemMapper.selectByPrimaryKey(importItem.getId());
             }
             else
             {
                 return null;
             }

         }catch (Exception e){
             return null;
         }
     }



     @Override
    public List<ImportItem> getAllByImportId(Long importId){
         try{
             return importItemMapper.getAllByImportId(importId);
         }catch (Exception e){
             return null;
         }
     }

}
