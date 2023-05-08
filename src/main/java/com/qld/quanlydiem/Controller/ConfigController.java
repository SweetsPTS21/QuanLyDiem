package com.qld.quanlydiem.Controller;

import com.qld.quanlydiem.DAO.SubjectDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ConfigController", value = "/config")
public class ConfigController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        try {
            List<String> ids = new ArrayList();
            ids = SubjectDAO.getInstance().getAllSubjectId();


            request.setAttribute("ids", ids);
            request.getRequestDispatcher("configSubject.jsp").forward(request, response);
        } catch (NullPointerException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
