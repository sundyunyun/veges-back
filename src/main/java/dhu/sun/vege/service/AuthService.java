package dhu.sun.vege.service;

import dhu.sun.vege.entity.User;
import dhu.sun.vege.model.view.LoginView;

/**
 * 身份认证服务
 *
 * @author
 * @date 2017/12/10
 */

public interface AuthService {
    /**
     * 登录
     */
    LoginView login(String username, String password);

    /**
     * 注册
     */
    User register(User user);
}
