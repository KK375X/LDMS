package com.ldms.view;

import com.alibaba.fastjson.JSONObject;
import com.ldms.dao.LaboratoryDao;
import com.ldms.dao.LaboratoryDaoImplement;
import com.ldms.pojo.Vo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchLaboratoryUseServlet", value = "/SearchLaboratoryUseServlet")
public class SearchLaboratoryUseServlet extends HttpServlet {

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
        String laboratoryId = request.getParameter("laboratoryId");
        String entity = request.getParameter("entity");

        try {
            List<Object> list = null;
            response.setContentType("text/html; charset=UTF-8");
            Vo vo = new Vo();
            if (entity.equals("admin")) {
                String teacherId = request.getParameter("teacherId");
                list = laboratoryDao.searchLaboratoryUseList(laboratoryId, teacherId, pageStr, limitStr);
                vo.setCount(list.size());
            } else if (entity.equals("teacher")) {
                String useDate = request.getParameter("useDate");
                String id = request.getParameter("id");
                list = laboratoryDao.searchUserLaboratoryUseList(laboratoryId, useDate, id, pageStr, limitStr);
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
