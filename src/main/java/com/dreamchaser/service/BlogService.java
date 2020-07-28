package com.dreamchaser.service;

import com.dreamchaser.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author 金昊霖
 */
public interface BlogService {
    /**
     * 查询所有的博客
     * @return
     */
    List<Blog> findBlogAll();

    /**
     * 增加一个博客
     * @param blog
     * @return
     */
    int addBlog(Blog blog);

    /**
     * 按条件查询博客
     * @param map
     * @return
     */
    List<Blog> findBlogByCondition(Map<String,Object> map);

    /**
     * 分页查找博客
     * @param begin
     * @param size
     * @return
     */
    List<Blog> findBlogByPage(Integer begin, Integer size);

    /**
     * 根据主键查询博客
     * @param blogId
     * @return
     */
    Blog findBlogById(Integer blogId);

    /**
     * 根据主键删除博客
     * @param id
     * @return
     */
    int deleteBlog(Integer id);

    /**
     * 更新一个博客
     * @param blog
     * @return
     */
    int updateBlog(Blog blog);

    /**
     * 通过名称寻找id
     * @return
     * @param name
     */
    Integer findBlogIdByName(String name);

    /**
     * 用于查询所有可见的博客（发布状态的）
     * @return
     */
    List<Blog> findBlogAllVisible();

    /**
     * 根据条件查询查询可见的博客（发布状态的）
     * @param map
     * @return
     */
    List<Blog> findBlogByConditionVisible(Map<String, Object> map);
}
