package com.qld.quanlydiem.Controller;



import com.qld.quanlydiem.DAO.UsersDAO;
import com.qld.quanlydiem.Model.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AddNewUserController", value = "/addNewUser")
public class AddUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html; charset=UTF-8");
            request.setCharacterEncoding("UTF-8");

            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String age = request.getParameter("age");
            String password = request.getParameter("password");
            String phone = request.getParameter("phoneNumber");
            String address = request.getParameter("address");
            String note = request.getParameter("note");
            String role = request.getParameter("selectRole");
            String khoa = "null";
            if(request.getParameter("khoa") != null) {
                khoa = request.getParameter("khoa");
            }

            Users users = new Users();
            UsersDAO usersDAO = new UsersDAO();
            users.setFirstName(firstName);
            users.setLastName(lastName);
            users.setUsername(username);
            users.setEmail(email);
            users.setAge(Integer.parseInt(age));
            users.setPassword(password);
            users.setPhoneNumber(phone);
            users.setAddress(address);
            users.setRole(role);
            users.setNote(note);

            usersDAO.Add(users, khoa);

            response.sendRedirect("home.jsp");
        } catch (NullPointerException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
