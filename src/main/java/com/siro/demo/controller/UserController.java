package com.siro.demo.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.siro.demo.model.User;
import com.siro.demo.service.UserService;
import com.siro.demo.utils.IOUtils;
import com.siro.demo.utils.PasswordUtils;
import com.siro.demo.utils.RandomStringUtils;
import com.siro.demo.utils.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;

/**
 * @author mshcc
 * @date 2020/12/23
 */
@RestController
@RequestMapping
public class UserController {
    @Autowired
    private Producer producer;
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public HttpResult login(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            @RequestParam("captcha") String captcha,
                            HttpServletRequest request) {
        Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(kaptcha == null){
            return HttpResult.error("验证码已失效");
        }
        if(!captcha.equals(kaptcha)){
            return HttpResult.error("验证码不正确");
        }
        User user = userService.findByName(username);
        if(user == null){
            return  HttpResult.error("用户不存在，请检查");
        }
        if (!PasswordUtils.addSalt(password,user.getSalt()).equals(user.getPassword())) {
            return HttpResult.error("密码错误");
        }
        if(user.getStatus()==0){
            return HttpResult.error("账户被锁定，请联系管理员");
        }
//        JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);
        return HttpResult.ok("");
    }

    @PostMapping("/register")
    public HttpResult register(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("captcha") String captcha,
                               HttpServletRequest request){
        Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(kaptcha == null){
            return HttpResult.error("验证码已失效");
        }
        if(!captcha.equals(kaptcha)){
            return HttpResult.error("验证码不正确");
        }
        User user = new User();
        user.setUsername(username);
        user.setSalt(RandomStringUtils.getString(10));
        user.setPassword(PasswordUtils.addSalt(password,user.getSalt()));
        user.setCreationtime(new Date());
        userService.insertSelective(user);
        //---
        return HttpResult.ok("注册成功");
    }

    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        BufferedImage image = producer.createImage(text);
        // 保存到验证码到 session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }
}
