package com.example.upload702.controller;

import com.example.upload702.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping("/doLogin")
    public int doLogin(User user){
        Subject subject = SecurityUtils.getSubject();
        if(!subject.isAuthenticated()){
            try{
                UsernamePasswordToken token = new UsernamePasswordToken(user.getUserno(),user.getPassword());
                subject.login(token);
                return 1;
            }catch (Exception e){
                e.printStackTrace();
                return 2;
            }
        }else {
            return 3;
        }
    }

    @RequestMapping("/logout")
    public int logout() {
        int code = 0;
        try{
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            code = 1;
        }catch (Exception e){

        }
        return code;
    }

}
