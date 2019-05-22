package com.pojo;

import java.io.Serializable;

/**
 * 时间:19:06
 * 作者：Maibenben
 **/
public class Student implements Serializable {
    private  Integer id;
    private String studentName;
    private String sex;

    public Student() {
    }

    public Student(Integer id, String studentName, String sex) {
        this.id = id;
        this.studentName = studentName;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
