package com.ldms.controller;

import com.ldms.pojo.Admin;
import com.ldms.pojo.Student;
import com.ldms.pojo.Teacher;
import com.ldms.service.LoginService;
import com.ldms.service.LoginServiceImplement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckRegisterServlet", value = "/CheckRegisterServlet")
public class CheckRegisterServlet extends HttpServlet {

    private LoginService loginService = new LoginServiceImplement();

    /**
     * doGet
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * doPost
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取信息
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        String phone = request.getParameter("phone");
        String college = request.getParameter("college");
        String entity = request.getParameter("entity");
        String position = request.getParameter("position");
        String teacherId = request.getParameter("teacherId");
        String classes = request.getParameter("classes");
        String createDate = request.getParameter("createDate");

        // 实例化对象
        Admin admin;
        Student student;
        Teacher teacher;

        // 身份判断
        if (entity.equals("学生")) {
            try {
                student = loginService.selectStudent(id);

                // 查询数据库是否已存在该用户
                if (student == null) {
                    student = new Student();
                    // 为student赋值
                    student.setId(id);  // 学生使用的用于登录的用户ID
                    student.setStudentId(id); // 学生id
                    student.setName(name);
                    student.setPassword(password);
                    student.setAge(age);
                    student.setSex(sex);
                    student.setPhone(phone);
                    student.setTeacherId(teacherId);
                    student.setClasses(classes);
                    student.setCollege(college);
                    student.setCreateDate(createDate);
                    int flag = loginService.addStudent(student);
                    if (flag == 1) {
                        response.getWriter().write("success");
                    } else {
                        response.getWriter().write("fail");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (entity.equals("教师")) {
            try {
                teacher = loginService.selectTeacher(id);

                // 查询数据库是否已存在该用户
                if (teacher == null) {
                    teacher = new Teacher();
                    // 为teacher赋值
                    teacher.setId(id);  // 教师使用的用于登录的用户ID
                    teacher.setTeacherId(teacherId); // 教师id
                    teacher.setName(name);
                    teacher.setPassword(password);
                    teacher.setAge(age);
                    teacher.setSex(sex);
                    teacher.setCollege(college);
                    teacher.setPosition(position);
                    teacher.setPhone(phone);
                    teacher.setCreateDate(createDate);
                    int flag = loginService.addTeacher(teacher);
                    if (flag == 1) {
                        response.getWriter().write("success");
                    } else {
                        response.getWriter().write("fail");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
