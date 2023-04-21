/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qld.quanlydiem.DAO;
import com.qld.quanlydiem.Model.Khoa;
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
public class KhoaDAO {
    
    private static KhoaDAO instance;
    
    public KhoaDAO() {
    }

    public static KhoaDAO getInstance() {
        if (instance == null) {
            instance = new KhoaDAO();
        }
        return instance;
    }

    public static void setInstance(KhoaDAO instance) {
        KhoaDAO.instance = instance;
    }
    
    public List<Khoa> getAllKhoa(){
        List<Khoa> list = new ArrayList<>();
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * from khoa");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Khoa kh = new Khoa();
                kh.setId(rs.getInt("id"));
                kh.setTen(rs.getString("ten"));
                
                list.add(kh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public Khoa getKhoaByUserId(int userId) {
        Connection con = DBUtility.openConnection();
        Khoa khoa = new Khoa();
        try {
            String sql = "select khoa.id, khoa.ten from khoa join users_khoa where khoa.id = users_khoa.khoa_id and users_khoa.user_id = ?;";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
                      
            while (rs.next()) {               
                khoa.setId(rs.getInt("id"));
                khoa.setTen(rs.getString("ten"));              
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return khoa;
    }
    
    public Khoa getKhoaByName(String name) {
        Connection con = DBUtility.openConnection();
        Khoa khoa = new Khoa();
        try {
            String sql = "SELECT * FROM `khoa` WHERE `ten` = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
                      
            while (rs.next()) {               
                khoa.setId(rs.getInt("id"));
                khoa.setTen(rs.getString("ten"));              
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return khoa;
    }
}
