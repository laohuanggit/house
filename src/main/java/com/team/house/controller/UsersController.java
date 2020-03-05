package com.team.house.controller;

import com.team.house.entity.Users;
import com.team.house.service.UsersService;
import com.team.house.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin(value = "*",allowCredentials = "true")//身份验证 支持axios的session共享
public class UsersController {
    @Autowired
    private UsersService usersService;
    @RequestMapping("userReg")
    public String userReg(Users users){
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        int temp=usersService.usersReg(users);
        return "{\"result\":"+temp+"}";
    }

    @RequestMapping("userLogin")
    public String userLogin(String name, String password, HttpSession session){
       Users users=usersService.usersLogin(name,password);
       if (users==null){
           return "{\"result\":0}";
       }else{
           session.setAttribute("user",users);
           return "{\"result\":1}";
       }
    }
}
