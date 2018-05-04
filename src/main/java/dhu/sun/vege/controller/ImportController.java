package dhu.sun.vege.controller;

import dhu.sun.vege.entity.Import;
import dhu.sun.vege.model.view.ImpolistView;
import dhu.sun.vege.service.ImportService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by think on 2018/3/30.
 */
@RestController
@RequestMapping("/api")
public class ImportController {
    @Autowired
    private ImportService importService;

    /**
     * 添加一条进货单，此时未添加明细，状态为“未完成”
     */
    @PostMapping("/addimport")
    @ApiOperation("添加一条进货单")
    @PreAuthorize("hasAnyAuthority('buyer')")
   public Import addImport(@RequestBody Import addimpo)
    {
        return importService.addImport(addimpo);
    }

    /**
     * 添加一条进货单，添加明细完成后，状态为“完成进货”
     */
    @GetMapping("/addimpodone")
    @ApiOperation("明细添加完后，修改进货单状态")
    @PreAuthorize("hasAnyAuthority('buyer')")
    public Import addImportDone(@RequestParam Long importId){
        return importService.addImportDone(importId);
    }

    /**
     * 根据采购员id获取进货单列表
     */
    @GetMapping("/getimpos")
    @ApiOperation("根据采购员id获取对应进货单")
    @PreAuthorize("hasAnyAuthority('buyer')")
    public List<ImpolistView> getImpoBybuyerId(@RequestParam Long buyerId){

        return importService.getImpoBybuyerId(buyerId);
    }

    /**
     * 根据司机id获取进货单列表
     */
    @GetMapping("/getdriverimpos")
    @ApiOperation("根据司机id获取进货单")
    @PreAuthorize("hasAnyAuthority('driver')")
    public List<ImpolistView> getImpoBydriverId(@RequestParam Long driverId){
        return importService.getImpoBydriverId(driverId);
    }

    @GetMapping("/getcurrentimpo")
    @ApiOperation("根据司机id获取该司机当前进货单")
    @PreAuthorize("hasAnyAuthority('keeper')")
    public ImpolistView getCurrentImpoBydrivId(@RequestParam Long driverId){
        return importService.getCurrentImpoByDrivId(driverId);
    }


    @GetMapping("/changeimpostate")
    @ApiOperation("司机确认配送后修改进货单的状态为配送中")
    @PreAuthorize("hasAnyAuthority('driver')")
    public Import changeImpoStateBydriver(@RequestParam Long importId){
        return importService.changeImpoStateBydriver(importId);
    }

    @GetMapping("/getByimportId")
    @ApiOperation("根据进货单id获取import")
    @PreAuthorize("hasAnyAuthority('keeper')")
    public Import getByimportId(@RequestParam Long importId){
        return importService.getByimportId(importId);
    }


    @GetMapping("/getallimpo")
    @ApiOperation("获取所有的进货单")
    @PreAuthorize("hasAnyAuthority('office')")
    public List<ImpolistView> getAllimport()
    {
        return importService.getAllimport();
    }
}
