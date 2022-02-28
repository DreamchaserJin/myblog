package com.dreamchaser.controller;

import com.dreamchaser.pojo.User;
import com.dreamchaser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {


    @Autowired
    UserService userService;


    @PostMapping("/user/login")
    public ModelAndView loginUser(@RequestParam Map<String,Object> map,HttpSession session)throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        User user=userService.findUserByCondition(map);
        if (map.get("name")!=""&&map.get("password")!=""&&user!=null){
            session.setAttribute("user",user);
            modelAndView.setViewName("redirect:/admin/blogs");
        }else {
            modelAndView.addObject("tip","用户名或密码错误请重新输入!");
            modelAndView.setViewName("admin/login");
        }
        return modelAndView;
    }

    @GetMapping("/user/logout")
    public ModelAndView logOut(HttpSession session){
        ModelAndView modelAndView=new ModelAndView();
        session.removeAttribute("user");
        session.invalidate();
        modelAndView.addObject("message","用户退出成功!");
        modelAndView.setViewName("admin/tip");
        return modelAndView;
    }
}
