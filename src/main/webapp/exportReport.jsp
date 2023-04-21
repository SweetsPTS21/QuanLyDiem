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
    List<Users> listStudent = null;
    List<String[]> listStudentByLHP = null;
    try {
        String isAdmin = session.getAttribute("isAdmin").toString();
        KhoaDAO khoaDAO = new KhoaDAO();

        int STT = 0;
        List<Khoa> listKhoa = khoaDAO.getAllKhoa();

        if (!isAdmin.equals("admin") || session.getAttribute("isAdmin") == null) {
            response.sendRedirect("index.jsp");
        } else {
            if(request.getAttribute("listStudent") != null) {
                listStudent = (List<Users>) request.getAttribute("listStudent");
            } else if(request.getAttribute("listStudentByKhoa") != null){
                listStudent = (List<Users>) request.getAttribute("listStudentByKhoa");
            }
            else {
                listStudent = new ArrayList<>();
            }

            if(request.getAttribute("listStudentByLHP") != null) {
                listStudentByLHP = (List<String[]>) request.getAttribute("listStudentByLHP");
            } else {
                listStudentByLHP = new ArrayList<>();
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
                <%
                    if(listStudent != null && listStudent.size() > 0 || listStudentByLHP != null && listStudentByLHP.size() > 0) { %>
                <div class="notify hide">
                    <span class="msg">Thành công</span>
                </div>
                <% } else if(listStudent != null && listStudent.size() == 0 || listStudentByLHP != null && listStudentByLHP.size() == 0){ %>
                <div class="notify alert hide">
                    <span class="msg">Không tìm thấy</span>
                </div>
                <% } %>
                <div class="row">
                    <div class="col-md-4 center">
                        <form action="/findStudent" method="post">
                            <div class="form-group">
                                <label>Danh sách sinh viên thep lớp học phần</label>
                                <input type="text" class="form-control" name="findLHP" id="findLHP"
                                       placeholder="Nhập lớp học phần">
                            </div>
                            <input type="submit" value="Submit" class="btn btn-success">
                        </form>
                            <div class="form-group">
                                <label>Danh sách sinh viên theo khoa</label>
                                <select class="form-select" name="findKhoa" id="findKhoa" aria-label="Mặc định">
                                    <% for (Khoa khoa : listKhoa) {%>
                                    <option><%=khoa.getTen()%>
                                    </option>
                                    <% } %>
                                </select>
                            </div>
                            <input type="button" class="btn btn-success" id="updateUser" value="Submit" onclick="function main() {
                                        var khoa = document.getElementById('findKhoa').value;
                                window.location.href='findStudent?khoa='+khoa+'';
                                    } main()">
                        </form>
                        <form action="/pointTracking" method="get">
                            <div class="form-group">
                                <label>Thống kê điểm theo lớp học phần</label>
                                <input type="text" class="form-control" name="TKByLHP" id="TKByLHP"
                                       placeholder="Nhập lớp học phần">
                            </div>
                            <input type="submit" value="Submit" class="btn btn-success">
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
                            <h2 class="ml-lg-2">Danh sách sinh viên</h2>
                        </div>
                        <div class="col-sm-6 p-0 flex justify-content-lg-end justify-content-center">
                            <button class="btn btn-success" data-toggle="modal" onclick="ExportXLSX();">
                                <span>Xuất báo cáo</span>
                            </button>
                        </div>
                    </div>
                </div>

                <table class="table table-striped table-hover" id="tblStudent">
                    <thead>
                    <tr>
                        <th>STT</th>
                        <th>Họ và tên</th>
                        <th>Tuổi</th>
                        <th>Địa chỉ</th>
                        <th>Số điện thoại</th>
                        <th>Email</th>
                    </tr>
                    </thead>

                    <tbody>
                    <% for (Users student : listStudent) {
                        STT++;
                    %>
                    <tr>
                        <td><%=STT%></td>
                        <td><%=student.getFirstName() + " " + student.getLastName()%></td>
                        <td><%=student.getAge()%></td>
                        <td><%=student.getAddress()%></td>
                        <td><%=student.getPhoneNumber()%></td>
                        <td><%=student.getEmail()%></td>
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

            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6 p-0 flex justify-content-lg-start justify-content-center">
                            <h2 class="ml-lg-2">Chi tiết điểm</h2>
                        </div>
                        <div class="col-sm-6 p-0 flex justify-content-lg-end justify-content-center">
                            <button class="btn btn-success" data-toggle="modal" onclick="ExportXLSX2();">
                                <span>Xuất báo cáo</span>
                            </button>
                        </div>
                    </div>
                </div>

                <table class="table table-striped table-hover" id="tblPoint">
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
                        <th>% CC</th>
                        <th>% KT</th>
                        <th>% TH</th>
                        <th>% BT</th>
                        <th>% THi</th>
                    </tr>
                    </thead>

                    <tbody>
                    <% for (String[] student : listStudentByLHP) {
                        STT++; %>
                    <tr>
                        <td><%=STT%></td>
                        <% for(String point : student) { %>
                        <td><%=point%></td>

                    <% }  %>
                    </tr>
                    <% }%>

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
        <script type="text/javaScript">
            var dataStudent = 'data_student';
            var dataPoint = 'data_point';
            function ExportXLSX(){
                $('#tblStudent').tableExport({fileName: dataStudent,
                    type: 'xlsx'
                });
            }
            function ExportXLSX2(){
                $('#tblPoint').tableExport({fileName: dataPoint,
                    type: 'xlsx'
                });
            }
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
    <script type="text/javascript" src="js/js-xlsx/xlsx.core.min.js"></script>
    <script type="text/javascript" src="js/FileSaver/FileSaver.min.js"></script>
    <script type="text/javascript" src="js/html2canvas/html2canvas.min.js"></script>
    <script type="text/javascript" src="js/tableExport.js"></script>


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
