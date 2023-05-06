package com.qld.quanlydiem.Controller;

import com.qld.quanlydiem.DAO.KhoaDAO;
import com.qld.quanlydiem.DAO.StudentDAO;
import com.qld.quanlydiem.Model.Khoa;
import com.qld.quanlydiem.Model.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "FindStudentController", value = "/findStudent")
public class FindStudentController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            if(request.getParameter("khoa") != null) {
                String findKhoa = request.getParameter("khoa");
                KhoaDAO khoaDAO = new KhoaDAO();
                Khoa khoa = khoaDAO.getKhoaByName(findKhoa);
                ArrayList<Users> listStudentByKhoa = StudentDAO.getInstance().getStudentsByKhoaID(khoa.getId());
                request.setAttribute("listStudentByKhoa", listStudentByKhoa);
            }

            request.getRequestDispatcher("exportReport.jsp").forward(request, response);
        } catch (NullPointerException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            if(request.getParameter("findLHP") != null) {
                String findLHP = request.getParameter("findLHP");
                ArrayList<Users> listStudent = StudentDAO.getInstance().getStudentsByTenLopHP(findLHP);
                request.setAttribute("listStudent", listStudent);
            }

            if(request.getParameter("khoa") != null) {
                String findKhoa = request.getParameter("khoa");
                KhoaDAO khoaDAO = new KhoaDAO();
                Khoa khoa = khoaDAO.getKhoaByName(findKhoa);
                ArrayList<Users> listStudentByKhoa = StudentDAO.getInstance().getStudentsByKhoaID(khoa.getId());
                request.setAttribute("listStudentByKhoa", listStudentByKhoa);
            }

            request.getRequestDispatcher("exportReport.jsp").forward(request, response);
        } catch (NullPointerException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
