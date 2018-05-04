package dhu.sun.vege.controller;

import dhu.sun.vege.entity.ImportItem;
import dhu.sun.vege.service.ImportItemService;
import dhu.sun.vege.service.ImportService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by think on 2018/4/1.
 */
@RestController
@RequestMapping("/api")
public class ImportItemController {
    @Autowired
    private ImportItemService importItemService;



    @PostMapping("/addimportitem")
    @ApiOperation("添加一条进货单详情")
    @PreAuthorize("hasAnyAuthority('buyer')")
    public ImportItem addImportItem(@RequestBody ImportItem importItem){
        return importItemService.addImportItem(importItem);
    }

    @GetMapping("/getbyimpoId")
    @ApiOperation("根据importId获取详情记录")
    @PreAuthorize("hasAnyAuthority('buyer','office','keeper','driver')")
    public List<ImportItem> getAllByImportId(@RequestParam Long importId){
        return importItemService.getAllByImportId(importId);
    }

}
