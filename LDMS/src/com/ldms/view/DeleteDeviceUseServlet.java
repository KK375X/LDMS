package com.ldms.view;

import com.ldms.dao.DeviceDao;
import com.ldms.dao.DeviceDaoImplement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteDeviceUseServlet", value = "/DeleteDeviceUseServlet")
public class DeleteDeviceUseServlet extends HttpServlet {

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
        DeviceDao deviceDao = new DeviceDaoImplement();
        String deviceId = request.getParameter("deviceId");

        try {
            deviceDao.deleteDeviceUse(deviceId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
