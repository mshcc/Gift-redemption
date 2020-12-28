package com.siro.back.controller.backstage;

import com.google.code.kaptcha.Producer;
import com.siro.back.service.UserService;
import com.siro.http.HttpResult;
import com.siro.model.User;
import com.siro.page.PageRequest;
import com.siro.page.PageResult;
import com.siro.vo.UpdateUserBean;
import com.siro.vo.UserBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author mshcc
 * @date 2020/12/23
 */
@RestController
@RequestMapping
@Api(tags = "用户操作")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private Producer producer;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation(value = "该接口用于获取验证码")
    @GetMapping("captcha.jpg")
//    public void captcha(HttpServletResponse response, HttpServletRequest request) throws IOException {
    public String captcha(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        // 生成文字验证码
        String text = producer.createText();
//        // 生成图片验证码
//        BufferedImage image = producer.createImage(text);
        // 保存到验证码到 session   feign远程调用时存在session丢失的问题
//        request.getSession().setAttribute("captcha", text);
        // 保存到验证码到 redis
        redisTemplate.opsForValue().set("captcha", text, 5, TimeUnit.MINUTES);
//        System.out.println(request.getSession());
//        ServletOutputStream out = response.getOutputStream();
//        ImageIO.write(image, "jpg", out);
//        IOUtils.closeQuietly(out);
        System.out.println(text);
        return text;
    }

    @ApiOperation(value = "该接口用于登录")
    @PostMapping("login")
    public HttpResult login(@ApiParam(value = "用户", required = true) @RequestBody UserBean userBean, HttpServletRequest request) {
//        String username = userBean.getUsername();
//        String captcha = userBean.getCaptcha();
//        String password = userBean.getPassword();
//        String kaptcha = (String) redisTemplate.opsForValue().get("captcha");
//        if (kaptcha == null) {
//            return HttpResult.error("验证码已失效");
//        }
//        if (!captcha.equals(kaptcha)) {
//            return HttpResult.error("验证码错误");
//        }
//        User user = userService.findByName(username);
//        if (user == null) {
//            return HttpResult.error("用户名不存在");
//        }
//        JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);
        return HttpResult.ok("接口已废弃");
    }

    @ApiOperation(value = "该接口用于注册用户", notes = "新用户无法登录，需管理员更新其状态")
    @PostMapping("registerUser")
    public HttpResult register(@ApiParam(value = "用户", required = true) @RequestBody UserBean userBean, HttpServletRequest request) {
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

    @ApiOperation(value = "该接口用于更新用户状态")
    @PostMapping("updateUser/{id}")
    public HttpResult update(@ApiParam(value = "用户", required = true) @RequestBody UpdateUserBean registerBean, @ApiParam(value = "id", required = true, example = "1") @PathVariable int id) {
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

    @ApiOperation(value = "该接口用于删除用户")
    @PostMapping("deleteUser/{id}")
    public HttpResult delete(@ApiParam(value = "id", required = true, example = "1") @PathVariable int id) {
        userService.deleteByPrimaryKey(id);
        return HttpResult.ok("删除成功");
    }


    @ApiOperation(value = "该接口用于分页查询用户")
    @PostMapping("listUser")
    public HttpResult listUser(@ApiParam(value = "分页请求", required = true) @RequestBody PageRequest pageRequest) {
        PageResult page = userService.findPage(pageRequest);
        return HttpResult.ok(page);
    }
}
