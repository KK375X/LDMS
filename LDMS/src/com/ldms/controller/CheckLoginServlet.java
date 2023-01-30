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

@WebServlet(name = "CheckLoginServlet", value = "/CheckLoginServlet")
public class CheckLoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private LoginService loginService = new LoginServiceImplement();// 实例化对象

    public CheckLoginServlet() {
        super();
    }

    /**
     * doGet
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);//post请求更安全
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
        // 获取前端页面输入的数据
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String entity = request.getParameter("entity");

        //进行身份判断
        if (entity.equals("管理员")) {
            Admin admin = new Admin();
            try {
                admin = loginService.selectAdmin(id, password);
                if (admin != null) {//成功找到
                    HttpSession session = request.getSession();
                    session.setAttribute("admin", admin);
                    response.getWriter().write("success");
                } else {//为找到
                    response.getWriter().write("fail");
                }
            }catch (Exception e) {
                e.printStackTrace();
            }

        } else if (entity.equals("教师")) {
            Teacher teacher = new Teacher();
            try {
                teacher = loginService.selectTeacher(id, password);
                if (teacher != null) {//成功找到
                    HttpSession session = request.getSession();
                    session.setAttribute("teacher", teacher);
                    response.getWriter().write("success");
                } else {//为找到
                    response.getWriter().write("fail");
                }
            }catch (Exception e) {
                e.printStackTrace();
            }

        } else if (entity.equals("学生")) {
            Student student = new Student();
            try {
                student = loginService.selectStudent(id, password);
                if (student != null) {//成功找到
                    HttpSession session = request.getSession();
                    session.setAttribute("student", student);
                    response.getWriter().write("success");
                } else {//为找到
                    response.getWriter().write("fail");
                }
            }catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
