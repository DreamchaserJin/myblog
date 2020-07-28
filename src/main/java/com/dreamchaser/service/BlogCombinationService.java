package com.dreamchaser.service;

import com.dreamchaser.pojo.Blog;
import com.dreamchaser.pojo.BlogCombination;

import java.util.List;
import java.util.Map;

/**
 * @author 金昊霖
 */
public interface BlogCombinationService {
    /**
     * 分页查询得到组合类集合
     * @param begin
     * @param size
     * @return
     */
//    List<BlogCombination> findBlogCombinationByPage(Integer begin, Integer size);

    /**
     * 根据条件查询得到集合类
     * @param map
     * @return
     */
    List<BlogCombination> findBlogCombinationByCondition(Map<String, Object> map);

    /**
     * 根据条件查询已发布的博客
     * @param map
     * @return
     */
    List<BlogCombination> findBlogCombinationByConditionVisible(Map<String, Object> map);

    /**
     * 根据主键查询
     * @param blogId
     * @return
     */
    BlogCombination findBlogCombinationById(Integer blogId);

    /**
     * 查询所有已发布的博客并封装成BlogCombination返回
     * @return
     */
    List<BlogCombination> findBlogCombinationAllVisible();

}
