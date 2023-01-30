package com.ldms.controller;

import com.ldms.pojo.Student;
import com.ldms.service.UserService;
import com.ldms.service.UserServiceImplement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddStudentServlet", value = "/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {

    private UserService userService = new UserServiceImplement();

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
        String studentId = request.getParameter("studentId");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        String phone = request.getParameter("phone");
        String teacherId = request.getParameter("teacherId");
        String classes = request.getParameter("classes");
        String college = request.getParameter("college");
        String createDate = request.getParameter("createDate");

        Student student = new Student();
        student.setId(id);
        student.setStudentId(studentId);
        student.setName(name);
        student.setPassword(password);
        student.setAge(age);
        student.setSex(sex);
        student.setPhone(phone);
        student.setTeacherId(teacherId);
        student.setClasses(classes);
        student.setCollege(college);
        student.setCreateDate(createDate);

        try {
            if (userService.addStudent(student) == 1) {
                response.getWriter().write("success");
            } else {
                response.getWriter().write("fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
