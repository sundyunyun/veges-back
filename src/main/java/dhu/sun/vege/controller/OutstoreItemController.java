package dhu.sun.vege.controller;

import dhu.sun.vege.entity.OutstoreItem;
import dhu.sun.vege.service.OutstoreItemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by think on 2018/4/10.
 */
@RestController
@RequestMapping("/api")
public class OutstoreItemController {
    @Autowired
    private OutstoreItemService outstoreItemService;

    @GetMapping("/getallByoutstoreId")
    @ApiOperation("根据出库单id获取出库明细")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public List<OutstoreItem> getAllitemByoutstoreId(@RequestParam Long outstoreId){
        return outstoreItemService.getAllitemByoutstoreId(outstoreId);
    }

    @PostMapping("/addoutstoreitem")
    @ApiOperation("生成一条出库明细")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public OutstoreItem addOutstoreItem(@RequestBody OutstoreItem outstoreItem)
    {
        return outstoreItemService.addOutstoreItem(outstoreItem);
    }


}
