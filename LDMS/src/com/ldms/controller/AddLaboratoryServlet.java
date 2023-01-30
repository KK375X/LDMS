package com.ldms.controller;

import com.ldms.pojo.Laboratory;
import com.ldms.service.LaboratoryService;
import com.ldms.service.LaboratoryServiceImplement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddLaboratoryServlet", value = "/AddLaboratoryServlet")
public class AddLaboratoryServlet extends HttpServlet {

    private LaboratoryService laboratoryService = new LaboratoryServiceImplement();

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
        String laboratoryId = request.getParameter("laboratoryId");
        String laboratoryName = request.getParameter("laboratoryName");
        String teacherId = request.getParameter("teacherId");
        String state = request.getParameter("state");
        String address = request.getParameter("address");
        String createDate = request.getParameter("createDate");

        Laboratory laboratory = new Laboratory();
        laboratory.setLaboratoryId(laboratoryId);
        laboratory.setLaboratoryName(laboratoryName);
        laboratory.setTeacherId(teacherId);
        laboratory.setState(state);
        laboratory.setAddress(address);
        laboratory.setCreateDate(createDate);

        try {
            if (laboratoryService.addLaboratory(laboratory) == 1) {
                response.getWriter().write("success");
            } else {
                response.getWriter().write("fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
