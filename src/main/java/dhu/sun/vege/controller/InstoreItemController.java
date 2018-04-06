package dhu.sun.vege.controller;

import dhu.sun.vege.entity.InstoreItem;
import dhu.sun.vege.service.InstoreItemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by think on 2018/4/5.
 */
@RestController
@RequestMapping("api")
public class InstoreItemController {
    @Autowired
    private InstoreItemService instoreItemService;


    @GetMapping("getallbyinstoreId")
    @ApiOperation("根据instore入库单id获取详情")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public List<InstoreItem> getAllByinstoreId(@RequestParam Long instoreId){
        return instoreItemService.getAllByinstoreId(instoreId);
    }

    @PostMapping("/addinstoreitem")
    @ApiOperation("添加一条入库详情")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public InstoreItem instoreItem(@RequestBody InstoreItem instoreItem){
        return instoreItemService.addInstoreItem(instoreItem);
    }
}
