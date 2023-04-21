package com.qld.quanlydiem.Controller;

import com.qld.quanlydiem.DAO.UsersDAO;
import com.qld.quanlydiem.Model.Users;
import com.qld.quanlydiem.Utilities.Tags;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "LoginController", value = "/Login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String pass = request.getParameter("password");
        String username = request.getParameter("username");
        int thatbai = 0;
        UsersDAO usersDAO = new UsersDAO();

        if (usersDAO.Login(username, pass) == 1) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("userId", usersDAO.getUsersByUsername(username).getId());
            session.setAttribute("isAdmin", usersDAO.getUsersByUsername(username).getRole());
            if(request.getAttribute("auth") != null) {
                request.removeAttribute("auth");
            }
            response.sendRedirect("home.jsp");
        }
        else {
            thatbai = 1;
            request.setAttribute("auth", thatbai);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

}
