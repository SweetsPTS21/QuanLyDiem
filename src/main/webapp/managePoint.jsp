<%@ page import="java.util.List" %>
<%@ page import="com.qld.quanlydiem.Model.Khoa" %>
<%@ page import="com.qld.quanlydiem.DAO.UsersDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.qld.quanlydiem.DAO.KhoaDAO" %>
<%@ page import="com.qld.quanlydiem.Model.Users" %>
<%@ page import="com.qld.quanlydiem.AES.AES" %>
<%@ page import="com.qld.quanlydiem.Utilities.Tags" %>
<%@ page import="com.qld.quanlydiem.Model.PointBoardItem" %>
<%@ page import="com.qld.quanlydiem.Model.PointBroad" %><%--
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
    <!-- Bootstrap CSS -->

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
    List<PointBroad> listPointBoard = null;
    try {
        String isAdmin = session.getAttribute("isAdmin").toString();
        Users userEdited = (Users) request.getAttribute("userEdited");
        KhoaDAO khoaDAO = new KhoaDAO();

        int STT = 0;

        String listGrade[] = {"D19", "D20", "D21", "D22"};
        String listClass[] = {"CN5", "CN6", "CN7"};
        String listTerm[] = {"HK1", "HK2", "HK3"};
        String listSubject[] = {"Kiểm thử", "Nhúng", "Di động"};
        List<Khoa> listKhoa = khoaDAO.getAllKhoa();

        if (!isAdmin.equals("admin") || session.getAttribute("isAdmin") == null) {
            response.sendRedirect("index.jsp");
        } else {
            if(request.getAttribute("listPointBoard") != null) {
                listPointBoard = (List<PointBroad>) request.getAttribute("listPointBoard");
            } else {
                listPointBoard = new ArrayList<>();
            }
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

        <div class="main-content">
            <div class="container">
                <%List<PointBroad> list = (List<PointBroad>) request.getAttribute("listPointBoard");
                    if(list != null && list.size() > 0) { %>
                <div class="notify hide">
                    <span class="msg">Thành công</span>
                </div>
                <% } else if(list != null && list.size() == 0){ %>
                <div class="notify alert hide">
                    <span class="msg">Không tìm thấy</span>
                </div>
                <% } %>
                <div class="row">
                    <div class="col-md-4 center">
                        <form action="/pointTracking" method="post">
                            <div class="form-group">
                                <label>Khoá</label>
                                <select class="form-select" name="findGrade" id="findGrade" aria-label="Mặc định">
                                    <% for (String khoa : listGrade) {%>
                                    <option><%=khoa%>
                                    </option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Lớp</label>
                                <select class="form-select" name="findClass" id="findClass" aria-label="Mặc định">
                                    <% for (String lop : listClass) {%>
                                    <option><%=lop%>
                                    </option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Chuyên ngành</label>
                                <select class="form-select" name="findKhoa" id="findKhoa" aria-label="Mặc định">
                                    <% for (Khoa khoa : listKhoa) {%>
                                    <option><%=khoa.getTen()%>
                                    </option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Học kỳ</label>
                                <select class="form-select" name="findTerm" id="findTerm" aria-label="Mặc định">
                                    <% for (String term : listTerm) {%>
                                    <option><%=term%>
                                    </option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Môn học</label>
                                <select class="form-select" name="findSubject" id="findSubject" aria-label="Mặc định">
                                    <% for (String sub : listSubject) {%>
                                    <option><%=sub%>
                                    </option>
                                    <% } %>
                                </select>
                            </div>
                            <input type="submit" class="btn btn-success" id="updateUser">
                        </form>
                    </div>
                </div>
            </div>
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

            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6 p-0 flex justify-content-lg-start justify-content-center">
                            <h2 class="ml-lg-2">Thống Kê Điểm</h2>
                        </div>
                    </div>
                </div>

                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>STT</th>
                        <th>Họ và tên</th>
                        <th>Mã sinh viên</th>
                        <th>Điểm CC</th>
                        <th>Điểm KT</th>
                        <th>Điểm TH</th>
                        <th>Điểm BT</th>
                        <th>Điểm Thi</th>
                        <th>TK(10)</th>
                        <th>TK(CH)</th>
                        <th>Kết quả</th>
                    </tr>
                    </thead>

                    <tbody>
                    <% for (PointBroad point : listPointBoard) {
                        STT++;
                        PointBoardItem pt = point.getPointBoardItem();
                    %>
                    <tr>
                        <td><%=STT%></td>
                        <td><%=pt.getFullName()%></td>
                        <td><%=pt.getMsv()%></td>
                        <td><%=pt.getAttendancePoint()%></td>
                        <td><%=pt.getTestPoint()%></td>
                        <td><%=pt.getPracticePoint()%></td>
                        <td><%=pt.getExercisePoint()%></td>
                        <td><%=pt.getExamPoint()%></td>
                        <td><%=point.getTongKet10()%></td>
                        <td><%=point.getTongKetChu()%></td>
                        <td><%=point.getKetQua()%></td>
                    </tr>
                    <% } %>

                    </tbody>

                </table>

                <div class="clearfix">
                    <div class="hint-text">showing <b>5</b> out of <b>25</b></div>
                    <ul class="pagination">
                        <li class="page-item disabled"><a href="#">Previous</a></li>
                        <li class="page-item "><a href="#"class="page-link">1</a></li>
                        <li class="page-item "><a href="#"class="page-link">2</a></li>
                        <li class="page-item active"><a href="#"class="page-link">3</a></li>
                        <li class="page-item "><a href="#"class="page-link">4</a></li>
                        <li class="page-item "><a href="#"class="page-link">5</a></li>
                        <li class="page-item "><a href="#" class="page-link">Next</a></li>
                    </ul>
                </div>
            </div>
        </div>



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
