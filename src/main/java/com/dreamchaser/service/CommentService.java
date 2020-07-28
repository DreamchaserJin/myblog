package com.dreamchaser.service;

import com.dreamchaser.pojo.Comment;

import java.util.List;
import java.util.Map;

/**
 * @author 金昊霖
 */
public interface CommentService {
    /**
     * 插入一条评论
     * @param comment
     * @return
     */
    int insertComment(Comment comment);

    /**
     * 根据主键删除一条评论
     * @param id
     * @return
     */
    int deleteCommentById(Integer id);

    /**
     * 更新一条评论
     * @param comment
     * @return
     */
    int updateComment(Comment comment);

    /**
     * 分页查找
     * @param map
     * @return
     */
    List<Comment> findCommentByPage(Map<String,Object> map);

    /**
     * 根据主键id查询评论
     * @param id
     * @return
     */
    Comment findCommentById(Integer id);

    /**
     * 根据博客id查询相对应的评论，并将其变成一定格式返回
     * @param id
     * @return
     */
    Map<String,List<Comment>>  findCommentsByBlog(Integer id);
}
