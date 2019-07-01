package com.chongya.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chongya.entity.User;
import com.chongya.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
    @Reference(version="1.0.0")
    private UserService userService;
    @RequestMapping("updatUser")
    public int updateUser(User user){
        user.setUid(1);
        user.setUname("hha");
        user.setPhone("1231");
        user.setEmergency_phone("1313");
        user.setAddress("zhejiang");
        return userService.updateUser(user);
    }
@RequestMapping("getUserBySid/{uid}")
    public User getUserBySid(@PathVariable("uid") int uid){
        return userService.getUserBySid(uid);
    }
}
