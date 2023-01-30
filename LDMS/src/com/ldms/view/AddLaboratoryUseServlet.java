package com.ldms.view;

import com.ldms.pojo.DeviceUse;
import com.ldms.pojo.LaboratoryUse;
import com.ldms.service.DeviceService;
import com.ldms.service.DeviceServiceImplement;
import com.ldms.service.LaboratoryService;
import com.ldms.service.LaboratoryServiceImplement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddLaboratoryUseServlet", value = "/AddLaboratoryUseServlet")
public class AddLaboratoryUseServlet extends HttpServlet {

    private final LaboratoryService laboratoryService = new LaboratoryServiceImplement();

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
        String teacherId = request.getParameter("teacherId");
        String useDate = request.getParameter("useDate");
        String beginTime = request.getParameter("beginTime");
        String endTime = request.getParameter("endTime");
        String state = request.getParameter("state");

        LaboratoryUse laboratoryUse = new LaboratoryUse();
        laboratoryUse.setLaboratoryId(laboratoryId);
        laboratoryUse.setTeacherId(teacherId);
        laboratoryUse.setUseDate(useDate);
        laboratoryUse.setBeginTime(beginTime);
        laboratoryUse.setEndTime(endTime);
        laboratoryUse.setState(state);

        try {
            if (laboratoryService.addLaboratoryUse(laboratoryUse) == 1) {
                response.getWriter().write("success");
            } else {
                response.getWriter().write("fail");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
