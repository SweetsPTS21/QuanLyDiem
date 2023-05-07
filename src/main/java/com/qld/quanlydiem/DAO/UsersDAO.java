/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qld.quanlydiem.DAO;
import com.qld.quanlydiem.AES.AES;
import com.qld.quanlydiem.Model.Users;
import com.qld.quanlydiem.Utilities.DBUtility;
import com.qld.quanlydiem.Utilities.Tags;

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
 * @author boixi
 */
public class UsersDAO {
    
    private static final String KEY_CHAIN = Tags.getKEYCHAIN();
    private static UsersDAO instance;
    Users account = new Users();

    public UsersDAO() {
    }

    public static UsersDAO getInstance() {
        if (instance == null) {
            instance = new UsersDAO();
        }
        return instance;
    }

    public static void setInstance(UsersDAO instance) {
        UsersDAO.instance = instance;
    }

    public int Login(String username, String password) {
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM quanlydiem.users WHERE username = ? AND password = ?");
            pstmt.setString(1, username);         
            String encryptPass = AES.encrypt(password, KEY_CHAIN);
            pstmt.setString(2, encryptPass);
            
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                account.setId(rs.getString("id"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setFirstName(rs.getNString("first_name"));
                account.setLastName(rs.getNString("last_name"));
                account.setAge(rs.getInt("age"));
                account.setAddress(rs.getNString("address"));
                account.setEmail(rs.getString("email"));
                account.setPhoneNumber(rs.getString("phone_number"));
                account.setRole(rs.getString("role"));
                System.out.println(account.getRole());
                if(!account.getRole().equalsIgnoreCase("admin") && !account.getRole().equals("manager") 
                        && !account.getRole().equals("teacher")) {
                    return -1;
                }
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public Users GetAccount() {
        return account;
    }

    public List<String> getAllRole() {
        List<String> listRole = new ArrayList<>();
        listRole.add("admin");
        listRole.add("manager");
        listRole.add("teacher");
        listRole.add("student");
        return listRole;
    }

    public List<Users> listAccount() {
        List<Users> list = new ArrayList<>();
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * from `users`");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Users accountUsers = new Users();
                accountUsers.setId(rs.getString("id"));
                accountUsers.setUsername(rs.getString("username"));
                String decryptPass = AES.decrypt(rs.getString("password"), KEY_CHAIN);
                accountUsers.setPassword(decryptPass);
                accountUsers.setFirstName(rs.getNString("first_name"));
                accountUsers.setLastName(rs.getNString("last_name"));
                accountUsers.setAge(rs.getInt("age"));
                accountUsers.setAddress(rs.getNString("address"));
                accountUsers.setPhoneNumber(rs.getString("phone_number"));
                accountUsers.setNote(rs.getNString("note"));
                accountUsers.setEmail(rs.getString("email"));
                accountUsers.setRole(rs.getNString("role"));
                
                list.add(accountUsers);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Boolean Add(Users users, String khoa) {
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO `users`(`username`, `password`, `first_name`, `last_name`, `age`, `address`, `phone_number`, `email`, `note`, `role`) VALUES (?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, users.getUsername());
            String encryptPass = AES.encrypt(users.getPassword(), KEY_CHAIN);
            pstmt.setString(2, encryptPass);
            pstmt.setNString(3, users.getFirstName());
            pstmt.setNString(4, users.getLastName());
            pstmt.setInt(5, users.getAge());
            pstmt.setNString(6, users.getAddress());
            pstmt.setString(7, users.getPhoneNumber());
            pstmt.setString(8, users.getEmail());
            pstmt.setNString(9, users.getNote());
            pstmt.setString(10, users.getRole());
            
            int ud1 = pstmt.executeUpdate();           
            
            if(!khoa.equals("") && users.getRole().equals("student")) {
                String userId = getUsersByUsername(users.getUsername()).getId();
                int khoaId = KhoaDAO.getInstance().getKhoaByName(khoa).getId();
                String sql = "INSERT INTO `users_khoa`(`user_id`, `khoa_id`) VALUES (?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(userId));
                ps.setInt(2, khoaId);
                ps.executeUpdate();
            }
                    
            if(ud1 > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Boolean Update(Users users, String khoa) {
        Connection con = DBUtility.openConnection();
        try {

            PreparedStatement pstmt = con.prepareStatement("UPDATE `users` SET `password`=?, `username` = ?, `first_name`=?, `last_name`=?, `age`=?,`address`=?, `phone_number`=?, `email`=?, `note`=?, `role`=? WHERE `id`=?");
            String encryptPass = AES.encrypt(users.getPassword(), KEY_CHAIN);
            pstmt.setString(1, encryptPass);
            pstmt.setString(2, users.getUsername());
            pstmt.setNString(3, users.getFirstName());
            pstmt.setNString(4, users.getLastName());
            pstmt.setInt(5, users.getAge());
            pstmt.setNString(6, users.getAddress());
            pstmt.setString(7, users.getPhoneNumber());
            pstmt.setString(8, users.getEmail());
            pstmt.setNString(9, users.getNote());
            pstmt.setString(10, users.getRole());
            pstmt.setString(11, users.getId());
            
            int i = pstmt.executeUpdate();
            String userId = users.getId();

            if(!khoa.equals("") && users.getRole().equals("student")) {
                int khoaId = KhoaDAO.getInstance().getKhoaByName(khoa).getId();

                if(!checkExistUserKhoa(userId)) {
                    String sql = "INSERT INTO `users_khoa`(`user_id`, `khoa_id`) VALUES (?, ?)";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, Integer.parseInt(userId));
                    ps.setInt(2, khoaId);
                    ps.executeUpdate();
                }
                else {
                    String sql = "UPDATE `users_khoa` SET `khoa_id` = ? WHERE `user_id` = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, khoaId);
                    ps.setInt(2, Integer.parseInt(userId));
                    ps.executeUpdate();
                }
            }
            if(!khoa.equals("") && !users.getRole().equals("student")) {
                if(checkExistUserKhoa(userId)) {
                    String sql = "DELETE FROM `users_khoa` WHERE `user_id` = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, Integer.parseInt(userId));
                    ps.executeUpdate();
                }
            }
            if(i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void Delete(String id) {
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt1 = con.prepareStatement("Delete from `users_khoa` where `user_id`=?");
            PreparedStatement pstmt2 = con.prepareStatement("Delete from `users` where `id`=?");
            pstmt1.setString(1, id);
            pstmt2.setString(1, id);
            pstmt1.executeUpdate();
            pstmt2.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Boolean DoiMatKhau(String id, String pass) {
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE `users` SET `password`=? WHERE `id`=?");
            String encryptPass = AES.encrypt(pass, KEY_CHAIN);
            pstmt.setString(1, encryptPass);
            pstmt.setString(2, id);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Users getUsersByUsername(String username) {
        Connection con = DBUtility.openConnection();
        String sql = "SELECT * FROM `users` WHERE `username` = ?";
        Users user = new Users();
        try {
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1, username);
           ResultSet rs = ps.executeQuery();
           
           if(rs.next()) {
               user.setId(String.valueOf(rs.getInt("id")));
               user.setUsername(rs.getString("username"));
               user.setPassword(rs.getString("password"));
               user.setFirstName(rs.getNString("first_name"));
               user.setLastName(rs.getNString("last_name"));
               user.setAge(rs.getInt("age"));
               user.setAddress(rs.getNString("address"));
               user.setPhoneNumber(rs.getString("phone_number"));
               user.setNote(rs.getNString("note"));
               user.setEmail(rs.getString("email"));
               user.setRole(rs.getNString("role"));
           }        
        } catch (SQLException e) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return user;
    }
    public Users getUsersById(String id) {
        Connection con = DBUtility.openConnection();
        String sql = "SELECT * FROM `users` WHERE `id` = ?";
        Users user = new Users();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(id));
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                user.setId(String.valueOf(rs.getInt("id")));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getNString("first_name"));
                user.setLastName(rs.getNString("last_name"));
                user.setAge(rs.getInt("age"));
                user.setAddress(rs.getNString("address"));
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setNote(rs.getNString("note"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getNString("role"));
            }
        } catch (SQLException e) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return user;
    }
    public boolean checkExistUserKhoa(String id) {
        Connection con = DBUtility.openConnection();
        String sql = "SELECT * FROM `users_khoa` WHERE `user_id` = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(id));
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    public boolean checkExistUser(String username, String phone, String email) {
        Connection con = DBUtility.openConnection();
        String sql = "SELECT * FROM `users` WHERE `username` = ? OR `phone_number` = ? OR `email` = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, phone);
            ps.setString(3, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
}
