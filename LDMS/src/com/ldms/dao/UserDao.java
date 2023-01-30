package com.ldms.dao;

import com.ldms.pojo.Admin;
import com.ldms.pojo.Student;
import com.ldms.pojo.Teacher;

import java.util.List;

public interface UserDao {

    // 获取用户的账号ID和密码，用于用户登录操作
    public Admin selectAdmin(String ID, String password);
    public Teacher selectTeacher(String ID, String password);
    public Student selectStudent(String ID, String password);


    // 查询用户信息数据库，显示数据列表（已淘汰）
    public List<Object> selectTeacherList();
    public List<Object> selectStudentList();
    public List<Object> selectAdminList();


    // 查询数据库，实现信息表显示和分页功能，并获取学生信息数据的总和
    public List<Object> selectTeacherList(String page, String limit);
    public int countTeacherInfo();
    public List<Object> selectAdminList(String page, String limit);
    public int countAdminInfo();
    public List<Object> selectStudentList(String page, String limit);
    public int countStudentInfo();


    // 功能一：添加用户信息，实现注册功能
    // 功能二：添加用户（管理员、教师、学生）
    public int addAdmin(Admin admin);
    public int addTeacher(Teacher teacher);
    public int addStudent(Student student);


    // 查询用户ID和密码
    public Admin selectAdmin(String ID);
    public Teacher selectTeacher(String ID);
    public Student selectStudent(String ID);


    // 搜索功能
    public List<Object> searchAdminList(String name, String page, String limit);
    public List<Object> searchTeacherList(String name, String college, String page, String limit);
    public List<Object> searchStudentList(String name, String classes, String college, String page, String limit);


    // 删除功能
    public void deleteAdmin(String id);
    public void deleteTeacher(String id);
    public void deleteStudent(String id);
}
