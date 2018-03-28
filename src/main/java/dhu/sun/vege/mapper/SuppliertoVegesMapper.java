package dhu.sun.vege.mapper;

import dhu.sun.vege.entity.SuppliertoVeges;
import dhu.sun.vege.entity.Veges;
import dhu.sun.vege.util.core.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by think on 2018/3/27.
 */
public interface SuppliertoVegesMapper extends BaseMapper<SuppliertoVeges> {
   /* List<Veges> getVegesBySupplierId(Long supplierId);*/
   void deleteByvegesIdsuppId(@Param("vegesId") Long vegesId, @Param("supplierId") Long supplierId);
}
