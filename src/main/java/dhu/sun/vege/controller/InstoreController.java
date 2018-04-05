package dhu.sun.vege.controller;

import dhu.sun.vege.model.view.InstorelistView;
import dhu.sun.vege.service.InstoreService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
