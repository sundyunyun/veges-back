package dhu.sun.vege.config;

import dhu.sun.vege.filter.JwtAuthenticationTokenFilter;
import dhu.sun.vege.service.core.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Description
 *
 * @author Tan Jie
 * @date 2017/12/7
 */
@Configuration
@EnableWebSecurity//启用web权限
@EnableGlobalMethodSecurity(prePostEnabled = true) //启用方法验证
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    protected UserDetailsService customUserService() {
        return new JwtUserDetailsService();
    }

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                // 设置UserDetailsService
                .userDetailsService(customUserService())
                // 使用BCrypt进行密码的hash
                .passwordEncoder(passwordEncoder());
    }

    // 装载BCrypt密码编码器
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationTokenFilter();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()// 由于使用的是JWT，我们这里不需要csrf
                // 基于token，所以不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/api/public/**").permitAll()
                // 允许对于网站静态资源的无授权访问
                .antMatchers(
                        HttpMethod.GET,
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js"
                ).permitAll()
                .antMatchers("/**").permitAll()//开放部分API 例如获取token的接口
                //.antMatchers("/**").hasIpAddress("127.0.0.1")
                //.antMatchers("/admin/**").access("hasAuthority('ROLE_ADMIN')")
                //.anyRequest().authenticated().and().formLogin().loginPage("/login")
                //.failureUrl("/login?error").permitAll().and().logout().permitAll();
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated();
        // 添加JWT filter
        http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
        //禁用缓存
        http.headers().cacheControl();
    }


    //不需要身份验证  测试时使用的配置
    //@Override
    //protected void configure(HttpSecurity http) throws Exception {
    //    http.authorizeRequests()//配置安全策略
    //            .antMatchers("/**").permitAll()//定义/请求不需要验证.anyRequest().authenticated()//其余的所有请求都需要验证
    //            .and()
    //            .logout()
    //            .permitAll()//定义logout不需要验证
    //            .and()
    //            .formLogin();//使用form表单登录
    //
    //
    //    http.csrf().disable();//禁用CSRF验证
    //
    //
    //}
}

