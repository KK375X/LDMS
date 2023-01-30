package com.ldms.view;

import com.alibaba.fastjson.JSONObject;
import com.ldms.dao.DeviceDao;
import com.ldms.dao.DeviceDaoImplement;
import com.ldms.pojo.Vo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchDeviceUseServlet", value = "/SearchDeviceUseServlet")
public class SearchDeviceUseServlet extends HttpServlet {

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DeviceDao deviceDao = new DeviceDaoImplement();
        String pageStr = request.getParameter("page");//获取分页
        String limitStr = request.getParameter("limit");//获取limit
        String deviceId = request.getParameter("deviceId");
        String entity = request.getParameter("entity");

        try {
            List<Object> list = null;
            response.setContentType("text/html; charset=UTF-8");
            Vo vo = new Vo();
            if (entity.equals("admin")) {
                String userId = request.getParameter("userId");
                list = deviceDao.searchDeviceUseList(deviceId, userId, pageStr, limitStr);
                vo.setCount(list.size());
            } else if (entity.equals("teacher") || entity.equals("student")) {
                String useDate = request.getParameter("useDate");
                String id = request.getParameter("id");
                list = deviceDao.searchUserDeviceUseList(deviceId, useDate, id, pageStr, limitStr);
                vo.setCount(list.size());
            }
            vo.setCode(0);
            vo.setMsg("success");
            vo.setData(list);
            response.getWriter().write(JSONObject.toJSONString(vo).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
