package dhu.sun.vege.model.view;

import dhu.sun.vege.entity.Auth;
import dhu.sun.vege.entity.Role;
import dhu.sun.vege.entity.User;

import java.util.List;

/**
 * Description
 *
 * @author Tan Jie
 * @date 2017/12/9
 */

public class LoginView {

    private String token;

    private String msg;

    private User user;

    private Role role;

    private List<Auth> auths;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Auth> getAuths() {
        return auths;
    }

    public void setAuths(List<Auth> auths) {
        this.auths = auths;
    }
}
