const firstName = document.getElementById("firstName");
const lastName = document.getElementById("lastName");
const userName = document.getElementById("username");
const passWord = document.getElementById("password");
const confirmPass = document.getElementById("confirmPass");
const age = document.getElementById("age");
const phoneNumber = document.getElementById("phoneNumber");
const email = document.getElementById("email");
const address = document.getElementById("address");
const role = document.getElementById("selectRole");
const khoa = document.getElementById("selectKhoa");
const addBtn = document.getElementById("addUser");
const updateBtn = document.getElementById("updateUser");

function main() {


    addBtn.addEventListener("click", function() {

    });

    updateBtn.addEventListener("click", function() {

    });

}

function isNotStudent() {
    console.log(role.value);
    if(document.getElementById("selectRole").value !== "student") {
       document.getElementById("selectKhoa").disabled = false;
    } else {
        document.getElementById("selectKhoa").disabled = true;
    }
}

function deleteUser() {
    const deleteBtn = document.getElementById('delete');

    deleteBtn.addEventListener('click', function () {
        window.location.href = 'deleteUser?userId=<%=xoaId%>';
    });
}