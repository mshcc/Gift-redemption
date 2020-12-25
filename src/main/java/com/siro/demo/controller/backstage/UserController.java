package com.siro.demo.controller.backstage;

import com.google.code.kaptcha.Producer;
import com.siro.demo.utils.page.PageRequest;
import com.siro.demo.utils.page.PageResult;
import com.siro.demo.vo.IntegerBean;
import com.siro.demo.vo.ListIntBean;
import com.siro.demo.vo.UpdateUserBean;
import com.siro.demo.vo.UserBean;
import com.siro.demo.model.User;
import com.siro.demo.security.JwtAuthenticatioToken;
import com.siro.demo.security.SecurityUtils;
import com.siro.demo.service.UserService;
import com.siro.demo.utils.IOUtils;
import com.siro.demo.utils.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author mshcc
 * @date 2020/12/23
 */
@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private Producer producer;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        BufferedImage image = producer.createImage(text);
        // 保存到验证码到 session
        request.getSession().setAttribute("captcha", text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    @PostMapping("login")
    public HttpResult login(@RequestBody UserBean userBean, HttpServletRequest request) {
        String username = userBean.getUsername();
        String captcha = userBean.getCaptcha();
        String password = userBean.getPassword();
        String kaptcha = (String) request.getSession().getAttribute("captcha");
        if (kaptcha == null) {
            return HttpResult.error("验证码已失效");
        }
        if (!captcha.equals(kaptcha)) {
            return HttpResult.error("验证码错误");
        }
        User user = userService.findByName(username);
        if (user == null) {
            return HttpResult.error("用户名不存在");
        }
        JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);
        return HttpResult.ok(token);
    }

    @PostMapping("registerUser")
    @PreAuthorize("hasAuthority('super')")
    public HttpResult register(@RequestBody UserBean userBean, HttpServletRequest request) {
        String username = userBean.getUsername();
        String captcha = userBean.getCaptcha();
        String password = userBean.getPassword();
        String kaptcha = (String) request.getSession().getAttribute("captcha");
        if (kaptcha == null) {
            return HttpResult.error("验证码已失效");
        }
        if (!captcha.equals(kaptcha)) {
            return HttpResult.error("验证码错误");
        }
        User user = userService.findByName(username);
        if (user != null) {
            return HttpResult.error("用户名已存在");
        }
        user = new User();
        user.setUsername(username);
        password = passwordEncoder.encode(password);
        user.setPassword(password);
        user.setCreationtime(new Date());
        userService.insertSelective(user);
        return HttpResult.ok("注册成功");
    }


    @PostMapping("updateUser/{id}")
    @PreAuthorize("hasAuthority('super')")
    public HttpResult update(@RequestBody UpdateUserBean registerBean,@PathVariable int id) {
        User user = userService.selectByPrimaryKey(id);
        if (user == null) {
            return HttpResult.error("用户不存在");
        }
        String username = registerBean.getUsername();
        String password = registerBean.getPassword();
        Integer status = registerBean.getStatus();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setStatus(status);
        userService.updateByPrimaryKeySelective(user);
        return HttpResult.ok("更新成功");
    }

    @PreAuthorize("hasAuthority('super')")
    @PostMapping("deleteUser/{id}")
    public HttpResult delete(@PathVariable int id) {
        userService.deleteByPrimaryKey(id);
        return HttpResult.ok("删除成功");
    }


    @PreAuthorize("hasAuthority('super')")
    @PostMapping("listUser")
    public HttpResult listUser(@RequestBody PageRequest pageRequest) {
        PageResult page = userService.findPage(pageRequest);
        return HttpResult.ok(page);
    }
}
