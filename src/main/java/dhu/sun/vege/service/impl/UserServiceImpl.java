package dhu.sun.vege.service.impl;


import dhu.sun.vege.entity.User;
import dhu.sun.vege.mapper.UserMapper;
import dhu.sun.vege.model.core.JwtUserDetails;
import dhu.sun.vege.model.view.LoginView;
import dhu.sun.vege.service.UserService;
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

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.Date;
import java.util.List;

/**
 * Description
 *
 * @author Tan Jie
 * @date 2018/2/1
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserMapper userMapper;

   /* @Autowired
    private LogService logService;*/

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public List<User> getAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public User getUserById(Long id) { return userMapper.selectByPrimaryKey(id); }

/*    @Override
    public User addUser(User user) {
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
           user.setCreationDate();
            userMapper.insertUseGeneratedKeys(user);
            //返回创建成功的用户

            return userMapper.selectByPrimaryKey(user.getId());
        } catch (Exception e) {
            return null;
        }
    }*/

    @Override
    public User updateUser(User user) {
        User u;
        //发生任何异常,返回空
        try {
            //如果修改密码,需要哈希编码
            if (user.getPassword() != null) {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                user.setPassword(encoder.encode(user.getPassword()));
            }
            //设置最后更新时间
           user.setLastUpdateDate(new Date());
            //用户名绝不允许修改
            /*user.setUsername(null);*/
            int a = userMapper.updateByPrimaryKeySelective(user);
            if (a == 0) {
                return null;
            }
            return userMapper.selectByPrimaryKey(user.getId());

        } catch (Exception e) {
            return null;
        }

    }



    @Override
    public User updateUserOneself(User user) {
        try {
            //个人不允许修改的部分
           /* user.setIsEnabled(null);
            user.setIsExpired(null);
            user.setIsLocked(null);*/
   /*         if (validatePassword(id, username, password)) {
                user.setId(id);
                return updateUser(user);
            }
            return null;*/
           /* user.setId(id);*/
            return updateUser(user);
        } catch (Exception e) {//出现任何异常,返回空
            return null;
        }

    }

    @Override
    public List<User> getAllUserByRoleId(Long roleId)
    {
        try{
            return userMapper.getAllUserByRoleId(roleId);
        }catch (Exception e){
            return null;
        }
    }

/*    @Override
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
        String token = jwtTokenUtil.generateToken(userDetails);

        view.setToken(token);
        view.setUser(userDetails.getUser());
        view.setRole(userDetails.getRole());
        view.setAuths(userDetails.getAuths());

       *//* //记录登录日志
        try {
            logService.LogForLogin(userDetails.getId(), "登录系统");
        } catch (Exception e) {
            e.printStackTrace();
        }*//*

        return view;
    }*/

    @Override
    public boolean validatePassword(Long id, String username, String password) {
        try {
            User user = userMapper.selectByPrimaryKey(id);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            //id和用户名匹配且用户名和密码匹配
            return username.equals(user.getUsername()) && encoder.matches(password, user.getPassword());
        } catch (Exception e) {
            return false;
        }
    }


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
    }*//*

    @Override
    public User register(User user) {
        String username = user.getUsername();
        if (userMapper.selectUserByUsername(username) != null) {
            return null;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = user.getPassword();
        user.setPassword(encoder.encode(rawPassword));
//        userToAdd.setRoles(asList("ROLE_USER"));
        userMapper.insert(user);
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
        String token = jwtTokenUtil.generateToken(userDetails);

        view.setToken(token);
        view.setUser(userDetails.getUser());
        view.setRole(userDetails.getRole());
        view.setAuths(userDetails.getAuths());

        return view;
    }

    *//*public String refresh(String oldToken) {
        final String token = oldToken.substring(tokenHead.length());
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUserDetails user = (JwtUserDetails) userDetailsService.loadUserByUsername(username);
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }*/
}
