        <%@ page import="java.util.List" %>
<%@ page import="com.qld.quanlydiem.DAO.UsersDAO" %>
<%@ page import="com.qld.quanlydiem.Model.Users" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.qld.quanlydiem.DAO.KhoaDAO" %>
<%@ page import="com.qld.quanlydiem.Model.Khoa" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
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
<%
    List<String> listRole = null;
    List<Khoa> listKhoa = null;
    try {
        String isAdmin = session.getAttribute("isAdmin").toString();
        int userId = Integer.parseInt(session.getAttribute("userId").toString());
        int xoaId = 0;
        int userCount = 0;
        List<Users> listUsers = new ArrayList<>();
        UsersDAO usersDAO = new UsersDAO();
        KhoaDAO khoaDAO = new KhoaDAO();
        listRole = new ArrayList<>();
        listKhoa = new ArrayList<>();

        if (!isAdmin.equals("admin") || session.getAttribute("isAdmin") == null) {
            response.sendRedirect("index.jsp");
        } else {
            listUsers = usersDAO.listAccount();
            listRole = usersDAO.getAllRole();
            listKhoa = KhoaDAO.getInstance().getAllKhoa();
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
            <div class="row">
                <div class="col-md-12">
                    <div class="table-wrapper">
                        <div class="table-title">
                            <div class="row">
                                <div class="col-sm-6 p-0 flex justify-content-lg-start justify-content-center">
                                    <h2 class="ml-lg-2">Manage  User</h2>
                                </div>
                                <div class="col-sm-6 p-0 flex justify-content-lg-end justify-content-center">
                                    <a href="#addUserModal" class="btn btn-success" data-toggle="modal">
                                        <i class="material-icons">&#xE147;</i>
                                        <span>Add User</span>
                                    </a>
                                    <a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal">
                                        <i class="material-icons">&#xE15C;</i>
                                        <span>Delete</span>
                                    </a>
                                </div>
                            </div>
                        </div>

                        <table class="table table-striped table-hover">
                            <thead>
                            <tr>
                                <th><span class="custom-checkbox"/>
							 <input type="checkbox" id="selectAll">
							 <label for="selectAll"></label></th>
                                <th>ID</th>
                                <th>Họ</th>
                                <th>Tên</th>
                                <th>Tài khoản</th>
                                <th>Mật khẩu</th>
                                <th>Tuổi</th>
                                <th>Số điện thoại</th>
                                <th>Email</th>
                                <th>Địa chỉ</th>
                                <th>Chức vụ</th>
                                <th>Khoa</th>
                                <th>Ghi chú</th>
                            </tr>
                            </thead>

                            <tbody>
                            <% for (Users user : listUsers) {
                                userCount++;
                                String idBox = "checkbox" + userCount;
                                String khoa = khoaDAO.getKhoaByUserId(Integer.parseInt(user.getId())).getTen();
                            %>
                            <tr>
                                <th><span class="custom-checkbox"/>
                                    <input type="checkbox" id="<%=idBox%>" name="option[]" value="1">
                                    <label for="<%=idBox%>"></label></th>
                                <td><%=user.getId()%></td>
                                <td><%=user.getFirstName()%></td>
                                <td><%=user.getLastName()%></td>
                                <td><%=user.getUsername()%></td>
                                <td><%=user.getPassword()%></td>
                                <td><%=user.getAge()%></td>
                                <td><%=user.getPhoneNumber()%></td>
                                <td><%=user.getEmail()%></td>
                                <td><%=user.getAddress()%></td>
                                <td><%=user.getRole()%></td>
                                <td><%=khoa%></td>
                                <td><%=user.getNote()%> $</td>
                                <th>
                                    <%xoaId = Integer.parseInt(user.getId());%>
                                    <a href="editUser.jsp" class="edit" data-toggle="modal" onclick="window.location.href='editUser?userId=<%=xoaId%>';">
                                        <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i>
                                    </a>
                                    <a href="#deleteEmployeeModal" class="delete" data-toggle="modal" onclick="function main(){
                                        const deleteBtn = document.getElementById('delete');

                                        deleteBtn.addEventListener('click', function(){
                                            window.location.href='deleteUser?userId=<%=xoaId%>';
                                        });
                                    } main()">
                                        <i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i>
                                    </a>
                                </th>
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


                <!----add-modal start--------->
                <div class="modal fade" tabindex="-1" id="addUserModal" role="dialog">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Add Employees</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <form action="/addNewUser" method="post" id="addUserForm">
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label>Họ</label>
                                        <input type="text" class="form-control" id="firstName"  name="firstName" minlength="1" maxlength="30" required><br>
                                    </div>
                                    <div class="form-group">
                                        <label>Tên</label>
                                        <input type="text" class="form-control" id="lastName"  name="lastName" minlength="1" maxlength="30" required><br>
                                    </div>
                                    <div class="form-group">
                                        <label>Tài khoản</label>
                                        <input type="text" class="form-control" id="username"  name="username" minlength="6" maxlength="30" onkeypress="return event.charCode != 32" required>
                                        <span id="username-error" style="color: red; font-size: 15px;"></span><br>
                                    </div>
                                    <div class="form-group">
                                        <label>Mật khẩu</label>
                                        <input type="text" class="form-control" id="password"  name="password" minlength="6" maxlength="18" onkeypress="return event.charCode != 32"required>
                                        <span id="password-error" style="color: red; font-size: 15px;"></span><br>
                                    </div>
                                    <div class="form-group">
                                        <label>Xác nhận mật khẩu</label>
                                        <input type="text" class="form-control" id="confirmPass"  name="confirmPass" minlength="6" maxlength="18" onkeypress="return event.charCode != 32" required>
                                        <span id="repass-error" style="color: red; font-size: 15px;"></span><br>
                                    </div>
                                    <div class="form-group">
                                        <label>Tuổi</label>
                                        <input type="text" class="form-control" id="age" name="age"  minlength="1" maxlength="3" min="18" max="100" required>
                                        <span id="age-error" style="color: red; font-size: 15px;"></span><br>
                                    </div>
                                    <div class="form-group">
                                        <label>Số điện thoại</label>
                                        <input type="text" class="form-control" id="phoneNumber"  name="phoneNumber" minlength="10" maxlength="11" required>
                                        <span id="phone-error" style="color: red; font-size: 15px;"></span><br>
                                    </div>
                                    <div class="form-group">
                                        <label>Email</label>
                                        <input type="emil" class="form-control" id="email"  name="email" minlength="5" maxlength="30" xrequired>
                                        <span id="email-error" style="color: red; font-size: 15px;"></span><br>
                                    </div>
                                    <div class="form-group">
                                        <label>Địa chỉ</label>
                                        <input type="text" class="form-control" id="address"  name="address" minlength="1" maxlength="200" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Chức vụ</label>
                                        <select name="selectRole" id="selectRole" aria-label="Mặc định">
                                            <% for (String role : listRole) {%>
                                            <option><%=role%></option>
                                            <% } %>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Ngành</label>
                                        <select name="selectKhoa" id="selectKhoa" aria-label="Mặc định">
                                            <% for (Khoa kh : listKhoa) {%>
                                            <option><%=kh.getTen()%></option>
                                            <% } %>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Ghi chú</label>
                                        <textarea type="text" class="form-control" id="note" name="note" required></textarea>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                    <input type="submit" class="btn btn-success" id="addUser">

                                </div>
                            </form>
                        </div>

                    </div>
                </div>
                <script>
                    const role = document.querySelector("#selectRole");
                    const khoa = document.querySelector("#selectKhoa");
                    const form = document.querySelector("#addUserForm");

                    const username = document.querySelector("#username");
                    const password = document.querySelector("#password");
                    const confirmPass = document.querySelector("#confirmPass");
                    const age = document.querySelector("#age");
                    const phoneNumber = document.querySelector("#phoneNumber");
                    const email = document.querySelector("#email");
                    const usernameError = document.querySelector("#username-error");
                    const passwordError = document.querySelector("#password-error");
                    const repassError = document.querySelector("#repass-error");
                    const ageError = document.querySelector("#age-error");
                    const phoneError = document.querySelector("#phone-error");
                    const emailError = document.querySelector("#email-error");
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
                    form.addEventListener("submit", function(event) {
                        const usernameRegex = /\W/;
                        let formValid = 1;
                        //Username validation
                        if (usernameRegex.test(username.value)) {
                            username.style.border = "1px solid red";
                            usernameError.textContent = 'Tên đăng nhập không chứa ký tự đặc biệt';
                            formValid = 0

                        } else {
                            username.style.border = "1px solid green";
                            usernameError.textContent = ''; // clear error message
                        }
                        //Password validation
                        if (confirmPass.value !== password.value) {
                            confirmPass.style.border = "1px solid red";
                            repassError.textContent = 'Mật khẩu không khớp';
                            formValid = 0

                        } else {
                            confirmPass.style.border = "1px solid green";
                            repassError.textContent = ''; // clear error message
                        }
                        //Age validation
                        if(age.value < 18 || age.value > 100) {
                            age.style.border = "1px solid red";
                            ageError.textContent = 'Tuổi không hợp lệ';
                            formValid = 0

                        } else {
                            age.style.border = "1px solid green";
                            ageError.textContent = ''; // clear error message
                        }
                        //Email validation
                        const emailRegex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
                        if (!emailRegex.test(email.value)) {
                            email.style.border = "1px solid red";
                            emailError.textContent = 'Email không hợp lệ';
                            formValid = 0

                        } else {
                            email.style.border = "1px solid green";
                            emailError.textContent = ''; // clear error message
                        }
                        if(formValid === 0) {
                            event.preventDefault();
                        }

                    });
                </script>
                <!----add-modal end--------->


                <!----delete-modal start--------->
                <div class="modal fade" tabindex="-1" id="deleteEmployeeModal" role="dialog">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Delete Employees</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <p>Are you sure you want to delete this Records</p>
                                <p class="text-warning"><small>this action Cannot be Undone,</small></p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                <a href="#" class="btn btn-warning" id="delete" data-toggle="modal">
                                    <i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i>
                                </a>

                            </div>
                        </div>
                    </div>
                </div>

                <!----edit-modal end--------->




            </div>
        </div>

        <!------main-content-end----------->



        <!----footer-design------------->
        <%@include file="footer.jsp"%>

    </div>

</div>
<!-------complete html----------->
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


