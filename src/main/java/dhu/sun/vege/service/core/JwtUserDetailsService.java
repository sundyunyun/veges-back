package dhu.sun.vege.service.core;

import dhu.sun.vege.entity.Auth;
import dhu.sun.vege.entity.Role;
import dhu.sun.vege.mapper.AuthMapper;
import dhu.sun.vege.mapper.RoleMapper;
import dhu.sun.vege.model.core.JwtUserDetails;
import dhu.sun.vege.entity.User;
import dhu.sun.vege.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * Description
 *
 * @author
 * @date 2017/12/7
 */

public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AuthMapper authMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        JwtUserDetails userDetails = new JwtUserDetails();
        User user = userMapper.selectUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<Auth> auths = authMapper.selectAuthListByUserId(user.getId());
        Role role = roleMapper.selectRoleByUserId(user.getId());

        userDetails.setAuths(auths);
        userDetails.setUser(user);
        userDetails.setRole(role);

        return userDetails;
    }
}
