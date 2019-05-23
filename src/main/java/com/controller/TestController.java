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
@Autowired
  private Page pageBean;
    @RequestMapping("show")
    public  String test(Integer page,Integer rows){
        System.out.println("存入list集合-------------"+page+rows);
     if(pageBean!=null){
         pageBean.setPage(page);
     }
        request.setAttribute("list",studentService.getAllStus(page, rows));

        System.out.println(pageBean);
        request.setAttribute("pageBean",pageBean);
        return "stulist";
    }
    @RequestMapping("del")
    public String del(Integer id){
        studentService.delStu(id);
        return  "redirect:show?page=1&rows=3";
    }
}
