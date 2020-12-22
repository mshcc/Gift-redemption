package com.siro.demo.controller;

import com.siro.demo.dao.IUserDao;
import com.siro.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author mshcc
 * @date 2020/12/22
 */
@RestController
public class LoginController {
    @Autowired
    private IUserDao userDao;
    @GetMapping("/login")
    public void login(@RequestParam String username,
                      @RequestParam String password,
                      HttpSession session,
                      RedirectAttributes attributes) {

    }
    @PostMapping("/listAll")
    public List<User> getAll(){
        return userDao.findAll();
    }
    @PostMapping("/addUser")
    public Integer addUser(
            @RequestParam String username,
            @RequestParam String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userDao.addUser(user);
    }
    @PostMapping("/delete")
    public Integer deleteUser(@RequestParam Integer id){
        return userDao.deleteById(id);
    }
    @PostMapping("/findOne")
    public User findById(@RequestParam Integer id){
        return userDao.findUserById(id);
    }

}
