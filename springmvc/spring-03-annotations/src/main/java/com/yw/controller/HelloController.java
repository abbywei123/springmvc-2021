package com.yw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    //转发
    @RequestMapping("h1")
    public String hello(Model model){
        //封装数据
        model.addAttribute("msg","hello,SpringMvc!");
        return "/WEB-INF/jsp/hello.jsp"; //会被视图解析器处理
    }

    //重定向
    @RequestMapping("h2")
    public String hello2(Model model){
        //封装数据
        model.addAttribute("msg","hello,SpringMvc!");
        return "redirect:/index.jsp"; //会被视图解析器处理
    }
}
