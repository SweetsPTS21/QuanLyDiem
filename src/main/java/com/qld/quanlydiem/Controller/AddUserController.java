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
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "AddNewUserController", value = "/addNewUser")
public class AddUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html; charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            List<String> message = new ArrayList<>();

            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String age = request.getParameter("age");
            String password = request.getParameter("password");
            String confirmPass = request.getParameter("confirmPass");
            String phone = request.getParameter("phoneNumber");
            String address = request.getParameter("address");
            String note = request.getParameter("note");
            String role = request.getParameter("selectRole");
            String khoa = "null";
            if(request.getParameter("khoa") != null) {
                khoa = request.getParameter("khoa");
            }

            if (username.length() < 6 || username.length() > 30) {
                message.add("Username must be between 6 and 30 characters");
            }
            if (password.length() < 6 || password.length() > 18) {
                message.add("Password must be between 6 and 18 characters");
            }
            String regex = "^[a-zA-Z0-9_]+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(username);
            if (!matcher.matches()) {
               message.add("Username must not contain special characters");
            }

            String regex2 = ".*\\s+.*";
            Pattern pattern2 = Pattern.compile(regex2);
            Matcher matcherPass = pattern2.matcher(password);
            Matcher matcherUsername = pattern2.matcher(username);
            if (matcherUsername.matches() || matcherPass.matches()) {
                message.add("Username/Password must not contain space characters");
            }
            if(!password.equals(confirmPass)) {
                message.add("Confirm password is not match");
            }
            if(Integer.parseInt(age) < 18 || Integer.parseInt(age) > 100) {
                message.add("Age must be between 18 and 100");
            }
            String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
            Pattern emailPattern = Pattern.compile(emailRegex);
            Matcher emailMatcher = emailPattern.matcher(email);
            if(!emailMatcher.matches()) {
                message.add("Email is not valid");
            }

            if(phone.length() < 10 || phone.length() > 11) {
                message.add("Phone number must be between 10 and 11 characters");
            }
            if(!role.equals("student") && !khoa.equals("null")) {
                message.add("Only student can choose khoa");
            }

            Users users = new Users();
            UsersDAO usersDAO = new UsersDAO();

            if(usersDAO.checkExistUser(username, phone, email)) {
                message.add("User with username/phone/email info is already exist");
            }
            if(message.size() > 0) {
                request.setAttribute("message", message);
                request.getRequestDispatcher("home.jsp").forward(request, response);
                return;
            }

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
