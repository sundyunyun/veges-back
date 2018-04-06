package dhu.sun.vege.controller;

import dhu.sun.vege.entity.InstoreItem;
import dhu.sun.vege.service.InstoreItemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
