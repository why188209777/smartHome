package com.chongya.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.chongya.entity.User;
import com.chongya.mapper.UserMapper;
import com.chongya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version="1.0.0",interfaceClass= UserService.class)
@org.springframework.stereotype.Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int updateUser(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public User getUserBySid(int uid) {
        return userMapper.selectById(uid);
    }
}
