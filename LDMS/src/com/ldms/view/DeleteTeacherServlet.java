package com.ldms.view;

import com.ldms.dao.UserDao;
import com.ldms.dao.UserDaoImplement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteTeacherServlet", value = "/DeleteTeacherServlet")
public class DeleteTeacherServlet extends HttpServlet {

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
        UserDao userDao = new UserDaoImplement();
        String id = request.getParameter("id");

        try {
            userDao.deleteTeacher(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
