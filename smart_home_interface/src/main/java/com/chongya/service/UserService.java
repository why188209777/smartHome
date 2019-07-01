package com.chongya.service;

import com.chongya.entity.User;

public interface UserService {
    public int updateUser(User user);

    public User getUserBySid(int uid);

}
