package com.qld.quanlydiem.Controller;

import com.qld.quanlydiem.DAO.SubjectDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ConfigSubjectController", value = "/configSubject")
public class ConfigSubjectController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        try {
            String idSubject = request.getParameter("idSubject");
            String selectDTP = request.getParameter("selectDTP");
            String subPercent = request.getParameter("subPercent");
            int id_dauDiem = 0;
            switch (selectDTP) {
                case "Chuyên cần":
                    id_dauDiem = 1;
                    break;
                case "Kiểm tra":
                    id_dauDiem = 2;
                    break;
                case "Bài tập":
                    id_dauDiem = 3;
                    break;
                case "Thực hành":
                    id_dauDiem = 4;
                    break;
                case "Thi":
                    id_dauDiem = 5;
                    break;
            }
            Boolean status = SubjectDAO.getInstance().UpdateSubject(idSubject,id_dauDiem, subPercent);
            if(status){
                request.setAttribute("message", "success");
            }
            else {
                request.setAttribute("message", "failure");
            }
            request.getRequestDispatcher("configSubject.jsp").forward(request, response);
        } catch (NullPointerException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
