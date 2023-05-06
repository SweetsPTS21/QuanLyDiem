/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qld.quanlydiem.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author boixi
 */
public class DBUtility {

    public static Connection openConnection() {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/quanlydiem";
        String user = "root";
        String password = "280301";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception er) {
            er.printStackTrace();
            System.out.println("Cant connect to database");
        }
        return con;
    }

    public static void closeAll(Connection con, PreparedStatement pstmt, ResultSet rs) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
