package com.dreamchaser.service;

import com.dreamchaser.pojo.Tag;

import java.util.List;
import java.util.Map;

/**
 * @author 金昊霖
 */
public interface TagService {
    /**
     * 增加一个标签
     * @param tag
     * @return
     */
    int insertTag(Tag tag);

    /**
     * 删除一个标签
     * @param id
     * @return
     */
    int deleteTag(Integer id);

    /**
     * 更新一个标签
     * @param tag
     * @return
     */
    int updateTag(Tag tag);

    /**
     * 查询所有标签
     * @return
     */
    List<Tag> findTagAll();

    /**
     * 通过主键查询
     * @param id
     * @return
     */
    Tag findTagById(Integer id);

    /**
     * 通过主键批量查询
     * @param ids
     * @return
     */
    List<Tag> findTagByIds(List<Integer> ids);

    /**
     * 分页查询
     * @param map
     * @return
     */
    List<Tag> findTagByPage(Map<String,Object> map);
}
