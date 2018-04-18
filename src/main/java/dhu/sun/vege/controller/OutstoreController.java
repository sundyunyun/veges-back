package dhu.sun.vege.controller;

import dhu.sun.vege.entity.Outstore;
import dhu.sun.vege.model.view.OutstorelistView;
import dhu.sun.vege.service.OutstoreService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by think on 2018/4/9.
 */
@RestController
@RequestMapping("/api")
public class OutstoreController {
    @Autowired
    private OutstoreService outstoreService;


    @GetMapping("/getalloutstore")
    @ApiOperation("获取所有出库单")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public List<OutstorelistView> getAllOutstore()
    {
        return outstoreService.getAllOutstore();
    }

    @GetMapping("/getoutstoreBystoreId")
    @ApiOperation(("根据仓库id获取出库单"))
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public List<OutstorelistView> getAllByStoreId(@RequestParam Long storeId)
    {
        return outstoreService.getAllBystoreId(storeId);
    }

    @PostMapping("/addoutstore")
    @ApiOperation("前台传一个outstore，生成一条出库单")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public Outstore addOutstore(@RequestBody Outstore addoutstore)
    {
        return outstoreService.addOutstore(addoutstore);
    }

    @GetMapping("/addoutstoredone")
    @ApiOperation("添加出库单完成，修改出库单状态以及订单状态，修改仓库菜品数量")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public Outstore addOutstoreDone(@RequestParam Long outstoreId)
    {
        return outstoreService.addOutstoreDone(outstoreId);
    }
}
