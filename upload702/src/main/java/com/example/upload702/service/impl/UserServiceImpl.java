package com.example.upload702.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.upload702.entity.User;
import com.example.upload702.mapper.UserMapper;
import com.example.upload702.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lilin
 * @since 2020-06-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Override
    public String checkUser(User user) {
        User checkUser = null;
        EntityWrapper<User> wrapper = new EntityWrapper<>();
        if(!StringUtils.isEmpty(user.getUserno())){
            wrapper.eq("userno",user.getUserno());
        }
        else if(!StringUtils.isEmpty(user.getUsername())){
            wrapper.eq("username",user.getUsername());
        }
        else if(!StringUtils.isEmpty(user.getPhone())){
            wrapper.eq("phone",user.getPhone());
        }
        checkUser = userService.selectOne(wrapper);
        if (checkUser != null){
            return "used";
        }else{
            return "unUse";
        }
    }
}
