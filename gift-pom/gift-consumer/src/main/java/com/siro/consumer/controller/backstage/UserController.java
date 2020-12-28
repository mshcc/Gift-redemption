package com.siro.consumer.controller.backstage;

import com.google.code.kaptcha.Producer;
import com.siro.consumer.service.UserService;
import com.siro.consumer.utils.IOUtils;
import com.siro.http.HttpResult;
import com.siro.page.PageRequest;
import com.siro.vo.UpdateUserBean;
import com.siro.vo.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author mshcc
 * @date 2020/12/27
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private Producer producer;
    @GetMapping("captcha")
    public void captcha( HttpServletResponse response,  HttpServletRequest request) throws IOException {
        String captcha = userService.captcha(response, request);
        BufferedImage image = producer.createImage(captcha);
        // 保存到验证码到 session
        request.getSession().setAttribute("captcha", captcha);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    @PostMapping("login")
    public HttpResult login(@RequestBody UserBean userBean,   HttpServletRequest request){
        return userService.login(userBean,request);
    }
    @PostMapping("register")
    public HttpResult register(@RequestBody UserBean userBean, HttpServletRequest request){
        return userService.register(userBean,request);
    }

    @PostMapping("updateUser/{id}")
    public HttpResult update(@RequestBody UpdateUserBean registerBean, @PathVariable int id){
        return userService.update(registerBean,id);
    }

    @PostMapping("deleteUser/{id}")
    public HttpResult delete(@PathVariable int id) {
        return userService.delete(id);
    }

    @PostMapping("listUser")
    public HttpResult listUser(@RequestBody PageRequest pageRequest) {
        return userService.listUser(pageRequest);
    }


}
