package dhu.sun.vege.controller;

import dhu.sun.vege.service.impl.AuthServiceImpl;
import dhu.sun.vege.entity.User;
import dhu.sun.vege.model.view.LoginView;
import dhu.sun.vege.util.core.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * /api/public路径下为开放接口,不需要身份验证
 *
 * @author Tan Jie
 * @date 2017/12/7
 */
@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private AuthServiceImpl authService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * 每次调用登录接口  返回一个新的token
     */
    @RequestMapping(value = "/public/login", method = RequestMethod.GET)
    /*
    /user       GET     SELECT
    /user       POST    INSERT
    /user       PUT   UPDATE
    /user      DELETE   delete
     */
    public ResponseEntity<LoginView> getToken(HttpServletRequest request,@RequestParam  String username, @RequestParam  String password) throws AuthenticationException {
        LoginView view = authService.login(username, password);
        /*String token = jwtTokenUtil.getTokenFromRequest(request);
        //如果token过期
        if (jwtTokenUtil.isTokenExpired(token)) {
            view.setMsg("这是新的token");
            view.setToken(authService.login(username, password));
        } else {
            view.setMsg("这是旧的token");
            view.setToken(token);
        }*/


        return new ResponseEntity(view, HttpStatus.OK);
    }

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
    }*/

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User register(@RequestBody User addedUser) throws AuthenticationException {
        return authService.register(addedUser);
    }
}