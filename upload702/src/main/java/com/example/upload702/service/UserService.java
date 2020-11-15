package com.example.upload702.service;

import com.example.upload702.entity.User;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lilin
 * @since 2020-06-21
 */
public interface UserService extends IService<User> {

    String checkUser(User user);

}
