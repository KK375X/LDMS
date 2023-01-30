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

@WebServlet(name = "DeviceListServlet", value = "/DeviceListServlet")
public class DeviceListServlet extends HttpServlet {

    /**
     * doGet
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
        try {
//            List<Object> list = deviceDao.selectDeviceList();// 获取数据
            List<Object> list = deviceDao.selectDeviceList(pageStr, limitStr);// 获取数据
            response.setContentType("text/html; charset=UTF-8");// 设置页面编码类型
            response.setCharacterEncoding("UTF-8");
            Vo vo = new Vo();
            vo.setCode(0);
            vo.setMsg("");
            vo.setCount(deviceDao.countDeviceInfo());
            vo.setData(list);
            response.getWriter().write(JSONObject.toJSONString(vo).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * doPost
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


    // 测试数据是否被获取
//    public static void doGet() {
//        DeviceDao deviceDao = new DeviceDaoImplement();
//        try {
//            List<Object> list = deviceDao.selectDeviceList();// 获取数据
//            String json = JSONObject.toJSONString(list);
//            System.out.println(json);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
