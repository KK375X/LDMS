package com.ldms.service;

import com.ldms.dao.UserDao;
import com.ldms.dao.UserDaoImplement;
import com.ldms.pojo.Admin;
import com.ldms.pojo.Student;
import com.ldms.pojo.Teacher;

public class UserServiceImplement implements UserService{

    private UserDao userDao = new UserDaoImplement();

    // 添加用户（管理员、教师、学生）
    /**
     * @param admin
     * @return
     */
    @Override
    public int addAdmin(Admin admin) {
        return userDao.addAdmin(admin);
    }

    /**
     * @param teacher
     * @return
     */
    @Override
    public int addTeacher(Teacher teacher) {
        return userDao.addTeacher(teacher);
    }

    /**
     * @param student
     * @return
     */
    @Override
    public int addStudent(Student student) {
        return userDao.addStudent(student);
    }
}
