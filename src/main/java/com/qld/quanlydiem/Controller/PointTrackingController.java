package com.qld.quanlydiem.Controller;

import com.qld.quanlydiem.DAO.PointTrackingDAO;
import com.qld.quanlydiem.DAO.ScoreDAO;
import com.qld.quanlydiem.DAO.UsersDAO;
import com.qld.quanlydiem.Model.PointBoardItem;
import com.qld.quanlydiem.Model.PointBroad;
import com.qld.quanlydiem.Model.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PointTrackingController", value = "/pointTracking")
public class PointTrackingController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            String TKByLHP = request.getParameter("TKByLHP");
            ArrayList<String[]> list = ScoreDAO.getInstance().getDiemByLHP(TKByLHP);
            request.setAttribute("listStudentByLHP", list);
            request.getRequestDispatcher("exportReport.jsp").forward(request, response);

        } catch (NullPointerException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            String findGrade = request.getParameter("findGrade");
            String findSubject = request.getParameter("findSubject");
            String findClass = request.getParameter("findClass");
            String findTerm = request.getParameter("findTerm");
            String findKhoa = request.getParameter("findKhoa");
            PointTrackingDAO pointTrackingDAO = new PointTrackingDAO();
            List<PointBoardItem> list = pointTrackingDAO.getListPointBoard(findGrade, findSubject, findKhoa, findClass, findTerm);

            List<PointBroad> listPointBoard = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                double tk10 = (list.get(i).getAttendancePoint()*10 + list.get(i).getTestPoint()*10
                        + list.get(i).getPracticePoint()*0 + list.get(i).getExercisePoint()*10 +
                        list.get(i).getExamPoint()*70)/100 ;

                String tkCh="" , kq="";
                if(tk10>=9) {
                    tkCh = "A+";
                    kq="4.0";
                } else if(tk10>=8.5) {
                    tkCh = "A";
                    kq="3.7";
                } else if(tk10>=8) {
                    tkCh = "B+";
                    kq="3.5";
                } else if(tk10>=7) {
                    tkCh = "B";
                    kq="3.0";
                } else if(tk10>=6.5) {
                    tkCh = "C+";
                    kq="2.5";
                } else if(tk10>=5.5) {
                    tkCh = "C";
                    kq="2";
                } else if(tk10>=5) {
                    tkCh = "D+";
                    kq="1.5";
                } else if(tk10>=4) {
                    tkCh = "D";
                    kq="1.0";
                } else {
                    tkCh = "F";
                    kq="0.0";
                }

                PointBroad pointBroad = new PointBroad();
                pointBroad.setPointBoardItem(list.get(i));
                pointBroad.setTongKet10(Double.toString(tk10));
                pointBroad.setTongKetChu(tkCh);
                pointBroad.setKetQua(kq);

                listPointBoard.add(pointBroad);
            }
            request.setAttribute("listPointBoard", listPointBoard);

            request.getRequestDispatcher("managePoint.jsp").forward(request, response);
        } catch (NullPointerException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
