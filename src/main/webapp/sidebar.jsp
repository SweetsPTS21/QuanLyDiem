<%--
  Created by IntelliJ IDEA.
  User: boixi
  Date: 4/18/2023
  Time: 11:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <title>Quản Lý Điểm PTIT</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
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
<div id="sidebar">
    <div class="sidebar-header">
        <h3><img src="img/logo.png" class="img-fluid"/><span>Quản Lý Điểm PTIT</span></h3>
    </div>
    <ul class="list-unstyled component m-0">
        <li class="active">
            <a href="home.jsp" class="dashboard"><i class="material-icons">dashboard</i>Quản lý người dùng</a>
        </li>

        <li class="">
            <a href="managePoint.jsp" class="dashboard"><i class="material-icons">dashboard</i>Theo dõi điểm</a>
        </li>

        <li class="">
            <a href="exportReport.jsp" class="dashboard"><i class="material-icons">dashboard</i>Xuất báo cáo</a>
        </li>

        <li class="">
            <a href="configSubject.jsp" class="dashboard"><i class="material-icons">dashboard</i>Cấu hình</a>
        </li>

    </ul>
</div>
</body>
</html>
