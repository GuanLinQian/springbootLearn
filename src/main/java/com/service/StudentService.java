package com.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.StudentMapper;
import com.pojo.Student;
import com.redis.RedisUtil;
import com.util.Page;
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
@Autowired
private StudentMapper studentMapper;

    public PageInfo getAllStus(Integer page,Integer rows){

        PageHelper.startPage(page,rows);

        PageInfo pageInfo=new PageInfo(studentMapper.getAllStusM());

        System.out.println("执行service--------------"+pageInfo);


        return  pageInfo;

    }
    public  boolean delStu(Integer id){

        return studentMapper.delStuM(id);
    }
}
