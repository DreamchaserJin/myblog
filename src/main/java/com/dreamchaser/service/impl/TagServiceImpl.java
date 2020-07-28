package com.dreamchaser.service.impl;

import com.dreamchaser.mapper.TagMapper;
import com.dreamchaser.pojo.Tag;
import com.dreamchaser.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TagServiceImpl implements TagService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    TagMapper tagMapper;

    @Override
    public int insertTag(Tag tag) {
        tag.setDate(new Date());
        return tagMapper.insertTag(tag);
    }

    @Override
    public int deleteTag(Integer id) {
        return tagMapper.deleteTagById(id);
    }

    @Override
    public int updateTag(Tag tag) {
        tag.setDate(new Date());
        return tagMapper.updateTag(tag);
    }

    @Override
    public List<Tag> findTagAll() {
        return tagMapper.findTagAll();
    }

    @Override
    public Tag findTagById(Integer id) {
        return tagMapper.findTagById(id);
    }

    @Override
    public List<Tag> findTagByIds(List<Integer> ids) {
        return tagMapper.findTagByIds(ids);
    }

    @Override
    public List<Tag> findTagByPage(Map<String,Object> map) {
        return tagMapper.findTagByPage(map);
    }
}
