package dhu.sun.vege.controller;


import dhu.sun.vege.entity.User;
import dhu.sun.vege.model.view.SupplierView;
import dhu.sun.vege.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户管理
 *
 * @author Tan Jie
 * @date 2017/12/7
 */
// TODO: 2018/2/13 完成后进行权限控制的调试
@RestController
@RequestMapping( "/api")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加用户
     * <p>
     * 数据校验资料 https://www.cnblogs.com/whgk/p/7191152.html
     */
   /* @PostMapping("/user")
    @ApiOperation("创建用户")
    public User addUser(@RequestBody @Validated User user) {
        return userService.addUser(user);
    }
*/
    /**
     * 修改任何用户信息
     */
    @PutMapping("/user")
    @ApiOperation("修改任意用户信息")
    public User updateUser(@RequestParam Long id, @RequestBody User user) {
        user.setId(id);
        return userService.updateUser(user);
    }

    /**
     * 修改自己的用户信息
     */
    @PutMapping("/user/change")
    @ApiOperation("修改自己的用户信息")
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public User updateUserOneself(@RequestBody User user) {
        return userService.updateUserOneself(user);
    }

    /**
     * 获取所有用户信息
     */
    @GetMapping("/users")
    @ApiOperation("获取所有用户信息")
    //@PreAuthorize("hasAnyAuthority('sys')")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    /**
     * 获取角色信息
     */
    @GetMapping("/user/suppliers")
    @ApiOperation("根据角色Id获取全部该角色用户信息")
   /* @PreAuthorize("hasAnyAuthority('all')")*/
    public List<User> getAllUserByRoleId(@RequestParam Long roleId)
    {
        return userService.getAllUserByRoleId(roleId);

    }

    /**
     * 根据id获取用户信息
     */
    @GetMapping("/user")
    @ApiOperation(("根据id获取用户信息"))
    /*@PreAuthorize("hasAnyAuthority('all')")*/
    public User getOneUser(@RequestParam Long id) {
        return userService.getUserById(id);
    }

    /**
     * 根据id获取用户本身信息
     */



    /*@RequestMapping(value = "/refresh", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(
            HttpServletRequest request) throws AuthenticationException {
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        if (refreshedToken == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        }
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User register(@RequestBody User addedUser) throws AuthenticationException {
        return authService.register(addedUser);
    }*/
}