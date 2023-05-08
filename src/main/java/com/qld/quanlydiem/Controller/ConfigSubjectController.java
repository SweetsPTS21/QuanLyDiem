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
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        List<String> message = new ArrayList<>();
        
        try {
            String idSubject = request.getParameter("idSubject");
            String selectDTP = request.getParameter("selectDTP");
            String subPercent = request.getParameter("subPercent");
            int persent = Integer.parseInt(subPercent);
            int id_dauDiem = 0;
            if(persent<0||persent>100){
                message.add("Vui lòng nhập số lớn hơn 0 và nhỏ hơn 100");
            }
            switch (selectDTP) {
                case "Chuyên cần":
                    id_dauDiem = 1;
                    if(persent>30){
                        message.add("Điểm chuyên cần phải nhỏ hơn 30%");
                    }
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
                    if(persent<50){
                        message.add("Điểm thi phải lớn hơn 50%");
                    }
                    break;
            }
            if(idSubject.length()<5||idSubject.length()>7){
                message.add("Mã môn học phải chứa 5 đến 7 kí tự");
            }
            else if(message.size()==0) {
                String status = SubjectDAO.getInstance().UpdateSubject(idSubject,id_dauDiem, subPercent);
                message.add(status);
            }
            
            request.setAttribute("message", message);
            RequestDispatcher dispatcher= request.getRequestDispatcher("configSubject.jsp");
            if(dispatcher!=null){
                dispatcher.forward(request, response);
            }
        } catch (NullPointerException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
