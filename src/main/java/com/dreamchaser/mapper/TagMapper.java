package com.dreamchaser.mapper;

import com.dreamchaser.pojo.Tag;

import java.util.List;
import java.util.Map;

/**
 * @author 金昊霖
 */
public interface TagMapper {
    /**
     * 增加一个标签
     * @param tag
     * @return
     */
    int insertTag(Tag tag);

    /**
     * 根据主键删除一个标签
     * @param id
     * @return
     */
    int deleteTagById(Integer id);

    /**
     * 更新一个标签
     * @param tag
     * @return
     */
    int updateTag(Tag tag);

    /**
     * 批量更新标签
     * @param list
     * @return
     */
    int updateTags(List<Map<String,Object>> list);

    /**
     * 查询所有标签
     * @return
     */
    List<Tag> findTagAll();

    /**
     * 分页查询
     * @param map
     * @return
     */
    List<Tag> findTagByPage(Map<String,Object> map);

    /**
     * 根据多个主键查询
     * @param ids
     * @return
     */
    List<Tag> findTagByIds(List<Integer> ids);

    /**
     * 根据单个主键查询
     * @param id
     * @return
     */
    Tag findTagById(Integer id);





}
