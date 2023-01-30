package com.ldms.view;

import com.ldms.dao.DeviceDao;
import com.ldms.dao.DeviceDaoImplement;
import com.ldms.dao.LaboratoryDao;
import com.ldms.dao.LaboratoryDaoImplement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteLaboratoryUseServlet", value = "/DeleteLaboratoryUseServlet")
public class DeleteLaboratoryUseServlet extends HttpServlet {

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
        LaboratoryDao laboratoryDao = new LaboratoryDaoImplement();
        String laboratoryId = request.getParameter("laboratoryId");

        try {
            laboratoryDao.deleteLaboratoryUse(laboratoryId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
