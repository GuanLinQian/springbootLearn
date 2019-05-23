package com.mapper;

import com.pojo.Student;

import java.util.List;

/**
 * 时间:9:29
 * 作者：Maibenben
 **/
public interface StudentMapper {
    List<Student> getAllStusM();
    boolean delStuM(Integer id);
}
