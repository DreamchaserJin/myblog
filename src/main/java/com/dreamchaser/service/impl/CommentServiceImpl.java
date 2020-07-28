package com.dreamchaser.service.impl;

import com.dreamchaser.mapper.CommentMapper;
import com.dreamchaser.pojo.Comment;
import com.dreamchaser.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    CommentMapper commentMapper;

    @Override
    public int insertComment(Comment comment) {
        comment.setTime(new Date());
        return commentMapper.insertComment(comment);
    }

    @Override
    public int deleteCommentById(Integer id) {
        return commentMapper.deleteCommentById(id);
    }

    @Override
    public int updateComment(Comment comment) {
        return commentMapper.updateComment(comment);
    }

    @Override
    public List<Comment> findCommentByPage(Map<String, Object> map) {
        return commentMapper.findCommentByPage(map);
    }

    @Override
    public Comment findCommentById(Integer id) {
        return commentMapper.findCommentById(id);
    }

    @Override
    public Map<String, List<Comment>> findCommentsByBlog(Integer id) {
        Map<String, List<Comment>> map=new HashMap<>(2);
        map.put("parents",commentMapper.findPCommentByBlogId(id));
        map.put("sons",commentMapper.findSCommentByBlogId(id));
        return map;
    }


}
