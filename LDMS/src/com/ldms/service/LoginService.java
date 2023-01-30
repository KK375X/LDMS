package com.ldms.service;

import com.ldms.pojo.Admin;
import com.ldms.pojo.Student;
import com.ldms.pojo.Teacher;

import java.sql.SQLException;

public interface LoginService {

    // 查询用户ID和密码
    public Admin selectAdmin(String ID, String password);
    public Teacher selectTeacher(String ID, String password);
    public Student selectStudent(String ID, String password);


    // 查询用户ID是否存在
    public Admin selectAdmin(String ID);
    public Teacher selectTeacher(String ID);
    public Student selectStudent(String ID);


    // 添加用户信息，实现注册功能
    public int addAdmin(Admin admin);
    public int addTeacher(Teacher teacher);
    public int addStudent(Student student);

}
