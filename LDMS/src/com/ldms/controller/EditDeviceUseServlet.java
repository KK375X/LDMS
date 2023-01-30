package com.ldms.controller;

import com.ldms.dao.EditDao;
import com.ldms.dao.EditDaoImplement;
import com.ldms.pojo.DeviceUse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditDeviceUseServlet", value = "/EditDeviceUseServlet")
public class EditDeviceUseServlet extends HttpServlet {

    public EditDeviceUseServlet() {
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
        String deviceId = request.getParameter("deviceId"); // 共同属性
        String userId = request.getParameter("userId");
        String useDate = request.getParameter("useDate");
        String state = request.getParameter("state");

        DeviceUse deviceUse = new DeviceUse();
        deviceUse.setDeviceId(deviceId);    // 共同属性
        deviceUse.setUserId(userId);
        deviceUse.setUseDate(useDate);

        EditDao editDao = new EditDaoImplement();// 实例化一个对象
        try {
            if (state.equals("edit")) {
                String beginTime = request.getParameter("beginTime");
                String endTime = request.getParameter("endTime");
                deviceUse.setBeginTime(beginTime);
                deviceUse.setEndTime(endTime);

                if (editDao.EditDeviceUse(deviceUse) == 1) {
                    response.getWriter().write("success");
                } else {
                    response.getWriter().write("fail");
                }

            } else if (state.equals("待审核") || state.equals("同意") || state.equals("否决")) {
                deviceUse.setState(state);

                if (editDao.AskDeviceUse(deviceUse) == 1) {
                    response.getWriter().write("success");
                } else {
                    response.getWriter().write("fail");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
