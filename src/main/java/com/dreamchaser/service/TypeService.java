package com.dreamchaser.service;

import com.dreamchaser.pojo.Type;

import java.util.List;
import java.util.Map;

/**
 * @author 金昊霖
 */
public interface TypeService {
    /**
     * 增加一个type
     * @param type
     * @return
     */
    int addType(Type type);

    /**
     * 根据主键删除type
     * @param id
     * @return
     */
    int deleteTypeById(Integer id);

    /**
     * 根据主键更新type
     * @param type
     * @return
     */
    int updateType(Type type);

    /**
     * 查询所有的type
     * @return
     */
    List<Type> findTypeAll();

    /**
     * 分页查询
     * @param map
     * @return
     */
    List<Type> findTypeByPage(Map<String,Object> map);

    /**
     * 通过主键查询
     * @param id
     * @return
     */
    Type findTypeById(Integer id);


}
