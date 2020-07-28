package com.dreamchaser.service.impl;

import com.dreamchaser.mapper.UserMapper;
import com.dreamchaser.pojo.User;
import com.dreamchaser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    UserMapper userMapper;
    @Override
    public User findUserByCondition(Map<String, Object> map) {
        return userMapper.findUserByCondition(map);
    }
}
