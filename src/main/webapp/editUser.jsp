<%@ page import="java.util.List" %>
<%@ page import="com.qld.quanlydiem.Model.Khoa" %>
<%@ page import="com.qld.quanlydiem.DAO.UsersDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.qld.quanlydiem.DAO.KhoaDAO" %>
<%@ page import="com.qld.quanlydiem.Model.Users" %>
<%@ page import="com.qld.quanlydiem.AES.AES" %>
<%@ page import="com.qld.quanlydiem.Utilities.Tags" %><%--
  Created by IntelliJ IDEA.
  User: boixi
  Date: 4/19/2023
  Time: 12:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <title>crud dashboard</title>
<%--    Bootstrap CSS--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!----css3---->
    <link rel="stylesheet" href="css/custom.css">


    <!--google fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">


    <!--google material icon-->
    <link href="https://fonts.googleapis.com/css2?family=Material+Icons" rel="stylesheet">
</head>
<body>
<%
  List<String> listRole = null;
  List<Khoa> listKhoa = null;
  try {
    String isAdmin = session.getAttribute("isAdmin").toString();
    Users userEdited = (Users) request.getAttribute("userEdited");
    userEdited.setPassword(AES.decrypt(userEdited.getPassword(), Tags.getKEYCHAIN()));
    session.setAttribute("UEID", userEdited.getId());
    Khoa khoa = new Khoa();
    listRole = new ArrayList<>();
    listKhoa = new ArrayList<>();

    if (!isAdmin.equals("admin") || session.getAttribute("isAdmin") == null) {
      response.sendRedirect("index.jsp");
    } else {
      listRole = (List<String>) request.getAttribute("listRole");
      khoa = (Khoa) request.getAttribute("khoa");
      listKhoa = (List) request.getAttribute("listKhoa");
    }

%>
<div class="wrapper">

    <div class="body-overlay"></div>

    <!-------sidebar--design------------>

    <%@ include file="sidebar.jsp" %>

    <!-------sidebar--design- close----------->


    <!-------page-content start----------->

    <div id="content" style="overflow: auto;">

        <!------top-navbar-start----------->
        <%@ include file="top-navbar.jsp" %>
        <!------top-navbar-end----------->


        <!------main-content-start----------->
        <%if(request.getAttribute("message") != null) {
            String error = "";
            List<String> message = (List<String>) request.getAttribute("message"); %>
        <div id="popup-message" class="hide">
            <span id="close-btn" onclick="hidePopupMessage()">&times;</span>
            <ul id="popup-messages-list">
                <%for (String i : message) {%>
                <li><%=i%></li>
                <%}%>
            </ul>
        </div>
        <% }%>
        <script>
            window.addEventListener("DOMContentLoaded", function() {
                const messages = document.getElementById("popup-messages-list").getElementsByTagName("li");
                if (messages.length > 0) {
                    const popup = document.getElementById("popup-message");
                    popup.classList.add("show");
                }
            });

            function hidePopupMessage() {
                const popup = document.getElementById("popup-message");
                popup.classList.remove("show");
            }
        </script>
        <div class="container">
            <div class="row">
                <div class="col-md-6 center">
                    <form action="/updateUser" method="post" id="addUserForm">
                        <div class="form-group">
                            <label>Họ</label>
                            <input type="text" class="form-control" id="firstName" name="firstName"
                                   value="<%=userEdited.getFirstName()%>" minlength="1" maxlength="30"
                                   required>
                        </div>
                        <div class="form-group">
                            <label>Tên</label>
                            <input type="text" class="form-control" id="lastName" name="lastName"
                                   value="<%=userEdited.getLastName()%>" minlength="1" maxlength="30"
                                   required>
                        </div>
                        <div class="form-group">
                            <label>Tài khoản</label>
                            <input type="text" class="form-control" id="username" name="username"
                                   value="<%=userEdited.getUsername()%>" minlength="6" maxlength="30"
                                   required>
                            <span id="username-error" style="color: red; font-size: 15px;"></span><br>                        </div>
                        <div class="form-group">
                            <label>Mật khẩu</label>
                            <input type="text" class="form-control" id="password" name="password"
                                   value="<%=userEdited.getPassword()%>" required>
                            <span id="password-error" style="color: red; font-size: 15px;"></span><br>
                        </div>
                        <div class="form-group">
                            <label>Xác nhận mật khẩu</label>
                            <input type="text" class="form-control" id="confirmPass" name="confirmPass" required>
                            <span id="repass-error" style="color: red; font-size: 15px;"></span><br>
                        </div>
                        <div class="form-group">
                            <label>Tuổi</label>
                            <input type="text" class="form-control" id="age" name="age" value="<%=userEdited.getAge()%>"
                                   minlength="1" maxlength="3" required>
                            <span id="age-error" style="color: red; font-size: 15px;"></span><br>
                        </div>
                        <div class="form-group">
                            <label>Số điện thoại</label>
                            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber"
                                   value="<%=userEdited.getPhoneNumber()%>" minlength="3"
                                   maxlength="11" required>
                            <span id="phone-error" style="color: red; font-size: 15px;"></span><br>
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <input type="emil" class="form-control" id="email" name="email"
                                   value="<%=userEdited.getEmail()%>" minlength="5" maxlength="30"
                                   xrequired>
                            <span id="email-error" style="color: red; font-size: 15px;"></span><br>
                        </div>
                        <div class="form-group">
                            <label>Địa chỉ</label>
                            <input type="text" class="form-control" id="address" name="address"
                                   value="<%=userEdited.getAddress()%>" minlength="1" maxlength="200"
                                   required>
                        </div>
                        <div class="form-group">
                            <label>Chức vụ</label>
                            <select class="form-select" name="selectRole" id="selectRole" aria-label="Mặc định" onchange="check()">

                                <% for (String role : listRole) {
                                    if (role.equalsIgnoreCase(userEdited.getRole())) { %>
                                <option selected><%=role%>
                                </option>
                                <% } else { %>
                                <option><%=role%>
                                </option>
                                <% }
                                } %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Ngành</label>
                            <select class="form-select" name="selectKhoa" id="selectKhoa" aria-label="Mặc định">
                                <% for (Khoa kh : listKhoa) {
                                    if (kh.getTen().equalsIgnoreCase(khoa.getTen())) { %>
                                <option selected><%=kh.getTen()%>
                                </option>
                                <% } else { %>
                                <option><%=kh.getTen()%>
                                </option>
                                <% }
                                } %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Ghi chú</label>
                            <textarea type="text" class="form-control" id="note" name="note"
                                      value="<%=userEdited.getNote()%>" required></textarea>
                        </div>
                        <input type="submit" class="btn btn-success" id="updateUser">
                        <a href="home.jsp" class="btn btn-secondary" data-dismiss="modal">Hủy</a>
                    </form>
                </div>
            </div>
        </div>
        <script>
            const role = document.querySelector("#selectRole");
            const khoa = document.querySelector("#selectKhoa");
            const form = document.querySelector("#addUserForm");

            document.addEventListener("DOMContentLoaded", function() {
                isNotStudent();
                role.addEventListener("click", isNotStudent);

            });

            function isNotStudent() {
                if(role.value !== "student") {
                    khoa.disabled = true;
                } else {
                    khoa.disabled = false;
                }
            }
        </script>
<%--        <script src="js/validation.js"></script>--%>


        <!------main-content-end----------->


        <!----footer-design------------->
        <%@include file="footer.jsp" %>

    </div>
    <% } catch (NullPointerException e) {
    e.printStackTrace();
    response.sendRedirect("index.jsp");
} %>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="js/jquery-3.3.1.slim.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-3.3.1.min.js"></script>


    <script type="text/javascript">
        $(document).ready(function(){
            $(".xp-menubar").on('click',function(){
                $("#sidebar").toggleClass('active');
                $("#content").toggleClass('active');
            });

            $('.xp-menubar,.body-overlay').on('click',function(){
                $("#sidebar,.body-overlay").toggleClass('show-nav');
            });

        });
    </script>
</body>
</html>
