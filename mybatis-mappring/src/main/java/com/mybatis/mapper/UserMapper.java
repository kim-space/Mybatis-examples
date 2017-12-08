package com.mybatis.mapper;

import com.mybatis.po.User;

public interface UserMapper {

    int insertUser(User user);

    User getUser(Integer user);
}
