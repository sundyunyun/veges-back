package dhu.sun.vege.controller;

import dhu.sun.vege.entity.StoreItem;
import dhu.sun.vege.mapper.StoreItemMapper;
import dhu.sun.vege.service.StoreItemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by think on 2018/4/6.
 */
@RestController
@RequestMapping("api")
public class StoreItemController {
    @Autowired
    private StoreItemService storeItemService;


    @GetMapping("/getitembystore")
    @ApiOperation("根据仓库id获取仓库菜品信息")
    @PreAuthorize("hasAnyAuthority('keeper','office')")
    public List<StoreItem> getStoreItemBystoreId(@RequestParam Long storeId){
        return storeItemService.getStoreItemBystoreId(storeId);
    }

    @GetMapping("/delstoreitemByid")
    @ApiOperation("根据id删除明细")
    @PreAuthorize("hasAnyAuthority('keeper','office')")
    public String delStoreitemByid(@RequestParam Long storeitemId){
        return storeItemService.delStoreitemByid(storeitemId);
    }

    @GetMapping("updatestoreitem")
    @ApiOperation("修改仓库某一明细，数量")
    @PreAuthorize("hasAnyAuthority('keeper')")
    public StoreItem updateStoreItemByid(@RequestParam Long storeitemId,@RequestParam Double number){
        return storeItemService.updateStoreitemByid(storeitemId,number);
    }
}
