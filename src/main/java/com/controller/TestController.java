package com.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Student;
import com.redis.RedisUtil;
import com.service.StudentService;
import com.util.Page;
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

    @RequestMapping("show")
    public  String test(Integer page,Integer rows){
        System.out.println("存入list集合-------------"+page+rows);

        PageInfo pageInfo=studentService.getAllStus(page,rows);
        /* if(pageInfo!=null){
         pageInfo.setPages(page);
        }*/
        request.setAttribute("pageInfo",studentService.getAllStus(page, rows));


        return "stulist";
    }
    @RequestMapping("del")
    public String del(Integer id){
        studentService.delStu(id);
        return  "redirect:show?page=1&rows=3";
    }
}
