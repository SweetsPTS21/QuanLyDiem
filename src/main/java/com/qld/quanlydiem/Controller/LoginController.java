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
        String username, pass, message = "";
        int thatbai = 0;
        UsersDAO usersDAO = new UsersDAO();

        username = request.getParameter("username");
        pass = request.getParameter("password");

        if (username.length() < 6 || username.length() > 30) {
            message = "Username must be between 6 and 30 characters";
        }
        if (pass.length() < 6 || pass.length() > 18) {
            message = "Password must be between 6 and 18 characters";
        }
        String regex = "^[a-zA-Z0-9_]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        if (!matcher.matches()) {
            message = "Username must not contain special characters";
        }

        String regex2 = ".*\\s+.*";
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcherPass = pattern2.matcher(pass);
        Matcher matcherUsername = pattern2.matcher(username);
        if (matcherUsername.matches() || matcherPass.matches()) {
            message = "Username/Password must not contain space characters";
        }

        if (message.equals("")) {
            if(usersDAO.Login(username, pass) == 1) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("userId", usersDAO.getUsersByUsername(username).getId());
                session.setAttribute("role", usersDAO.getUsersByUsername(username).getRole());
                if (request.getAttribute("auth") != null) {
                    request.removeAttribute("auth");
                }
                response.sendRedirect("home.jsp");
                return;
            } else {
                message = "Username or password is incorrect";

            }
        }
        //System.out.println(message);
        request.setAttribute("message", message);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}
