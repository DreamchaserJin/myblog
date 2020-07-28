package com.dreamchaser.controller;

import com.dreamchaser.pojo.Tag;
import com.dreamchaser.service.TagService;
import com.dreamchaser.utils.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class TagController {
    @Autowired
    TagService tagService;
    @GetMapping("/tag")
    public String findTags(@RequestParam Map<String,Object> map, Model model){
        model.addAttribute("tags",tagService.findTagByPage(MapUtil.handle(map)));
        return "admin/tags::table_refresh";
    }
    @PostMapping("/tag")
    public ModelAndView insertTag(Tag tag){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("admin/tip");
        if (tagService.insertTag(tag)==1){
            mv.addObject("message","添加新标签成功！");
        }else {
            mv.addObject("message","添加新标签失败！");
        }
        return mv;
    }

    @DeleteMapping("/tag")
    public ModelAndView deleteTag(Integer id){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("admin/tip");
        if (tagService.deleteTag(id)==1){
            mv.addObject("message","删除标签成功！");
        }else {
            mv.addObject("message","删除标签失败！");
        }
        return mv;
    }
    @PutMapping("/tag")
    public ModelAndView updateTag(Tag tag){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("admin/tip");
        if (tagService.updateTag(tag)==1){
            mv.addObject("message","更新新标签成功！");
        }else {
            mv.addObject("message","更新新标签失败！");
        }
        return mv;
    }

}
