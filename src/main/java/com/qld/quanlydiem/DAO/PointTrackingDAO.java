/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qld.quanlydiem.DAO;
import com.qld.quanlydiem.Model.PointBoardItem;
import com.qld.quanlydiem.Utilities.DBUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;


public class PointTrackingDAO {
    private static PointTrackingDAO instance;
    public PointTrackingDAO() {
    }
    
    public static PointTrackingDAO getInstance() {
        if (instance == null) {
            instance = new PointTrackingDAO();
        }
        return instance;
    }
    
    public List<String> getSubjects() {
        
        List<String> listSubject = new ArrayList<>();
        try {
            Connection con = DBUtility.openConnection();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM quanlydiem.subjects");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                listSubject.add(rs.getString("subject_name"));
            }
        }catch(SQLException e) {
            System.out.println(e);
        }
        
        return listSubject;
       
    }
    
    public List<PointBoardItem> getListPointBoard() {
        List<PointBoardItem> listPointBoard = new ArrayList<>();
        Connection con = DBUtility.openConnection();
        
        try {
            PreparedStatement pstmt = 
                    con.prepareStatement("SELECT msv, full_name, attendance_point, test_point, practice_point, exercise_point, exam_point\n" +
"FROM point_board \n" +
"	INNER JOIN students ON point_board.student_id = students.id \n" +
"	INNER JOIN subjects ON point_board.subject_id = subjects.id \n" +
"    where subjects.subject_name=? \n" +
"		and students.school_year=? \n" +
"        AND students.majors=? \n" +
"        AND students.class=?");
            pstmt.setString(1, "Kiểm thử");
            pstmt.setString(2, "D19");
            pstmt.setString(3, "CNTT");
            pstmt.setString(4, "CN6");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                
                PointBoardItem pointBoardItem = new PointBoardItem();
                pointBoardItem.setMsv(rs.getString("msv"));
                pointBoardItem.setFullName(rs.getString("full_name"));
                pointBoardItem.setAttendancePoint(rs.getDouble("attendance_point"));
                pointBoardItem.setTestPoint(rs.getDouble("test_point"));
                pointBoardItem.setPracticePoint(rs.getDouble("practice_point"));
                pointBoardItem.setExercisePoint(rs.getDouble("exercise_point"));
                pointBoardItem.setExamPoint(rs.getDouble("exam_point"));            
                
                        
                listPointBoard.add(pointBoardItem);
            }
        } catch(SQLException e) {
            System.out.println(e);
        }
        return listPointBoard;
    }
    
    public List<PointBoardItem> getListPointBoard(String schoolYear, String subject, String major, String className, String semester) {
        List<PointBoardItem> listPointBoard = new ArrayList<>();
        Connection con = DBUtility.openConnection();
        
        try {
            PreparedStatement pstmt = 
                    con.prepareStatement("SELECT msv, full_name, attendance_point, test_point, practice_point, exercise_point, exam_point\n" +
"FROM point_board \n" +
"	INNER JOIN students ON point_board.student_id = students.id \n" +
"	INNER JOIN subjects ON point_board.subject_id = subjects.id \n" +
"    where subjects.subject_name=? \n" +
"		and students.school_year=? \n" +
"        AND students.majors=? \n" +
"        AND students.class=? \n " + 
"        AND point_board.semester=? \n ");
            pstmt.setString(1, subject);
            pstmt.setString(2, schoolYear);
            pstmt.setString(3, major);
            pstmt.setString(4, className);
            pstmt.setString(5, semester);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                
                PointBoardItem pointBoardItem = new PointBoardItem();
                pointBoardItem.setMsv(rs.getString("msv"));
                pointBoardItem.setFullName(rs.getString("full_name"));
                pointBoardItem.setAttendancePoint(rs.getDouble("attendance_point"));
                pointBoardItem.setTestPoint(rs.getDouble("test_point"));
                pointBoardItem.setPracticePoint(rs.getDouble("practice_point"));
                pointBoardItem.setExercisePoint(rs.getDouble("exercise_point"));
                pointBoardItem.setExamPoint(rs.getDouble("exam_point"));            
                
                        
                listPointBoard.add(pointBoardItem);
            }
        } catch(SQLException e) {
            System.out.println(e);
        }
        return listPointBoard;
    }
    public List<PointBoardItem> getListPointBoardBYLHP(String schoolYear, String subject, String major, String className, String semester) {
        List<PointBoardItem> listPointBoard = new ArrayList<>();
        Connection con = DBUtility.openConnection();

        try {
            PreparedStatement pstmt =
                    con.prepareStatement("SELECT msv, full_name, attendance_point, test_point, practice_point, exercise_point, exam_point\n" +
                            "FROM point_board \n" +
                            "	INNER JOIN students ON point_board.student_id = students.id \n" +
                            "	INNER JOIN subjects ON point_board.subject_id = subjects.id \n" +
                            "    where subjects.subject_name=? \n" +
                            "		and students.school_year=? \n" +
                            "        AND students.majors=? \n" +
                            "        AND students.class=? \n " +
                            "        AND point_board.semester=? \n ");
            pstmt.setString(1, subject);
            pstmt.setString(2, schoolYear);
            pstmt.setString(3, major);
            pstmt.setString(4, className);
            pstmt.setString(5, semester);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                PointBoardItem pointBoardItem = new PointBoardItem();
                pointBoardItem.setMsv(rs.getString("msv"));
                pointBoardItem.setFullName(rs.getString("full_name"));
                pointBoardItem.setAttendancePoint(rs.getDouble("attendance_point"));
                pointBoardItem.setTestPoint(rs.getDouble("test_point"));
                pointBoardItem.setPracticePoint(rs.getDouble("practice_point"));
                pointBoardItem.setExercisePoint(rs.getDouble("exercise_point"));
                pointBoardItem.setExamPoint(rs.getDouble("exam_point"));


                listPointBoard.add(pointBoardItem);
            }
        } catch(SQLException e) {
            System.out.println(e);
        }
        return listPointBoard;
    }
    
}
