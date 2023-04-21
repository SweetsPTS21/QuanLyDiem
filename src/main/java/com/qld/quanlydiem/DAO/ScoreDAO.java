/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qld.quanlydiem.DAO;

import com.qld.quanlydiem.Utilities.DBUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ThinkPad
 */
public class ScoreDAO {
    private static ScoreDAO instance;
    
    public ScoreDAO() {
    }

    public static ScoreDAO getInstance() {
        if (instance == null) {
            instance = new ScoreDAO();
        }
        return instance;
    }

    public static void setInstance(ScoreDAO instance) {
        ScoreDAO.instance = instance;
    }
    
    public ArrayList<String[]> getDiemByLHP(String name_lhp){
        ArrayList<String[]> scoresPerStu = new ArrayList<>();
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("select first_name, "
                                                                + "last_name, "
                                                                + "group_concat(diem separator ',') as ds_diem, "
                                                                + "group_concat(tile_phantram separator ',') as ds_tile, "
                                                                + "group_concat(dau_diem.ten separator ',') as ds_tenDiem from dang_ki_hoc " +
                                                            "join lop_hoc_phan on lop_hoc_phan.id = dang_ki_hoc.id_lopHocPhan " +
                                                            "join users_khoa on users_khoa.id = dang_ki_hoc.id_userKhoa " +
                                                            "join users on users.id = users_khoa.user_id " +
                                                            "join ket_qua on dang_ki_hoc.id = ket_qua.id_dangKihoc " +
                                                            "join monhoc_daudiem on monhoc_daudiem.id = ket_qua.id_monHocDauDiem " +
                                                            "join dau_diem on dau_diem.id = monhoc_daudiem.id_dauDiem " +
                                                            "where lop_hoc_phan.ten = ? " +
                                                            "group by id_userKhoa;");
            pstmt.setString(1, name_lhp);
            ResultSet rs = pstmt.executeQuery();
            int stt=1;
            
            while (rs.next()) {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String ds_diem = rs.getString("ds_diem");
                String ds_tile = rs.getString("ds_tile");
                String ds_tenDiem = rs.getString("ds_tenDiem");
                
                String[] list_tenDiem = ds_tenDiem.split(",");
                String[] list_dsDiem = ds_diem.split(",");
                String[] list_dsTile = ds_tile.split(",");
                
                scoresPerStu.add(new String[] {
                                                first_name, 
                                                last_name, 
                                                list_dsDiem[0],
                                                list_dsDiem[1], 
                                                list_dsDiem[2], 
                                                list_dsDiem[3], 
                                                list_dsDiem[4],
                                                list_dsTile[0], 
                                                list_dsTile[1], 
                                                list_dsTile[2], 
                                                list_dsTile[3], 
                                                list_dsTile[4]
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return scoresPerStu;
    }
}
