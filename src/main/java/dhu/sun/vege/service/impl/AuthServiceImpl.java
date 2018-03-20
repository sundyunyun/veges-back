package dhu.sun.vege.service.impl;

import dhu.sun.vege.entity.Department;
import dhu.sun.vege.entity.User;
import dhu.sun.vege.mapper.DepartmentMapper;
import dhu.sun.vege.mapper.UserMapper;
import dhu.sun.vege.model.core.JwtUserDetails;
import dhu.sun.vege.model.view.LoginView;
import dhu.sun.vege.service.AuthService;
import dhu.sun.vege.util.core.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

   /* @Autowired
    public AuthServiceImpl(
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            JwtTokenUtil jwtTokenUtil,
            SysUserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userRepository = userRepository;
    }*/

    @Override
    public User register(User user) {
        Department department;
        String username = user.getUsername();
        if (userMapper.selectUserByUsername(username) != null) {
            return null;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = user.getPassword();
        user.setPassword(encoder.encode(rawPassword));
        user.setRoleId(new Long(1));
        user.setDeptId(new Long(1));
//        userToAdd.setRoles(asList("ROLE_USER"));
        userMapper.insert(user);

        //部门人数要加一客户角色、部门设定
        department=departmentMapper.selectByPrimaryKey(user.getDeptId());
        department.setNumber(department.getNumber()+1);
        departmentMapper.updateByPrimaryKey(department);
        //返回给前台user对象
        return userMapper.selectByPrimaryKey(user.getId());
    }

    @Override
    public LoginView login(String username, String password) {
        LoginView view = new LoginView();
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        // Perform the security
        Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Reload password post-security so we can generate token
        JwtUserDetails userDetails = (JwtUserDetails) userDetailsService.loadUserByUsername(username);
        String token  = jwtTokenUtil.generateToken(userDetails);

        view.setToken(token);
        view.setUser(userDetails.getUser());
        view.setRole(userDetails.getRole());
        view.setAuths(userDetails.getAuths());

        return view;
    }

    /*public String refresh(String oldToken) {
        final String token = oldToken.substring(tokenHead.length());
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUserDetails user = (JwtUserDetails) userDetailsService.loadUserByUsername(username);
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }*/
}
