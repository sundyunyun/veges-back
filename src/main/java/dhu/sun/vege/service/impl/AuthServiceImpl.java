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

import java.util.Date;

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
        try {
            String username = user.getUsername();
            //用户名不允许重复
            if (userMapper.selectUserByUsername(username) != null) {
                return null;
            }
            //对密码进行强哈希编码
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
            //设置创建时间
           user.setCreationDate(new Date());
            user.setRoleId(new Long(1));
            user.setDeptId(new Long(1));
           /* user.setIsEnabled(0001);*/

            userMapper.insert(user);
            //返回创建成功的用户
            // 部门人数要加一客户角色、部门设定
            department=departmentMapper.selectByPrimaryKey(user.getDeptId());
            department.setNumber(department.getNumber()+1);
            departmentMapper.updateByPrimaryKey(department);
            return userMapper.selectByPrimaryKey(user.getId());
        } catch (Exception e) {
            return null;
        }

//        userToAdd.setRoles(asList("ROLE_USER"));
    }

    @Override
    public LoginView login(String username, String password) {

        LoginView view = new LoginView();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        User user = userMapper.selectUserByUsername(username);
        //如果用户名错误
        if (user == null) {
            return null;
        }
        //密码错误,返回空
        if (!encoder.matches(password, user.getPassword())) {
            return null;
        }
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, user.getPassword());
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
