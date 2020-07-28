package com.dreamchaser.mapper;

import com.dreamchaser.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author 金昊霖
 */
public interface BlogMapper {
    /**
     * 增加博客
     * @param blog
     * @return
     */
    int addBlog(Blog blog);

    /**
     * 通过主键删除博客
     * @param id
     * @return
     */
    Integer deleteBlogById(Integer id);

    /**
     * 更新博客
     * @param blog
     * @return
     */
    Integer updateBlog(Blog blog);

    /**
     * 查询所有博客
     * @return
     */
    List<Blog> findBlogAll();

    /**
     * 分页查询博客
     * @param begin
     * @param size
     * @return
     */
    List<Blog> findBlogByPage(Integer begin, Integer size);

    /**
     * 按条件查询博客
     * @param map
     * @return
     */
    List<Blog> findBlogByCondition(Map<String, Object> map);

    /**
     * 通过主键查询博客
     * @param id
     * @return
     */
    Blog findBlogById(Integer id);

    /**
     * 根据名称查询id
     * @param title
     * @return
     */
    Integer findBlogIdByName(String title);

    /**
     * 用于查询所有可见blog（已发布）
     * @return
     */
    List<Blog> findBlogAllVisible();

}
