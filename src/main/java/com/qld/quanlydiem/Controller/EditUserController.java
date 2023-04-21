package com.qld.quanlydiem.Controller;

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
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EditUserController", value = "/editUser")
public class EditUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        try {
            UsersDAO usersDAO = new UsersDAO();
            KhoaDAO khoaDAO = new KhoaDAO();
            String editId = request.getParameter("userId");
            Users users = usersDAO.getUsersById(editId);
            List<String> listRole = usersDAO.getAllRole();
            Khoa khoa = khoaDAO.getKhoaByUserId(Integer.parseInt(editId));
            List<Khoa> listKhoa = KhoaDAO.getInstance().getAllKhoa();
            request.setAttribute("userEdited", users);
            request.setAttribute("khoa", khoa);
            request.setAttribute("listKhoa", listKhoa);
            request.setAttribute("listRole", listRole);
            request.getRequestDispatcher("editUser.jsp").forward(request, response);
        } catch (NullPointerException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
