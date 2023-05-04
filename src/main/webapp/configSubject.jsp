<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.qld.quanlydiem.DAO.SubjectDAO" %><%--
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

    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>
<body>
<%
    try {
        String isAdmin = session.getAttribute("isAdmin").toString();
        String dauDiem[] = {"Chuyên cần", "Kiểm tra", "Bài tập", "Thực hành", "Thi"};

        if (!isAdmin.equals("admin") || session.getAttribute("isAdmin") == null) {
            response.sendRedirect("index.jsp");
        } else {

        }

%>
<div class="wrapper">

    <div class="body-overlay"></div>

    <!-------sidebar--design------------>

    <%@ include file="sidebar.jsp" %>

    <!-------sidebar--design- close----------->


    <!-------page-content start----------->

    <div id="content">

        <!------top-navbar-start----------->
        <%@ include file="top-navbar.jsp" %>
        <!------top-navbar-end----------->


        <!------main-content-start----------->

        <div class="container">

            <%String mes = "";
            if(request.getAttribute("message") != null) {
                mes = request.getAttribute("message").toString();
            } if (mes.equals("success")) { %>
                <div class="notify hide">
                    <span class="msg">Cập nhật thành công</span>
                </div>
            <% } if(mes.equals("failure")) { %>
                <div class="notify alert hide">
                    <span class="msg">Không tìm thấy môn học</span>
                </div>
            <% } %>

            <div class="row">
                <div class="col-md-6 center">
                    <form action="/configSubject" method="post" id="configForm">
                        <div class="form-group">
                            <label>ID môn học</label>
                            <input type="text" class="form-control" id="idSubject" name="idSubject" minlength="1" maxlength="30" required>
                        </div>

                        <div class="form-group">
                            <label>Chọn đầu điểm</label>
                            <select class="form-select" name="selectDTP" id="selectDTP" aria-label="Mặc định">
                                <% for (String id : dauDiem) { %>
                                <option><%=id%></option>
                                <% } %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Nhập số %</label>
                            <input type="text" class="form-control" id="subPercent" name="subPercent" minlength="1" maxlength="3"  aria-valuemax="100" required>
                            <span id="type-error" style="color: red; font-size: 15px;"></span><br>
                        </div>
                        <input type="submit" class="btn btn-success" id="updateSubject">
                    </form>
                </div>
            </div>
        </div>
        <script>
            const number = document.querySelector("#subPercent");
            const typeError = document.querySelector("#type-error");
            const form = document.querySelector("#configForm");

            form.addEventListener("submit", (e) => {
                if (number.value > 100) {
                    e.preventDefault();
                    typeError.textContent = "Số % không được lớn hơn 100";
                }
                const regex = /^[0-9]+$/;
                if(!regex.test(number.value)) {
                    e.preventDefault();
                    typeError.textContent = "Số % phải là số";
                }
            });
        </script>
        <script>
            $(document).ready(function () {
                $('.notify').removeClass('hide');
                $('.notify').addClass('show');
                $('.notify').addClass('showMessage');
                setTimeout(function () {
                    $(".notify").removeClass("show");
                    $('.notify').removeClass('showMessage');
                    $(".notify").addClass("hide");
                }, 2500);
                $(".close-btn").click(function () {
                    $(".notify").removeClass("show");
                    $('.notify').removeClass('showMessage');
                    $(".notify").addClass("hide");
                });
            });
        </script>


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
