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
   /* @PreAuthorize("hasAnyAuthority('all')")*/
   public Import addImport(@RequestBody Import addimpo)
    {
        return importService.addImport(addimpo);
    }

    /**
     * 添加一条进货单，添加明细完成后，状态为“完成进货”
     */
    @GetMapping("/addimpodone")
    @ApiOperation("明细添加完后，修改进货单状态")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public Import addImportDone(@RequestParam Long importId){
        return importService.addImportDone(importId);
    }

    /**
     * 根据采购员id获取进货单列表
     */
    @GetMapping("/getimpo")
    @ApiOperation("根据采购员id获取对应进货单")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public List<ImpolistView> getImpoBybuyerId(@RequestParam Long buyerId){

        return importService.getImpoBybuyerId(buyerId);
    }

}
