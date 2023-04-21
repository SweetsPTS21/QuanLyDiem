/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qld.quanlydiem.Model;

/**
 *
 * @author sondt
 */
public class Subject {
    private String id;
    private String ten;
    private int so_tc;
    private String mo_ta;

    public Subject() {
        
    }
    public Subject(String id, String ten, int so_tc, String mo_ta) {
        this.id = id;
        this.ten = ten;
        this.so_tc = so_tc;
        this.mo_ta = mo_ta;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSo_tc() {
        return so_tc;
    }

    public void setSo_tc(int so_tc) {
        this.so_tc = so_tc;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }
    
}
