package dhu.sun.vege.controller;

import dhu.sun.vege.entity.SuppliertoVeges;
import dhu.sun.vege.entity.Veges;
import dhu.sun.vege.service.SuppliertoVegesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Created by think on 2018/3/28.
 */
@RestController
@RequestMapping("/api")
public class SuppliertoVegesController {
    @Autowired
    private SuppliertoVegesService suppliertoVegesService;

    @GetMapping ("/delsuppveges")
    @ApiOperation("根据蔬菜id和供应商id删除记录")
   /* @PreAuthorize("hasAnyAuthority('all')")*/
    public Veges deleteByvegesIdsuppId(@RequestParam Long vegesId, @RequestParam Long supplierId){
        return suppliertoVegesService.deleteByvegesIdsuppId(vegesId,supplierId);
    }

    @GetMapping("/addsuppveges")
    @ApiOperation("根据蔬菜名称和供应商id添加一条记录")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public String addByvegesNamesuppId(@RequestParam Long supplierId,@RequestParam  String name){
        return suppliertoVegesService.addByvegesNamesuppId(supplierId,name);
    }

}
