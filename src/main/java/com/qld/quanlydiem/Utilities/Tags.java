/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qld.quanlydiem.Utilities;

/**
 *
 * @author boixi
 */
public class Tags {
    private static String KEY_CHAIN = "PTITGradeManagementTeam16@!@";
    
    public static String WELCOME_MESSAGE = "Xin chào, ";
    public static String DENY_LOGIN = "Phần mềm chỉ dành cho quản trị viên, quản lý và giáo viên sử dụng !!!";
    public static String CANNOT_ACCESS = "Bạn không đủ quyền để truy cập tính năng này";
    public static String NOT_EMPTY = "Không để trống trường này!!!";
    public static String UPDATE_SUCCESS = "Cập nhật thành công!!";
    public static String NUMBER_ONLY = "Chỉ được điền số!";
    /*Manage User*/
    public static String ADD_USER_SUCCESS = "Thêm mới thành công!!";
    public static String NONE_SELECTED = "Chưa chọn tài khoản";   
    public static String DELETE_CONFIRM = "Bạn có chắc chắn muốn hóa người dùng này ?";
    public static String DELETE_USER_SUCCESS = "Xóa tài khoản thành công!!";
    public static String DELETE_USER_FAILURE = "Xóa tài khoản không thành công!!";
    public static String USER_EXISTED = "Người dùng đã tồn tại!!!\nKiểm tra thông tin nhập vào";
    public static String UNEXPECTED_ERROR = "Lỗi!! \nChi tiết lỗi trong file log";
    public static String INVALID_AGE = "Tuổi không hợp lệ!\n Người dùng phải từ 18 tuổi trở lên";
    public static String INVALID_EMAIL = "Email không đúng định dạng!\nexample: test@email.com";
    public static String INVALID_PHONE_NUMBER = "Số điện thoại bao gồm 10 chữ số!";
    
    
    /*Login*/
    public static String WRONG_FORMAT_USERNAME_1 = "Tên đăng nhập phải có độ dài từ 6-30 ký tự";
    public static String WRONG_FORMAT_USERNAME_2 = "Tên đăng nhập không được chứa ký tự đặc biệt";
    public static String WRONG_FORMAT_PASSWORD = "Mật khẩu phải có độ dài từ 6-18 ký tự";
    public static String LOGIN_FAIL = "Tên đăng nhập hoặt mật khẩu không đúng !!!";
    
    /*Change Password*/
    public static String OLD_PASSWORD_INCORRECT = "Mật khẩu cũ chưa chính xác !!!";
    public static String CONFIRM_PASSWORD_INCORRECT = "Xác nhận mật khẩu chưa chính xác !!!";
    
    /*Login time */
    public static String LOGIN_TIME = "";
    
    public static String SUBJECT_ID_NOT_FOUND = "Không tìm thấy môn học trong hệ thống";
    public static String UPDATE_SUBJECT_PERCENT_SUCCESS = "Cập nhật đầu điểm thành công";

    public static String getLOGIN_TIME() {
        return LOGIN_TIME;
    }

    public static void setLOGIN_TIME(String LOGIN_TIME) {
        Tags.LOGIN_TIME = LOGIN_TIME;
    }
    
    public static String getKEYCHAIN() {
        return KEY_CHAIN;
    } 
   
}
