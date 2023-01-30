package com.ldms.controller;

import com.ldms.dao.EditDao;
import com.ldms.dao.EditDaoImplement;
import com.ldms.pojo.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditStudentServlet", value = "/EditStudentServlet")
public class EditStudentServlet extends HttpServlet {

    public EditStudentServlet() {
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
        String studentId = request.getParameter("studentId");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        String phone = request.getParameter("phone");
        String teacherId = request.getParameter("teacherId");
        String classes = request.getParameter("classes");
        String college = request.getParameter("college");

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

        EditDao editDao = new EditDaoImplement();// 实例化一个对象
        try {
            if (editDao.EditStudent(student) == 1) {
                System.out.println("学生信息修改成功！");
                response.getWriter().write("success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
