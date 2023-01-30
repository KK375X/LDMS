package com.ldms.controller;

import com.ldms.pojo.DeviceUse;
import com.ldms.service.DeviceService;
import com.ldms.service.DeviceServiceImplement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddDeviceUseServlet", value = "/AddDeviceUseServlet")
public class AddDeviceUseServlet extends HttpServlet {

    private final DeviceService deviceService = new DeviceServiceImplement();

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
        String userId = request.getParameter("userId");
        String useDate = request.getParameter("useDate");
        String beginTime = request.getParameter("beginTime");
        String endTime = request.getParameter("endTime");
        String state = request.getParameter("state");

        DeviceUse deviceUse = new DeviceUse();
        deviceUse.setDeviceId(deviceId);
        deviceUse.setUserId(userId);
        deviceUse.setUseDate(useDate);
        deviceUse.setBeginTime(beginTime);
        deviceUse.setEndTime(endTime);
        deviceUse.setState(state);

        try {
            if (deviceService.addDeviceUse(deviceUse) == 1) {
                response.getWriter().write("success");
            } else {
                response.getWriter().write("fail");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
