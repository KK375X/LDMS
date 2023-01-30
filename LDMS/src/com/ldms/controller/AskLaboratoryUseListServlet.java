package com.ldms.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldms.dao.DeviceDao;
import com.ldms.dao.DeviceDaoImplement;
import com.ldms.dao.LaboratoryDao;
import com.ldms.dao.LaboratoryDaoImplement;
import com.ldms.pojo.Vo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AskLaboratoryUseListServlet", value = "/AskLaboratoryUseListServlet")
public class AskLaboratoryUseListServlet extends HttpServlet {

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LaboratoryDao laboratoryDao = new LaboratoryDaoImplement();
        String pageStr = request.getParameter("page");//获取分页
        String limitStr = request.getParameter("limit");//获取limit

        try {
            List<Object> list = laboratoryDao.selectAskLaboratoryUseList(pageStr, limitStr);// 获取数据
            response.setContentType("text/html; charset=UTF-8");// 设置页面编码类型
            response.setCharacterEncoding("UTF-8");
            Vo vo = new Vo();
            vo.setCode(0);
            vo.setMsg("");
            vo.setCount(laboratoryDao.countAskLaboratoryUseInfo());
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
