package com.dreamchaser.controller;

import com.dreamchaser.pojo.*;
import com.dreamchaser.service.*;
import com.dreamchaser.utils.ArchivesUtil;
import com.dreamchaser.utils.MapUtil;
import com.dreamchaser.utils.MarkdownUtil;
import com.dreamchaser.utils.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PageController {
    @Autowired
    BlogService blogService;
    @Autowired
    TypeService typeService;
    @Autowired
    TagService tagService;
    @Autowired
    CommentService commentService;
    @Autowired
    BlogCombinationService blogCombinationService;
    @Autowired
    CommentCombinationService commentCombinationService;


    @GetMapping("/login")
    public String login(){
        return "admin/login";
    }

    @GetMapping("/admin/blog-input")
    public ModelAndView blog_input(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("types",typeService.findTypeAll());
        mv.addObject("tags",tagService.findTagAll());
        mv.addObject("method","post");
        mv.setViewName("admin/blog-input");
        return getModelAndView(mv);
    }

    @GetMapping("/admin/blog-input/{blogId}")
    public ModelAndView blog_input_update(@PathVariable Integer blogId){
        ModelAndView mv=new ModelAndView();
        mv.addObject("types",typeService.findTypeAll());
        mv.addObject("tags",tagService.findTagAll());
        mv.addObject("blog",blogService.findBlogById(blogId));
        mv.addObject("method","put");
        mv.setViewName("admin/blog-input");
        return getModelAndView(mv);
    }

    @GetMapping("/admin/blogs")
    public ModelAndView blogs(){
        ModelAndView mv=new ModelAndView();
        Map<String,Object>map=new HashMap<>();
        map.put("begin",0);
        map.put("size",6);
        mv.setViewName("admin/blogs");
        mv.addObject("types",typeService.findTypeAll());
        mv.addObject("blogs",blogCombinationService.findBlogCombinationByCondition(map));
        return getModelAndView(mv);
    }



    @GetMapping("/admin/comments")
    public ModelAndView comments(){
        ModelAndView mv=new ModelAndView();
        Map<String,Object> map=new HashMap<>();
        map.put("begin",0);
        map.put("size",6);
        mv.addObject("comments",commentCombinationService.findCommentByPage(map));
        mv.setViewName("admin/comments");
        return getModelAndView(mv);
    }
    @GetMapping("/admin/comments-details/{id}")
    public ModelAndView comments_details(@PathVariable Integer id){
        ModelAndView mv=new ModelAndView();
        mv.addObject("comment",commentCombinationService.findCommentById(id));
        mv.setViewName("admin/comments-details");
        return getModelAndView(mv);
    }
    @GetMapping("/admin/tag-input")
    public ModelAndView tag_input(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("method","post");
        mv.setViewName("admin/tag-input");
        return getModelAndView(mv);
    }
    @GetMapping("/admin/tag-input/{id}")
    public ModelAndView tag_input(@PathVariable Integer id){
        ModelAndView mv=new ModelAndView();
        mv.addObject("tag",tagService.findTagById(id));
        mv.addObject("method","put");
        mv.setViewName("admin/tag-input");
        return getModelAndView(mv);
    }

    @GetMapping("/admin/tags")
    public ModelAndView tags(){
        ModelAndView mv=new ModelAndView();
        Map<String,Object> map=new HashMap<>();
        map.put("begin",0);
        map.put("size",6);
        mv.addObject("tags",tagService.findTagByPage(map));
        mv.setViewName("admin/tags");
        return getModelAndView(mv);
    }
    @GetMapping("/admin/types")
    public ModelAndView types(){
        ModelAndView mv=new ModelAndView();
        Map<String,Object> map=new HashMap<>();
        map.put("begin",0);
        map.put("size",6);
        mv.addObject("types",typeService.findTypeByPage(map));
        mv.setViewName("admin/types");
        return getModelAndView(mv);
    }
    @GetMapping("/admin/types-input")
    public ModelAndView types_input(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("admin/types-input");
        mv.addObject("method","post");
        return getModelAndView(mv);
    }
    @GetMapping("/admin/types-input/{id}")
    public ModelAndView types_input(@PathVariable Integer id){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("admin/types-input");
        mv.addObject("type",typeService.findTypeById(id));
        mv.addObject("method","put");
        return getModelAndView(mv);
    }

    @GetMapping("/page_blog/{id}")
    public ModelAndView blog(@PathVariable Integer id){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("blog");
        BlogCombination blogCombination=blogCombinationService.findBlogCombinationById(id);
        blogCombination.setContent(MarkdownUtil.markdownToHtmlExtens(blogCombination.getContent()));
        mv.addObject("blog",blogCombination);
        Map<String,List<Comment>> map=commentService.findCommentsByBlog(id);
        mv.addObject("parents",map.get("parents"));
        mv.addObject("sons",map.get("sons"));
        return getModelAndView(mv);
    }


    @GetMapping("/archives")
    public ModelAndView archives(){
        ModelAndView mv=new ModelAndView();
        List<Blog>blogs=blogService.findBlogAllVisible();
        mv.addObject("number",blogs.size());
        mv.addObject("years", ArchivesUtil.handle(blogs));
        mv.setViewName("archives");
        return getModelAndView(mv);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam Map<String,Object> map){
        ModelAndView mv=new ModelAndView();
        //预处理
        if (map.get("begin")==null){
            map.put("begin",0);
        }else if (ObjectUtil.ObjectToInteger(map.get("begin")) <ObjectUtil.ObjectToInteger(map.get("size"))){
            map.replace("begin",0);
        }
        if (map.get("size")==null){
            map.put("size",8);
        }

        //所有博客分页查询
        //因为有一种情况是上一页下一页，前端发送begin和size，而后端接受到时是string，而数据库中limit后只能跟数字，所以得先对其做处理
        mv.addObject("blogs",blogCombinationService.findBlogCombinationByConditionVisible(MapUtil.handle(map)));
        //注意此时map其实已经处理过了，所以取出来的begin和size类型就是Integer
        mv.addObject("begin",map.get("begin"));
        mv.addObject("size",map.get("size"));

        map.put("begin",0);
        map.put("size",10);
        mv.addObject("types",typeService.findTypeByPage(map));
        mv.addObject("tags",tagService.findTagByPage(map));
        mv.setViewName("index");
        //最新推荐的博客
        map.put("isRecommend",1);
        mv.addObject("recommendedBlogs",blogService.findBlogByConditionVisible(map));

        //为了显示博客数量
        List<Blog>blogs=blogService.findBlogAllVisible();
        mv.addObject("number",blogs.size());

        return getModelAndView(mv);
    }

    /**
     * 实现前台展示的search功能
     * @param map
     * @return
     */
    @GetMapping("/search")
    public ModelAndView index_search(@RequestParam Map<String, Object> map){
        ModelAndView mv=new ModelAndView();
        mv.addObject("blogs",blogCombinationService.findBlogCombinationByConditionVisible(map));
        mv.setViewName("search");
        return getModelAndView(mv);
    }



    @GetMapping("/page_tags")
    public ModelAndView page_tags(@RequestParam Map<String,Object>map){
        ModelAndView mv=new ModelAndView();
        List<Tag> tags=tagService.findTagAll();
        mv.addObject("tags",tags);
        //预处理，可以让接口有更多变化
        if (map.get("tagId")==null){
            map.put("tags",String.valueOf(tags.get(0).getId()));
        }else{
            map.put("tags",String.valueOf(map.get("tagId")));
        }
        //这里要把typeId转换为Integer，不然thymeleaf中比较时会因为类型问题导致if判断达不到想要的效果
        mv.addObject("tagId",ObjectUtil.ObjectToInteger(map.get("tags")));
        if (map.get("begin")==null){
            map.put("begin",0);
        }else if (ObjectUtil.ObjectToInteger(map.get("begin")) <ObjectUtil.ObjectToInteger(map.get("size"))){
            map.replace("begin",0);
        }
        if (map.get("size")==null){
            map.put("size",6);
        }
        mv.setViewName("tags");

        //加上","才能保证查找的tagId准确，否则会出现找的明明是9，结果显示是19
        map.put("tags",","+String.valueOf(map.get("tags"))+",");
        mv.addObject("blogs",blogCombinationService.findBlogCombinationByConditionVisible(MapUtil.handle(map)));
        mv.addObject("begin",map.get("begin"));
        mv.addObject("size",map.get("size"));
        return getModelAndView(mv);
    }
    @GetMapping("/about")
    public ModelAndView about(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("about");
        return getModelAndView(mv);
    }
    @GetMapping("/page_types")
    public ModelAndView page_types(@RequestParam Map<String,Object>map){
        ModelAndView mv=new ModelAndView();
        List<Type> types=typeService.findTypeAll();
        mv.addObject("types",types);
        //预处理，可以让接口有更多变化
        if (map.get("typeId")==null){
            map.put("type",types.get(0).getId());
        }else{
            map.put("type",map.get("typeId"));
        }
        //这里要把typeId转换为Integer，不然thymeleaf中比较时会因为类型问题导致if判断达不到想要的效果
        mv.addObject("typeId",ObjectUtil.ObjectToInteger(map.get("type")));
        if (map.get("begin")==null){
            map.put("begin",0);
        }else if (ObjectUtil.ObjectToInteger(map.get("begin")) <ObjectUtil.ObjectToInteger(map.get("size"))){
            map.replace("begin",0);
        }
        if (map.get("size")==null){
            map.put("size",6);
        }
        mv.setViewName("types");
        mv.addObject("blogs",blogCombinationService.findBlogCombinationByConditionVisible(MapUtil.handle(map)));
        mv.addObject("begin",map.get("begin"));
        mv.addObject("size",map.get("size"));
        return getModelAndView(mv);
    }

    /**
     * 由于前台页面都不footer部分都要有最新博客推荐，所以抽象分离出来，将其封装成一个方法
     * @param mv
     * @return
     */
    private ModelAndView getModelAndView(  ModelAndView mv) {
        Map<String,Object> map=new HashMap<>(3);
        map.put("begin",0);
        map.put("size",3);
        map.put("isRecommend",1);
        mv.addObject("newBlogs",blogService.findBlogByConditionVisible(map));
        return mv;
    }

}
