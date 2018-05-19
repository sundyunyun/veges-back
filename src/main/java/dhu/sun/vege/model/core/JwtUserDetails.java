package dhu.sun.vege.model.core;

import dhu.sun.vege.entity.Role;
import dhu.sun.vege.entity.Auth;
import dhu.sun.vege.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Description
 *
 * @author
 * @date 2017/12/7
 */

public class JwtUserDetails implements UserDetails {
    private Long id;

    private String username;

    private String password;

    private Role role;

    private List<Auth> auths;

    private User user;

    private boolean isAccountNonExpired = true;

    private boolean isAccountNonLocked = true;

    private boolean isEnabled = true;


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Auth> getAuths() {
        return auths;
    }

    public void setAuths(List<Auth> auths) {
        this.auths = auths;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        try {
            isAccountNonExpired = (user.getIsExpired() == 0) ? true : false;
            isAccountNonLocked = (user.getIsLocked() == 0) ? true : false;
            isEnabled = (user.getIsEnabled() == 0) ? false : true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authList = new ArrayList<>();
        List<Auth> auths = this.getAuths();
        for (Auth auth : auths) {
            authList.add(new SimpleGrantedAuthority(auth.getAuth()));
        }
        return authList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }


    @Override
    public boolean isAccountNonExpired() {

        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}