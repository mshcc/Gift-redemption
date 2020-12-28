package com.siro.consumer.controller.backstage;

import com.google.code.kaptcha.Producer;
import com.siro.consumer.security.JwtAuthenticatioToken;
import com.siro.consumer.security.JwtTokenUtils;
import com.siro.consumer.security.SecurityUtils;
import com.siro.consumer.service.UserLoginService;
import com.siro.consumer.service.UserService;
import com.siro.consumer.utils.IOUtils;
import com.siro.http.HttpResult;
import com.siro.model.User;
import com.siro.page.PageRequest;
import com.siro.vo.UpdateUserBean;
import com.siro.vo.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author mshcc
 * @date 2020/12/27
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private Producer producer;
    @GetMapping("captcha")
    public void captcha( HttpServletResponse response,  HttpServletRequest request) throws IOException {
        String captcha = userService.captcha(response, request);
        BufferedImage image = producer.createImage(captcha);
        ServletOutputStream out = response.getOutputStream();
        response.setContentType("image/jpeg");
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    @PostMapping("login")
    public HttpResult login(@RequestBody UserBean userBean,   HttpServletRequest request){
        String username = userBean.getUsername();
        String captcha = userBean.getCaptcha();
        String password = userBean.getPassword();
        String kaptcha = (String) redisTemplate.opsForValue().get("captcha");
        if (kaptcha == null) {
            return HttpResult.error("验证码已失效");
        }
        if (!captcha.equals(kaptcha)) {
            return HttpResult.error("验证码错误");
        }
        User user = userLoginService.findByName(username);
        if (user == null) {
            return HttpResult.error("用户名不存在");
        }

        JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);
//        redisTemplate.opsForValue().set("jwtToken",JwtTokenUtils.getSECRET(),30, TimeUnit.MINUTES);
        return HttpResult.ok(token);
    }
    @PreAuthorize("hasAuthority('super')")
    @PostMapping("register")
    public HttpResult register(@RequestBody UserBean userBean, HttpServletRequest request){
        return userService.register(userBean,request);
    }
    @PreAuthorize("hasAuthority('super')")
    @PostMapping("updateUser/{id}")
    public HttpResult update(@RequestBody UpdateUserBean registerBean, @PathVariable int id){
        return userService.update(registerBean,id);
    }
    @PreAuthorize("hasAuthority('super')")
    @PostMapping("deleteUser/{id}")
    public HttpResult delete(@PathVariable int id) {
        return userService.delete(id);
    }

    @PostMapping("listUser")
    public HttpResult listUser(@RequestBody PageRequest pageRequest) {
        return userService.listUser(pageRequest);
    }


}
