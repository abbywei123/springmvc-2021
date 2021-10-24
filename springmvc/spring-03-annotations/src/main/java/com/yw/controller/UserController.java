package com.yw.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.yw.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/json1")
    @ResponseBody //他就不会走视图解析器，会直接发返回一个字符串
    public String json1() throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        User user=new User(1,"大华",17);
        String res=mapper.writeValueAsString(user);
        return res;
    }

    @RequestMapping(value = "/json2")
    public String json2()  throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        User user=new User(1,"大华",17);
        String res=mapper.writeValueAsString(user);
        return res;
    }

    @RequestMapping(value = "/json3")
    public String json3()  throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        List<User> list=new ArrayList<>() ;
        User user1=new User(1,"大华1",17);
        User user2=new User(2,"大华2",17);
        User user3=new User(3,"大华3",17);
        list.add(user1);
        list.add(user2);
        list.add(user3);

        String res=mapper.writeValueAsString(list);
        return res;
    }

    @RequestMapping(value = "/json4")
    public String json4()  throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();

        //不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //自定义日期格式对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //指定日期格式
        mapper.setDateFormat(sdf);


        Date date=new Date();
        String res=mapper.writeValueAsString(date);
        return res;
    }

    //http://localhost:8080/user/t1?name=yw
    @GetMapping("/t1")
    public String test1(@RequestParam("name") String name, Model model){
        model.addAttribute("msg",name);
        return "test";
    }

    @GetMapping("/t2")
    public String test2(User user){
        System.out.println("从前端接收到的数据："+user);
        return "test";
    }
}
