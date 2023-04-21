<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />
    <title>Ecommerce Website</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>

<section id="home">
    <div class="max-width">
        <div class="home-content">
            <h3>Quản lý <br>Tài khoản</h3>
            <p>Đăng nhập để lưu những món hàng bạn yêu thích và
                địa chỉ giao hàng thường xuyên của bạn.</p>
        </div>
        <div class="home-login">
            <div class="wrapper">
                <h1>Đăng nhập</h1>
                <%if(request.getAttribute("auth") != null && (int) request.getAttribute("auth") == 1 ) {%>
                <h3 style="color: red">Email/mật khẩu không đúng</h3>
                <% request.removeAttribute("auth"); } else  {%>
                <% } %>
                <form action="/Login" method="post">
                    <input type="text" name="username" placeholder="Username" minlength="6" maxlength="30" required><br>
                    <input type="password" name="password" placeholder="Mật khẩu" minlength="6" maxlength="18" required><br>
                    <input type="submit" class="but" value="Đăng nhập" >
                </form>
            </div>
        </div>
    </div>
</section>

</body>

</html>

