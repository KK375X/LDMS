package com.ldms.service;

import com.ldms.pojo.Admin;
import com.ldms.pojo.Student;
import com.ldms.pojo.Teacher;

public interface UserService {

    // 添加用户（管理员、教师、学生）
    public int addAdmin(Admin admin);
    public int addTeacher(Teacher teacher);
    public int addStudent(Student student);
}
