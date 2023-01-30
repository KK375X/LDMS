package com.ldms.controller;

import com.ldms.dao.EditDao;
import com.ldms.dao.EditDaoImplement;
import com.ldms.pojo.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditAdminPasswordServlet", value = "/EditAdminPasswordServlet")
public class EditAdminPasswordServlet extends HttpServlet {

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
        String password = request.getParameter("password");

        Admin admin = new Admin();
        admin.setId(id);
        admin.setPassword(password);

        EditDao editDao = new EditDaoImplement();// 实例化一个对象
        try {
            if (editDao.EditAdminPassword(admin) == 1) {
                response.getWriter().write("success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
