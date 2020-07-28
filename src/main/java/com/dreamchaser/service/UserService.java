package com.dreamchaser.service;

import com.dreamchaser.pojo.User;

import java.util.Map;

/**
 * @author 金昊霖
 */
public interface UserService {
    /**
     * 根据条件查询管理员账户
     * @param map
     * @return
     */
    User findUserByCondition(Map<String,Object> map);
}
