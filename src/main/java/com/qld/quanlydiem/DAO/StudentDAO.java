/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qld.quanlydiem.DAO;

import com.qld.quanlydiem.Model.Users;
import com.qld.quanlydiem.Utilities.DBUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ThinkPad
 */
public class StudentDAO {
    
    private static StudentDAO instance;
    
    public StudentDAO() {
    }

    public static StudentDAO getInstance() {
        if (instance == null) {
            instance = new StudentDAO();
        }
        return instance;
    }

    public static void setInstance(StudentDAO instance) {
        StudentDAO.instance = instance;
    }
    
    
    public ArrayList<Users> getStudentsByKhoaID(int khoaID) {
        ArrayList<Users> list = new ArrayList<>();
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("select users.first_name, "
                                                                + "users.last_name, "
                                                                + "users.age, "
                                                                + "users.address, "
                                                                + "users.phone_number, "
                                                                + "users.email from users "
                                                            +"join users_khoa on users_khoa.user_id = users.id "
                                                            +"where users_khoa.khoa_id = ?");
            pstmt.setInt(1, khoaID);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                String phone_number = rs.getString("phone_number");
                String email = rs.getString("email");
                
                Users accountUsers = new Users(first_name, last_name, age, address, phone_number, email);             
                list.add(accountUsers);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<Users> getStudentsByTenLopHP(String name_lhp) {
        ArrayList<Users> list = new ArrayList<>();
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("select first_name, last_name, age, address, phone_number, email from users "
                                                            +"where id in "
                                                                +"(select users_khoa.user_id from dang_ki_hoc " 
                                                                +"left join lop_hoc_phan on lop_hoc_phan.id = dang_ki_hoc.id_lopHocPhan " 
                                                                +"right join users_khoa on users_khoa.id = dang_ki_hoc.id_userKhoa " 
                                                                +"where lop_hoc_phan.ten = ?)");
            pstmt.setString(1, name_lhp);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                String phone_number = rs.getString("phone_number");
                String email = rs.getString("email");
                
                Users accountUsers = new Users(first_name, last_name, age, address, phone_number, email);             
                list.add(accountUsers);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
