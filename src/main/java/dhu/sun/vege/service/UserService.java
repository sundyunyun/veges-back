package dhu.sun.vege.service;


import dhu.sun.vege.entity.User;
import dhu.sun.vege.model.view.LoginView;
import sun.rmi.server.UnicastServerRef;

import java.util.List;

/**
 * 用户管理:登录,注册,修改(基本信息和角色),查询信息
 * 工作组:添加角色,删除角色,修改角色权限
 *
 * @author
 * @date 2018/2/1
 */

public interface UserService {

    /**
     * 登录
     */
  //  LoginView login(String username, String password);

    /**
     * 验证用户名和密码
     */
    boolean validatePassword(Long id, String username, String password);

    /**
     * 获取所有用户信息
     */
    List<User> getAllUser();

    /**
     * 根据id获取用户信息
     */
    User getUserById(Long id);

    /**
     * 添加用户
     */
   User addUser(User user);

    /**
     * 修改用户信息,用户名和ID不允许修改
     */
    User updateUser(User user);

    /**
     * 修改自己的信息
     */
    User updateUserOneself(User user);

    /**
     * 根据角色ID获取用户信息
     */
    List<User> getAllUserByRoleId(Long roleId);

    User addToBlack(Long id);

    User changeState(Long id);

}
