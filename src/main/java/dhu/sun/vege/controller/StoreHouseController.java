package dhu.sun.vege.controller;

import dhu.sun.vege.entity.StoreHouse;
import dhu.sun.vege.service.StoreHouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by think on 2018/4/8.
 */
@RestController
@RequestMapping("api")
public class StoreHouseController {
    @Autowired
    private StoreHouseService storeHouseService;

    @GetMapping("/getallstore")
    @ApiOperation("获取所有的仓库信息")
    @PreAuthorize("hasAnyAuthority('office')")
    public List<StoreHouse> getAllstoreInfo()
    {
        return storeHouseService.getAllstoreInfo();
    }


    @PostMapping("/addstore")
    @ApiOperation("添加一个仓库")
    @PreAuthorize("hasAnyAuthority('office')")
    public StoreHouse addStoreHouse(@RequestBody StoreHouse storeHouse)
    {
        return storeHouseService.addStoreHouse(storeHouse);
    }

    @GetMapping("/abandon")
    @ApiOperation("仓库废弃改状态为废弃")
    @PreAuthorize("hasAnyAuthority('office')")
    public StoreHouse changeStoretoAbandon(@RequestParam Long storeId)
    {
        return storeHouseService.changeStoretoAbandon(storeId);
    }
}
