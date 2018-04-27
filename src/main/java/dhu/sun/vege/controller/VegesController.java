package dhu.sun.vege.controller;

import dhu.sun.vege.constants.AppConst;
import dhu.sun.vege.entity.Veges;
import dhu.sun.vege.model.view.Vegeslist;
import dhu.sun.vege.service.VegesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

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


    @GetMapping("/getvegesById")
    @ApiOperation("根据菜品Id获取蔬菜信息")
   /* @PreAuthorize("hasAnyAuthority('all')")*/
    public Veges getVegesById(@RequestParam Long vegesId){
        return vegesService.getVegesById(vegesId);
    }


    @PutMapping("/changeveges")
    @ApiOperation("修改菜品信息")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public Veges changeVeges(@RequestBody Veges veges)
    {
        return vegesService.changeVeges(veges);
    }


    @GetMapping("/changeon")
    @ApiOperation("改菜品状态为上架，卖了")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public Veges changeStateOn(@RequestParam Long vegesId)
    {
        return vegesService.changeStateOn(vegesId);
    }

    @GetMapping("/changeoff")
    @ApiOperation("改菜品状态为下架，不卖了")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public Veges changeStateOff(@RequestParam Long vegesId)
    {
        return vegesService.changeStateOff(vegesId);
    }

    @GetMapping("/getonveges")
    @ApiOperation("获取所有在售的上架蔬菜")
/*    @PreAuthorize("hasAnyAuthority('all')")*/
    public List<Vegeslist> getOnVeges()
    {
        return vegesService.getOnVeges();
    }

    @PostMapping("/file")
    public String uploadFile(@RequestParam MultipartFile upload) {
       // String fileName=upload.getOriginalFilename();
//        String path = "C:/Users/think/Desktop/imgs/";

        String originalFileName = upload.getOriginalFilename();
        //新的文件名称
        String newFileName;
        //有后缀保存后缀,无后缀直接UUID
        if (originalFileName.contains(".")) {
            newFileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
        } else {
            newFileName = UUID.randomUUID() + "";
        }
        File file = new File(AppConst.basePath + newFileName);

        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        try {
            upload.transferTo(file.getAbsoluteFile());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return newFileName;
    }

    @GetMapping("/addvegespath")
    @ApiOperation("为新添加的蔬菜根据蔬菜id添加图片路径")
  /*  @PreAuthorize("hasAnyAuthority('all')")*/
    public Veges addVegesPath(@RequestParam Long vegesId,@RequestParam String pth)
    {
        return vegesService.addVegesPath(vegesId,pth);
    }
}
