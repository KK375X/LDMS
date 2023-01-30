package com.ldms.controller;

import com.ldms.dao.EditDao;
import com.ldms.dao.EditDaoImplement;
import com.ldms.pojo.Teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditTeacherServlet", value = "/EditTeacherServlet")
public class EditTeacherServlet extends HttpServlet {

    public EditTeacherServlet() {
        super();
    }

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
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String id = request.getParameter("id");
        String teacherId = request.getParameter("teacherId");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        String college = request.getParameter("college");
        String position = request.getParameter("position");
        String phone = request.getParameter("phone");

        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacher.setTeacherId(teacherId);
        teacher.setName(name);
        teacher.setPassword(password);
        teacher.setAge(age);
        teacher.setCollege(college);
        teacher.setPosition(position);
        teacher.setPhone(phone);

        EditDao editDao = new EditDaoImplement();// 实例化一个对象
        try {
            if (editDao.EditTeacher(teacher) == 1) {
                response.getWriter().write("success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
