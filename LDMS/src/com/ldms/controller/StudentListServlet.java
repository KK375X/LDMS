package com.ldms.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldms.dao.UserDao;
import com.ldms.dao.UserDaoImplement;
import com.ldms.pojo.Vo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentListServlet", value = "/StudentListServlet")
public class StudentListServlet extends HttpServlet {

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDaoImplement();
        String pageStr = request.getParameter("page");//获取分页
        String limitStr = request.getParameter("limit");//获取limit
        try {
//            List<Object> list = userDao.selectStudentList();// 获取数据
            List<Object> list = userDao.selectStudentList(pageStr, limitStr);// 获取数据
            response.setContentType("text/html; charset=UTF-8");// 设置页面编码类型
            response.setCharacterEncoding("UTF-8");
            Vo vo = new Vo();
            vo.setCode(0);
            vo.setMsg("");
            vo.setCount(userDao.countStudentInfo());
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
