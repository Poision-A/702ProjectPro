package com.example.upload702.controller;

import com.example.upload702.entity.User;
import com.example.upload702.service.UserService;
import com.example.upload702.utils.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private UserService userService;

    private EncryptionUtil encryptionUtil = new EncryptionUtil();

    @RequestMapping("/userRegister")
    public String userRegister(User user){
        Map<String,String> map = encryptionUtil.encryption(user.getPassword());
        user.setPassword(map.get("password"));
        user.setSalt(map.get("salt"));
        if(userService.insert(user)){
            return "ok";
        }
        return "fail";
    }

    @RequestMapping("/checkInfo")
    public String checkInfo(User user){
        return userService.checkUser(user);
    }


}
