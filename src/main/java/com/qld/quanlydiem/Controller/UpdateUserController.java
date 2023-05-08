package com.qld.quanlydiem.Controller;

import com.mysql.cj.Session;
import com.qld.quanlydiem.DAO.KhoaDAO;
import com.qld.quanlydiem.DAO.UsersDAO;
import com.qld.quanlydiem.Model.Khoa;
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
            List<String> message = new ArrayList<>();
            UsersDAO usersDAO = new UsersDAO();
            KhoaDAO khoaDAO = new KhoaDAO();

            String id = (String) session.getAttribute("UEID");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String age = request.getParameter("age");
            String password = request.getParameter("password");
            String confirmPass = request.getParameter("confirmPass");
            String phone = request.getParameter("phoneNumber");
            String address = request.getParameter("address");
            String role = request.getParameter("selectRole");
            String note = request.getParameter("note");
            String khoa;

            if(request.getParameter("selectKhoa") == null){
                khoa = "null";
            } else {
                khoa = request.getParameter("selectKhoa");
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
            if(usersDAO.checkExistUserByUsername(username, id) || usersDAO.checkExistUserByPhone(phone, id) || usersDAO.checkExistUserByEmail(email, id)) {
                message.add("User with username/phone/email info is already exist");
            }
            if(message.size() > 0) {
                Users users = usersDAO.getUsersById(id);
                List<String> listRole = usersDAO.getAllRole();
                Khoa khoaObj = khoaDAO.getKhoaByUserId(Integer.parseInt(id));
                List<Khoa> listKhoa = KhoaDAO.getInstance().getAllKhoa();
                request.setAttribute("userEdited", users);
                request.setAttribute("khoa", khoaObj);
                request.setAttribute("listKhoa", listKhoa);
                request.setAttribute("listRole", listRole);
                request.setAttribute("message", message);
                request.getRequestDispatcher("editUser.jsp").forward(request, response);
                return;
            }
            message.add("Update user successfully");
            Users users = new Users();
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
            users.setNote(note);

            usersDAO.Update(users, khoa);

            response.sendRedirect("home.jsp");
        } catch (NullPointerException | NumberFormatException e) {
            e.printStackTrace();
        }

    }
}