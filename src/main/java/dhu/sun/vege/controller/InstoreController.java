package dhu.sun.vege.controller;

import dhu.sun.vege.entity.Instore;
import dhu.sun.vege.model.view.InstorelistView;
import dhu.sun.vege.service.InstoreService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by think on 2018/4/5.
 */
@RestController
@RequestMapping("/api")
public class InstoreController {
    @Autowired
    private InstoreService instoreService;

    @GetMapping("/getallinstorelist")
    @ApiOperation("获取所有入库单信息")
   /* @PreAuthorize("hasAnyAuthority('all')")*/
    public List<InstorelistView> getAllInstorelist(){
        return instoreService.getAllInstorelist();
    }

    @GetMapping("getallinstorebystoreid")
    @ApiOperation("根据仓库id获取该仓库的入库单信息")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public List<InstorelistView> getAllinstoreBystoreId(@RequestParam Long storeId){
        return instoreService.getAllinstoreBystoreId(storeId);
    }

    @PostMapping("/addinstore")
    @ApiOperation("添加一条入库单")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public Instore addInstore(@RequestBody Instore instore){
        return instoreService.addInstore(instore);
    }

    @GetMapping("/addinstoredone")
    @ApiOperation("添加入库单成功，修改入库单状态为入库完成")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public Instore addInstoreDone(@RequestParam Long instoreId){
        return instoreService.addInstoreDone(instoreId);
    }
}
