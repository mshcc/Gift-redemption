package com.siro.consumer.service;

import com.siro.consumer.config.FeignConfig;
import com.siro.http.HttpResult;
import com.siro.page.PageRequest;
import com.siro.page.PageResult;
import com.siro.vo.UpdateUserBean;
import com.siro.vo.UserBean;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author mshcc
 * @date 2020/12/27
 */
@FeignClient(name = "gift-back-producer")
public interface UserService {
    @GetMapping("captcha.jpg")
    String captcha(@RequestParam HttpServletResponse response, @RequestParam HttpServletRequest request);

//    @PostMapping("login")
//    public HttpResult login(@RequestBody UserBean userBean, @RequestParam HttpServletRequest request);

    @PostMapping("registerUser")
    public HttpResult register(@RequestBody UserBean userBean, @RequestParam HttpServletRequest request);

    @PostMapping("updateUser/{id}")
    public HttpResult update(@RequestBody UpdateUserBean registerBean, @PathVariable int id);

    @PostMapping("deleteUser/{id}")
    public HttpResult delete(@PathVariable int id) ;


    @PostMapping("listUser")
    public HttpResult listUser(@RequestBody PageRequest pageRequest) ;
}