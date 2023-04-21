/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qld.quanlydiem.Model;


public class PointBoardItem {
    private String msv, fullName;
    private double  attendancePoint, testPoint, practicePoint, exercisePoint, examPoint;

    public PointBoardItem() {
    }

    public PointBoardItem(String msv, String fullName, double attendancePoint, double testPoint, double practicePoint, double exercisePoint, double examPoint) {
        this.msv = msv;
        this.fullName = fullName;
        this.attendancePoint = attendancePoint;
        this.testPoint = testPoint;
        this.practicePoint = practicePoint;
        this.exercisePoint = exercisePoint;
        this.examPoint = examPoint;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getAttendancePoint() {
        return attendancePoint;
    }

    public void setAttendancePoint(double attendancePoint) {
        this.attendancePoint = attendancePoint;
    }

    public double getTestPoint() {
        return testPoint;
    }

    public void setTestPoint(double testPoint) {
        this.testPoint = testPoint;
    }

    public double getPracticePoint() {
        return practicePoint;
    }

    public void setPracticePoint(double practicePoint) {
        this.practicePoint = practicePoint;
    }

    public double getExercisePoint() {
        return exercisePoint;
    }

    public void setExercisePoint(double exercisePoint) {
        this.exercisePoint = exercisePoint;
    }

    public double getExamPoint() {
        return examPoint;
    }

    public void setExamPoint(double examPoint) {
        this.examPoint = examPoint;
    }

    @Override
    public String toString() {
        return "PointBoardItem{" + "msv=" + msv + ", fullName=" + fullName + ", attendancePoint=" + attendancePoint + ", testPoint=" + testPoint + ", practicePoint=" + practicePoint + ", exercisePoint=" + exercisePoint + ", examPoint=" + examPoint + '}';
    }
    
    
    
}
