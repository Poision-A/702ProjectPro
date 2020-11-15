package com.example.upload702.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.upload702.entity.User;
import com.example.upload702.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/500")
    public String error(){
        return "error";
    }
    @RequestMapping("/index")
    public String index(Model model){
        String userno = (String) SecurityUtils.getSubject().getPrincipal();

        EntityWrapper<User> wrapper = new EntityWrapper<>();
        wrapper.eq("userno",userno);
        User user = userService.selectOne(wrapper);
        if(user.getUsername() == null){
            user.setUsername("未设置");
        }
        model.addAttribute("userInfo",user);
        return "index";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }
}
