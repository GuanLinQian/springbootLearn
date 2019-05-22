package com.service;

import com.pojo.Student;
import com.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间:18:28
 * 作者：Maibenben
 **/
@Service
public class StudentService {


    public List<Student> getAllStus(){

System.out.println("执行service--------------");
        List<Student> list=new ArrayList<>();

        list.add(new Student(10001,"李四","男"));
        list.add(new Student(10002,"张三","男"));
        list.add(new Student(10003,"王五","男"));

        return  list;

    }
}
