package dhu.sun.vege.controller;

import dhu.sun.vege.entity.Type;
import dhu.sun.vege.service.TypeService;
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
public class TypeController {
    @Autowired
    private TypeService typeService;

    @PostMapping("addtype")
    @ApiOperation("添加种类")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public Type addType(@RequestBody Type type){
        return typeService.addType(type);
    }

    @GetMapping("getalltype")
    @ApiOperation("获取所有的蔬菜种类")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public List<Type> getAlltype(){
        return typeService.getAlltype();
    }
}
