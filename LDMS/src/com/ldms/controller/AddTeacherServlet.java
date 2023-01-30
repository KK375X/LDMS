package com.ldms.controller;

import com.ldms.pojo.Teacher;
import com.ldms.service.UserService;
import com.ldms.service.UserServiceImplement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddTeacherServlet", value = "/AddTeacherServlet")
public class AddTeacherServlet extends HttpServlet {

    private UserService userService = new UserServiceImplement();

    /**
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
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取信息
        String id = request.getParameter("id");
        String teacherId = request.getParameter("teacherId");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        String college = request.getParameter("college");
        String position = request.getParameter("position");
        String phone = request.getParameter("phone");
        String createDate = request.getParameter("createDate");

        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacher.setTeacherId(teacherId);
        teacher.setName(name);
        teacher.setPassword(password);
        teacher.setAge(age);
        teacher.setSex(sex);
        teacher.setCollege(college);
        teacher.setPosition(position);
        teacher.setPhone(phone);
        teacher.setCreateDate(createDate);

        try {
            if (userService.addTeacher(teacher) == 1) {
                response.getWriter().write("success");
            } else {
                response.getWriter().write("fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
