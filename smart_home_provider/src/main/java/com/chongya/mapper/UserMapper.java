package com.chongya.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chongya.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
