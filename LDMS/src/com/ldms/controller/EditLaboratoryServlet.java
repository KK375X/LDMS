package com.ldms.controller;

import com.ldms.dao.EditDao;
import com.ldms.dao.EditDaoImplement;
import com.ldms.pojo.Device;
import com.ldms.pojo.Laboratory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditLaboratoryServlet", value = "/EditLaboratoryServlet")
public class EditLaboratoryServlet extends HttpServlet {

    public EditLaboratoryServlet() {
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
        String laboratoryId = request.getParameter("laboratoryId");
        String laboratoryName = request.getParameter("laboratoryName");
        String teacherId = request.getParameter("teacherId");
        String state = request.getParameter("state");
        String address = request.getParameter("address");

        Laboratory laboratory = new Laboratory();
        laboratory.setLaboratoryId(laboratoryId);
        laboratory.setLaboratoryName(laboratoryName);
        laboratory.setTeacherId(teacherId);
        laboratory.setState(state);
        laboratory.setAddress(address);

        EditDao editDao = new EditDaoImplement();// 实例化一个对象
        try {
            if (editDao.EditLaboratory(laboratory) == 1) {
                response.getWriter().write("success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
