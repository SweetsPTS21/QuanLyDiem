<%--
  Created by IntelliJ IDEA.
  User: boixi
  Date: 4/18/2023
  Time: 11:55 PM
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
<!------top-navbar-start----------->

<div class="top-navbar">
  <div class="xd-topbar">
    <div class="row">
      <div class="col-2 col-md-1 col-lg-1 order-2 order-md-1 align-self-center">
        <div class="xp-menubar">
          <span class="material-icons text-white">signal_cellular_alt</span>
        </div>
      </div>

      <div class="col-md-5 col-lg-3 order-3 order-md-2">
        <div class="xp-searchbar">
          <form>
            <div class="input-group">
              <input type="search" class="form-control"
                     placeholder="Search">
              <div class="input-group-append">
                <button class="btn" type="submit" id="button-addon2">Go
                </button>
              </div>
            </div>
          </form>
        </div>
      </div>


      <div class="col-10 col-md-6 col-lg-8 order-1 order-md-3">
        <div class="xp-profilebar text-right">
          <nav class="navbar p-0">
            <ul class="nav navbar-nav flex-row ml-auto">
              <li class="dropdown nav-item active">
                <a class="nav-link" href="#" data-toggle="dropdown">
                  <span class="material-icons">notifications</span>
                  <span class="notification">4</span>
                </a>
                <ul class="dropdown-menu">
                  <li><a href="#">You Have 4 New Messages</a></li>
                  <li><a href="#">You Have 4 New Messages</a></li>
                  <li><a href="#">You Have 4 New Messages</a></li>
                  <li><a href="#">You Have 4 New Messages</a></li>
                </ul>
              </li>

              <li class="nav-item">
                <a class="nav-link" href="#">
                  <span class="material-icons">question_answer</span>
                </a>
              </li>

              <li class="dropdown nav-item">
                <a class="nav-link" href="#" data-toggle="dropdown">
                  <img src="img/user.jpg" style="width:40px; border-radius:50%;"/>
                  <span class="xp-user-live"></span>
                </a>
                <ul class="dropdown-menu small-menu">
                  <li><a href="#">
                    <span class="material-icons">person_outline</span>
                    Profile
                  </a></li>
                  <li><a href="#">
                    <span class="material-icons">settings</span>
                    Settings
                  </a></li>
                  <li><a href="/logout">
                    <span class="material-icons">logout</span>
                    Logout
                  </a></li>

                </ul>
              </li>


            </ul>
          </nav>
        </div>
      </div>

    </div>

    <div class="xp-breadcrumbbar text-center">
      <h4 class="page-title">Dashboard</h4>
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="#">Vishweb</a></li>
        <li class="breadcrumb-item active" aria-curent="page">Dashboard</li>
      </ol>
    </div>


  </div>
</div>
</body>
</html>
