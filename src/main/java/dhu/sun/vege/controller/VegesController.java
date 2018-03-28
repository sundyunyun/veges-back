package dhu.sun.vege.controller;

import dhu.sun.vege.entity.Veges;
import dhu.sun.vege.service.VegesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
