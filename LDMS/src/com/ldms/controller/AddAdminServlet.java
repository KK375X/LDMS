package com.ldms.controller;

import com.ldms.pojo.Admin;
import com.ldms.service.UserService;
import com.ldms.service.UserServiceImplement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddAdminServlet", value = "/AddAdminServlet")
public class AddAdminServlet extends HttpServlet {

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
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String createDate = request.getParameter("createDate");

        Admin admin = new Admin();
        admin.setId(id);
        admin.setName(name);
        admin.setPassword(password);
        admin.setPhone(phone);
        admin.setCreateDate(createDate);

        try {
            if (userService.addAdmin(admin) == 1) {
                response.getWriter().write("success");
            } else {
                response.getWriter().write("fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
