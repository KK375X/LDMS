package com.ldms.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ldms.dao.UserDao;
import com.ldms.dao.UserDaoImplement;
import com.ldms.pojo.Vo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "TeacherListServlet", value = "/TeacherListServlet")
public class TeacherListServlet extends HttpServlet {

    // 测试list数据
//    public static void main(String[] args) {
//        TestList();
//    }

    private static final long serialVersionUID = 1L;

    public TeacherListServlet() {
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

        UserDao userDao = new UserDaoImplement();
        String pageStr = request.getParameter("page");//获取分页
        String limitStr = request.getParameter("limit");//获取limit
        try {
//            List<Object> list = userDao.selectTeacherList();// 获取数据
            List<Object> list = userDao.selectTeacherList(pageStr, limitStr);
            response.setContentType("text/html; charset=UTF-8");// 设置页面编码类型
            response.setCharacterEncoding("UTF-8");
            Vo vo = new Vo();
            vo.setCode(0);
            vo.setMsg("");
            vo.setCount(userDao.countTeacherInfo());
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

    // 测试list返回数据的代码
//    public static void TestList() {
//        UserDao userDao = new UserDaoImplement();
//        try {
//            List<Object> list = userDao.selectTeacherList();
//            String json = JSONObject.toJSONString(list);
//            System.out.println(json);
//
//            Vo vo = new Vo();
//            vo.setCode(0);
//            vo.setMsg("success");
//            vo.setCount(list.size());
//            vo.setData(list);
//            System.out.println(vo.getCode());
//            System.out.println(vo.getMsg());
//            System.out.println(vo.getCount());
//            System.out.println(vo.getData());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
