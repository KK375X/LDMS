package com.ldms.controller;

import com.ldms.pojo.Device;
import com.ldms.service.DeviceService;
import com.ldms.service.DeviceServiceImplement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddDeviceServlet", value = "/AddDeviceServlet")
public class AddDeviceServlet extends HttpServlet {

    private DeviceService deviceService = new DeviceServiceImplement();

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
        String deviceId = request.getParameter("deviceId");
        String type = request.getParameter("type");
        String deviceName = request.getParameter("deviceName");
        String teacherId = request.getParameter("teacherId");
        String state = request.getParameter("state");
        String laboratoryId = request.getParameter("laboratoryId");
        String createDate = request.getParameter("createDate");

        Device device = new Device();
        device.setDeviceId(deviceId);
        device.setType(type);
        device.setDeviceName(deviceName);
        device.setTeacherId(teacherId);
        device.setState(state);
        device.setLaboratoryId(laboratoryId);
        device.setCreateDate(createDate);

        try {
            if (deviceService.addDevice(device) == 1) {
                response.getWriter().write("success");
            } else {
                response.getWriter().write("fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
