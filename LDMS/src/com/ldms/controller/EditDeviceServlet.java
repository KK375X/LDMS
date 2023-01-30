package com.ldms.controller;

import com.ldms.dao.EditDao;
import com.ldms.dao.EditDaoImplement;
import com.ldms.pojo.Admin;
import com.ldms.pojo.Device;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditDeviceServlet", value = "/EditDeviceServlet")
public class EditDeviceServlet extends HttpServlet {

    public EditDeviceServlet() {
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
        String deviceId = request.getParameter("deviceId");
        String type = request.getParameter("type");
        String deviceName = request.getParameter("deviceName");
        String teacherId = request.getParameter("teacherId");
        String state = request.getParameter("state");
        String laboratoryId = request.getParameter("laboratoryId");

        Device device = new Device();
        device.setDeviceId(deviceId);
        device.setType(type);
        device.setDeviceName(deviceName);
        device.setTeacherId(teacherId);
        device.setState(state);
        device.setLaboratoryId(laboratoryId);

        EditDao editDao = new EditDaoImplement();// 实例化一个对象
        try {
            if (editDao.EditDevice(device) == 1) {
                response.getWriter().write("success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
