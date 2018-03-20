package dhu.sun.vege.controller;

import dhu.sun.vege.mapper.RoleMapper;
import dhu.sun.vege.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller测试
 *
 * @author Tan Jie
 * @date 2017/12/7
 */
@RestController
@RequestMapping(value = "/api", produces = {"text/html;charset=UTF-8;", "application/json;"})
public class TestController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;


    @GetMapping(value = "/public/test")
    public String open(String msg) {
        return "开放接口,所有人可见," + msg;
    }

    /**
     * 权限严格区分大小写
     */
    @GetMapping("/test1")
    @PreAuthorize("hasAnyAuthority('all')")
    public String test1() {
        return "ALL 权限可见";
    }

    @GetMapping("/test2")
    @PreAuthorize("hasAnyAuthority('auth1')")
    public String test2() {
        return "auth1 权限可见";
    }

    @GetMapping("/test3")
    @PreAuthorize("hasAnyAuthority('auth1','auth2')")
    public String test3() {
        return "auth1 和 auth2 权限可见";
    }

}
