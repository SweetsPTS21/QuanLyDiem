<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />
    <title>Ecommerce Website</title>
    <link rel="stylesheet" href="css/style.css">
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
                <% String message = "";
                    if(request.getAttribute("auth") != null && (int) request.getAttribute("auth") == 1 ) {
                    message = "Tên đăng nhập/mật khẩu không đúng";%>
                <% request.removeAttribute("auth"); }%>
                <h3 id="error-message" style="color: red"><%=message%></h3>
                <form action="/Login" method="post">
                    <input type="text" name="username" id="username" placeholder="Username" minlength="6" maxlength="30" onkeypress="return event.charCode != 32" required><br>
                    <input type="password" name="password" id="password" placeholder="Mật khẩu" minlength="6" maxlength="18" onkeypress="return event.charCode != 32" required><br>
                    <input type="submit" class="but" value="Đăng nhập" >
                </form>
            </div>
        </div>
    </div>
</section>
<script>
    const form = document.querySelector('form'); // get the login form element
    const usernameInput = document.querySelector('#username'); // get the username input element
    const passwordInput = document.querySelector('#password'); // get the password input element
    const errorMessage = document.querySelector('#error-message'); // get the error message element

    form.addEventListener('submit', (event) => {
        const username = usernameInput.value.trim();
        const password = passwordInput.value.trim();
        const regex = /^[a-zA-Z0-9_]+$/;

        if (username.length >= 6 && !regex.test(username)) {
            event.preventDefault(); // prevent the default form submission behavior
            errorMessage.textContent = 'Tên đăng nhập không được chứa ký tự đặc biệt';
            usernameInput.focus();
            return;
        }
    });
</script>
</body>

</html>

