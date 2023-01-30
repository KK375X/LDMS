package com.ldms.controller;

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

@WebServlet(name = "DeviceUseListServlet", value = "/DeviceUseListServlet")
public class DeviceUseListServlet extends HttpServlet {

    /**
     * doGet
     *
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
        String entity = request.getParameter("entity");
        String id = request.getParameter("id");

        try {
            List<Object> list = null;
            response.setContentType("text/html; charset=UTF-8");// 设置页面编码类型
            response.setCharacterEncoding("UTF-8");
            Vo vo = new Vo();
            if (entity.equals("admin")) {
                list = deviceDao.selectDeviceUseList(pageStr, limitStr);// 获取数据
                vo.setCount(deviceDao.countDeviceUseInfo());
            } else if (entity.equals("teacher") || entity.equals("student")) {
                list = deviceDao.selectUserDeviceUseList(pageStr, limitStr, id);// 获取数据
                vo.setCount(deviceDao.countUserDeviceUseInfo(id));
            }
            vo.setCode(0);
            vo.setMsg("");
            vo.setData(list);
            response.getWriter().write(JSONObject.toJSONString(vo).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * doPost
     *
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
