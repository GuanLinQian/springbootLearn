package com.controller;


import com.pojo.Student;
import com.redis.RedisUtil;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 时间:11:30
 * 作者：Maibenben
 **/
@Controller
public class TestController {
@Autowired
private HttpServletRequest request;
 @Autowired
    private StudentService studentService;
    @RequestMapping("test")
    public  String test(){
        System.out.println("存入list集合-------------");

     List<Student> list= studentService.getAllStus();
        System.out.println(list);

        request.setAttribute("list",list);
        return "stulist";
    }
}
