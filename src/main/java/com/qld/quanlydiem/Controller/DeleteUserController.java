package com.qld.quanlydiem.Controller;


import com.qld.quanlydiem.DAO.UsersDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.IOException;

@WebServlet(name = "DeleteUserController", value = "/deleteUser")
public class DeleteUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF8");
        HttpSession session = request.getSession();
        try {
            String id = request.getParameter("userId");
            UsersDAO usersDAO = new UsersDAO();
            usersDAO.Delete(id);
            response.sendRedirect("home.jsp");
        } catch (NullPointerException e) {
            e.printStackTrace();
            response.sendRedirect("home.jsp");
        }
    }
}
