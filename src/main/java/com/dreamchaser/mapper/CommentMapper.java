package com.dreamchaser.mapper;

import com.dreamchaser.pojo.Comment;

import java.util.List;
import java.util.Map;

public interface CommentMapper {
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
     * 根据主键删除多条评论
     * @param ids
     * @return
     */
    int deleteCommentByIds(List<Integer> ids);

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
     * 根据博客id查询父级评论
     * @param blog
     * @return
     */
    List<Comment> findPCommentByBlogId(Integer blog);

    /**
     * 根据博客id查询子级评论
     * @param blog
     * @return
     */
    List<Comment> findSCommentByBlogId(Integer blog);
}
