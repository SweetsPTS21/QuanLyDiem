package com.qld.quanlydiem.Controller;

import com.mysql.cj.Session;
import com.qld.quanlydiem.DAO.UsersDAO;
import com.qld.quanlydiem.Model.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UpdateUserController", value = "/updateUser")
public class UpdateUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            String id = (String) session.getAttribute("UEID");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String age = request.getParameter("age");
            String password = request.getParameter("password");
            String phone = request.getParameter("phoneNumber");
            String address = request.getParameter("address");
            String role = request.getParameter("selectRole");
            String khoa;
            if(request.getParameter("selectKhoa") == null){
                khoa = "";
            } else {
                khoa = request.getParameter("selectKhoa");
            }

            Users users = new Users();
            UsersDAO usersDAO = new UsersDAO();
            users.setId(id);
            users.setFirstName(firstName);
            users.setLastName(lastName);
            users.setUsername(username);
            users.setEmail(email);
            users.setAge(Integer.parseInt(age));
            users.setPassword(password);
            users.setPhoneNumber(phone);
            users.setAddress(address);
            users.setRole(role);

            usersDAO.Update(users, khoa);

            response.sendRedirect("home.jsp");
        } catch (NullPointerException | NumberFormatException e) {
            e.printStackTrace();
        }

    }
}