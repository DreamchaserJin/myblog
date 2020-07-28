package com.dreamchaser.controller;

import com.dreamchaser.service.BlogCombinationService;
import com.dreamchaser.utils.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class BlogCombinationController {
    @Autowired
    BlogCombinationService blogCombinationService;


    @GetMapping(value = "/blogCombination_blogs")
    public String findBlogByPage(@RequestParam Map<String,Object> map, Model model){

        model.addAttribute("blogs",blogCombinationService.findBlogCombinationByCondition(MapUtil.handle(map)));
        //渲染部分页面
        return "admin/blogs::table_refresh";
    }

}
