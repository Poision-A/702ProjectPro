package com.example.upload702.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.example.upload702.entity.User;
import com.example.upload702.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lilin
 * @since 2020-06-21
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/queryUserById")
    public User queryUserById(){
        Map<String,Object> map = new HashMap<>();
        map.put("userno","lilin");
        Wrapper wrapper = new Wrapper() {
            @Override
            public String getSqlSegment() {
                return null;
            }
        }.allEq(map);
        return userService.selectOne(wrapper);
    }

    @RequestMapping("/test1")
    public boolean test1(){
        EntityWrapper<User> userEntityWrapper = new EntityWrapper<>();
        userEntityWrapper.setEntity(new User());
        userEntityWrapper.eq("userno","lilin");
        return userService.delete(userEntityWrapper);
    }
}
