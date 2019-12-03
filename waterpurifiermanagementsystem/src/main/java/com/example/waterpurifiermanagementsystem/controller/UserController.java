package com.example.waterpurifiermanagementsystem.controller;

import com.example.waterpurifiermanagementsystem.pojo.User;
import com.example.waterpurifiermanagementsystem.service.UserService;
import com.example.waterpurifiermanagementsystem.util.Result;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/findAll")
    public Result findAll(Integer page,Integer rows){
        return userService.findAll(page,rows);
    }

    @PostMapping("/insert")
    public Result insert(User record){
        return userService.insert(record);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam("id[]") Integer[] id){
        return  userService.delete(id);
    }

    @PostMapping("/update")
    public Result update(User record){
        return userService.update(record);
    }

    @PostMapping("/login")
    public Result login(User user){
        return userService.login(user);
    }

}
