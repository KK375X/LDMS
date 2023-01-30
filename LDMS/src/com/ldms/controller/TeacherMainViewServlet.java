package com.ldms.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TeacherMainViewServlet", value = "/TeacherMainViewServlet")
public class TeacherMainViewServlet extends HttpServlet {

    public TeacherMainViewServlet() {
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
        // 暂时跳转到管理员主界面
        request.getRequestDispatcher("/TeacherMain.jsp").forward(request, response);
    }
}
