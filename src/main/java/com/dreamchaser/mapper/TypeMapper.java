package com.dreamchaser.mapper;

import com.dreamchaser.pojo.Type;

import java.util.List;
import java.util.Map;

public interface TypeMapper {
    /**
     * 增加一个分类
     * @param type
     * @return
     */
    int insertType(Type type);

    /**
     * 根据主键删除一个分类
     * @param id
     * @return
     */
    int deleteTypeById(Integer id);

    /**
     * 更新一个分类专栏
     * @param type
     * @return
     */
    int updateType(Type type);

    /**
     * 查询所有分类
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
     * 根据多个主键查询
     * @param list
     * @return
     */
    List<Type> findTypeByIds(List<Integer> list);

    /**
     * 根据单个主键查询
     * @param id
     * @return
     */
    Type findTypeById(Integer id);


}
