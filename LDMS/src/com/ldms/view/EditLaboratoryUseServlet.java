package com.ldms.view;

import com.ldms.dao.EditDao;
import com.ldms.dao.EditDaoImplement;
import com.ldms.pojo.DeviceUse;
import com.ldms.pojo.LaboratoryUse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditLaboratoryUseServlet", value = "/EditLaboratoryUseServlet")
public class EditLaboratoryUseServlet extends HttpServlet {

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String laboratoryId = request.getParameter("laboratoryId");
        String teacherId = request.getParameter("teacherId");
        String useDate = request.getParameter("useDate");
        String state = request.getParameter("state");

        LaboratoryUse laboratoryUse = new LaboratoryUse();
        laboratoryUse.setLaboratoryId(laboratoryId);
        laboratoryUse.setTeacherId(teacherId);
        laboratoryUse.setUseDate(useDate);

        EditDao editDao = new EditDaoImplement();// 实例化一个对象
        try {
            if (state.equals("edit")) {
                String beginTime = request.getParameter("beginTime");
                String endTime = request.getParameter("endTime");
                laboratoryUse.setBeginTime(beginTime);
                laboratoryUse.setEndTime(endTime);
                System.out.println(beginTime + endTime);

                if (editDao.EditLaboratoryUse(laboratoryUse) == 1) {
                    response.getWriter().write("success");
                } else {
                    response.getWriter().write("fail");
                }

            } else if (state.equals("待审核") || state.equals("同意") || state.equals("否决")) {
                laboratoryUse.setState(state);

                if (editDao.AskLaboratoryUse(laboratoryUse) == 1) {
                    response.getWriter().write("success");
                } else {
                    response.getWriter().write("fail");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
