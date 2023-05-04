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
        ageError.textContent = 'Tuổi không hợp lệ (18-100)';
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