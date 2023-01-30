package com.ldms.view;

import com.alibaba.fastjson.JSONObject;
import com.ldms.dao.UserDao;
import com.ldms.dao.UserDaoImplement;
import com.ldms.pojo.Vo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchStudentServlet", value = "/SearchStudentServlet")
public class SearchStudentServlet extends HttpServlet {

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
        String name = request.getParameter("name");
        String classes = request.getParameter("classes");
        String college = request.getParameter("college");
        try {
            List<Object> list = userDao.searchStudentList(name, classes, college, pageStr, limitStr);
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
