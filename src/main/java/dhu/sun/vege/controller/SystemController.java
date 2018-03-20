package dhu.sun.vege.controller;

import dhu.sun.vege.entity.User;
import dhu.sun.vege.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 系统管理,包括用户管理,数据维护,审计日志
 *
 * @author Tan Jie
 * @date 2018/2/1
 */
@RestController
@RequestMapping("/api/public")
public class SystemController {
    @Autowired
    private SystemService systemService;

    @GetMapping("/user")
//    @PreAuthorize("hasAnyAuthority('sys')")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = systemService.getAllUser();

        return new ResponseEntity(users, HttpStatus.OK);
    }
}
