package dhu.sun.vege.controller;

import dhu.sun.vege.entity.Veges;
import dhu.sun.vege.service.VegesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by think on 2018/3/27.
 */
@RestController
@RequestMapping("/api")
public class VegesController {

    @Autowired
    private VegesService vegesService;



    @GetMapping("/supplier/veges")
    @ApiOperation("根据获取供应商菜品信息")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public List<Veges> getVegesListBySupplierId(@RequestParam Long supplierId)
    {
        return vegesService.getVegesListBySupplierId(supplierId);
    }

    @GetMapping("/allveges")
    @ApiOperation("获取数据库所有的蔬菜")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public List<Veges> getAllVeges(){
        return vegesService.getAllVeges();
    }

    @PostMapping("/addveges")
    @ApiOperation("添加一条蔬菜")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public Veges addVeges(@RequestBody Veges veges){
        return vegesService.addVeges(veges);
    }
}
