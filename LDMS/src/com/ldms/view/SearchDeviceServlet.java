package com.ldms.view;

import com.alibaba.fastjson.JSONObject;
import com.ldms.dao.DeviceDao;
import com.ldms.dao.DeviceDaoImplement;
import com.ldms.dao.UserDao;
import com.ldms.dao.UserDaoImplement;
import com.ldms.pojo.Vo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchDeviceServlet", value = "/SearchDeviceServlet")
public class SearchDeviceServlet extends HttpServlet {

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
        String deviceName = request.getParameter("deviceName");
        String type = request.getParameter("type");
        String state = request.getParameter("state");
        try {
            List<Object> list = deviceDao.searchDeviceList(deviceName, type, state, pageStr, limitStr);
            response.setContentType("text/html; charset=UTF-8");
            Vo vo = new Vo();
            vo.setCode(0);
            vo.setMsg("success");
            vo.setCount(list.size());
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
