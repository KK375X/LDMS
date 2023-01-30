package com.ldms.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldms.dao.LaboratoryDao;
import com.ldms.dao.LaboratoryDaoImplement;
import com.ldms.pojo.Vo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LaboratoryUseListServlet", value = "/LaboratoryUseListServlet")
public class LaboratoryUseListServlet extends HttpServlet {

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
        String entity = request.getParameter("entity");
        String id = request.getParameter("id");

        try {
            List<Object> list = null;
            response.setContentType("text/html; charset=UTF-8");// 设置页面编码类型
            response.setCharacterEncoding("UTF-8");
            Vo vo = new Vo();
            if (entity.equals("admin")) {
                list = laboratoryDao.selectLaboratoryUseList(pageStr, limitStr);// 获取数据
                vo.setCount(laboratoryDao.countLaboratoryUseInfo());
            } else if (entity.equals("teacher")) {
                list = laboratoryDao.selectTeacherLaboratoryUseList(pageStr, limitStr, id);// 获取数据
                vo.setCount(laboratoryDao.countTeacherLaboratoryUseInfo(id));
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
