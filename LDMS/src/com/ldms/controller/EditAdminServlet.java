package com.ldms.controller;

import com.ldms.dao.EditDao;
import com.ldms.dao.EditDaoImplement;
import com.ldms.pojo.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditAdminServlet", value = "/EditAdminServlet")
public class EditAdminServlet extends HttpServlet {

    public EditAdminServlet() {
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
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String operation = request.getParameter("EditInfo");    // 获取用户操作

        Admin admin = new Admin();
        admin.setId(id);
        admin.setName(name);
        admin.setPassword(password);
        admin.setPhone(phone);

        EditDao editDao = new EditDaoImplement();// 实例化一个对象
        try {
            if (editDao.EditAdmin(admin) == 1) {
                response.getWriter().write("success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
