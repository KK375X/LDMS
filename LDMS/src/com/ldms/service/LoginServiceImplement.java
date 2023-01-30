package com.ldms.service;

import com.ldms.dao.UserDao;
import com.ldms.dao.UserDaoImplement;
import com.ldms.pojo.Admin;
import com.ldms.pojo.Student;
import com.ldms.pojo.Teacher;
import com.ldms.service.LoginService;

import javax.servlet.annotation.*;

@WebServlet(name = "LoginServletImplement", value = "/LoginServletImplement")
public class LoginServiceImplement implements LoginService {

    //创建实例化对象
    private UserDao userDao = new UserDaoImplement();

    // 查询用户ID和密码
    /**
     * @param ID
     * @param password
     * @return
     */
    @Override
    public Admin selectAdmin(String ID, String password) {
        return userDao.selectAdmin(ID, password);
    }

    /**
     * @param ID
     * @param password
     * @return
     */
    @Override
    public Teacher selectTeacher(String ID, String password) {
        return userDao.selectTeacher(ID, password);
    }

    /**
     * @param ID
     * @param password
     * @return
     */
    @Override
    public Student selectStudent(String ID, String password) {
        return userDao.selectStudent(ID, password);
    }


    // 查询用户ID是否存在
    /**
     * @param ID
     * @return
     */
    @Override
    public Admin selectAdmin(String ID) {
        return userDao.selectAdmin(ID);
    }

    /**
     * @param ID
     * @return
     */
    @Override
    public Teacher selectTeacher(String ID) {
        return userDao.selectTeacher(ID);
    }

    /**
     * @param ID
     * @return
     */
    @Override
    public Student selectStudent(String ID) {
        return userDao.selectStudent(ID);
    }


    // 添加用户信息，实现注册功能
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
