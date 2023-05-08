import com.qld.quanlydiem.Controller.AddUserController;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddUserControllerTest {
    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    HttpSession session;

    @Mock
    AddUserController addUserController;

    @BeforeEach
    public void init(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        addUserController = new AddUserController();
    }

    /*Test username
    * Total testcase: 3
    * Pass: 3
    * Fail: 0
    * */
    @Test
    @DisplayName("Should return message Username must be between 6 and 30 characters when username is less than 6 characters")
    public void returnMessageWhenUsernameLessThanSixCharacter() throws ServletException, IOException {
        String firstName = "Nguyen";
        String lastName = "Van Nam";
        String username = "mana1";
        String email = "manager01@gmail.com";
        String age = "20";
        String password = "manager01";
        String confirmPass = "manager01";
        String phone = "0123456789";
        String address = "Ha Noi";
        String note = "Nothing";
        String role = "manager";
        String khoa = "null";
        List<String> message = new ArrayList<>();
        Mockito.when(request.getParameter("firstName")).thenReturn(firstName);
        Mockito.when(request.getParameter("lastName")).thenReturn(lastName);
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getParameter("confirmPass")).thenReturn(confirmPass);
        Mockito.when(request.getParameter("email")).thenReturn(email);
        Mockito.when(request.getParameter("age")).thenReturn(age);
        Mockito.when(request.getParameter("phoneNumber")).thenReturn(phone);
        Mockito.when(request.getParameter("address")).thenReturn(address);
        Mockito.when(request.getParameter("note")).thenReturn(note);
        Mockito.when(request.getParameter("selectRole")).thenReturn(role);
        Mockito.when(request.getParameter("khoa")).thenReturn(khoa);
        Mockito.when(request.getSession()).thenReturn(session);
        addUserController.doPost(request, response);

        message.add("Username must be between 6 and 30 characters");
        Mockito.verify(request).setAttribute("message", message);
        //Mockito.verify(request).getRequestDispatcher("home.jsp").forward(request, response);

    }

    @Test
    @DisplayName("Should return message Username must be between 6 and 30 characters when username is more than 30 characters")
    public void returnMessageWhenUsernameMoreThanThirtyCharacter() throws ServletException, IOException {
        String firstName = "Nguyen";
        String lastName = "Van Nam";
        String username = "mana123456789012345678901234567890";
        String email = "manager01@gmail.com";
        String age = "20";
        String password = "manager01";
        String confirmPass = "manager01";
        String phone = "0123456789";
        String address = "Ha Noi";
        String note = "Nothing";
        String role = "manager";
        String khoa = "null";
        List<String> message = new ArrayList<>();
        Mockito.when(request.getParameter("firstName")).thenReturn(firstName);
        Mockito.when(request.getParameter("lastName")).thenReturn(lastName);
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getParameter("confirmPass")).thenReturn(confirmPass);
        Mockito.when(request.getParameter("email")).thenReturn(email);
        Mockito.when(request.getParameter("age")).thenReturn(age);
        Mockito.when(request.getParameter("phoneNumber")).thenReturn(phone);
        Mockito.when(request.getParameter("address")).thenReturn(address);
        Mockito.when(request.getParameter("note")).thenReturn(note);
        Mockito.when(request.getParameter("selectRole")).thenReturn(role);
        Mockito.when(request.getParameter("khoa")).thenReturn(khoa);
        Mockito.when(request.getSession()).thenReturn(session);
        addUserController.doPost(request, response);

        message.add("Username must be between 6 and 30 characters");
        Mockito.verify(request).setAttribute("message", message);
        //Mockito.verify(request).getRequestDispatcher("home.jsp").forward(request, response);

    }

    @Test
    @DisplayName("Should return message Username must not contain special characters when username have special characters")
    public void returnMessageWhenUsernameContainSpecialCharacter() throws ServletException, IOException {
        String firstName = "Nguyen";
        String lastName = "Van Nam";
        String username = "manager@1";
        String email = "manager01@gmail.com";
        String age = "20";
        String password = "manager01";
        String confirmPass = "manager01";
        String phone = "0123456789";
        String address = "Ha Noi";
        String note = "Nothing";
        String role = "manager";
        String khoa = "null";
        List<String> message = new ArrayList<>();
        Mockito.when(request.getParameter("firstName")).thenReturn(firstName);
        Mockito.when(request.getParameter("lastName")).thenReturn(lastName);
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getParameter("confirmPass")).thenReturn(confirmPass);
        Mockito.when(request.getParameter("email")).thenReturn(email);
        Mockito.when(request.getParameter("age")).thenReturn(age);
        Mockito.when(request.getParameter("phoneNumber")).thenReturn(phone);
        Mockito.when(request.getParameter("address")).thenReturn(address);
        Mockito.when(request.getParameter("note")).thenReturn(note);
        Mockito.when(request.getParameter("selectRole")).thenReturn(role);
        Mockito.when(request.getParameter("khoa")).thenReturn(khoa);
        Mockito.when(request.getSession()).thenReturn(session);
        addUserController.doPost(request, response);

        message.add("Username must not contain special characters");
        Mockito.verify(request).setAttribute("message", message);
        //Mockito.verify(request).getRequestDispatcher("home.jsp").forward(request, response);

    }

    /*Test password
    * Total testcase: 3
    * Pass: 3
    * Fail: 0
    * */

    @Test
    @DisplayName("Should return message Password must be between 6 and 18 characters when password is less than 6 characters")
    public void returnMessageWhenPasswordLessThanSixCharacter() throws ServletException, IOException {
        String firstName = "Nguyen";
        String lastName = "Van Nam";
        String username = "manager22";
        String email = "manager22@gmail.com";
        String age = "20";
        String password = "mana";
        String confirmPass = "mana";
        String phone = "0123456789";
        String address = "Ha Noi";
        String note = "Nothing";
        String role = "manager";
        String khoa = "null";
        List<String> message = new ArrayList<>();
        Mockito.when(request.getParameter("firstName")).thenReturn(firstName);
        Mockito.when(request.getParameter("lastName")).thenReturn(lastName);
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getParameter("confirmPass")).thenReturn(confirmPass);
        Mockito.when(request.getParameter("email")).thenReturn(email);
        Mockito.when(request.getParameter("age")).thenReturn(age);
        Mockito.when(request.getParameter("phoneNumber")).thenReturn(phone);
        Mockito.when(request.getParameter("address")).thenReturn(address);
        Mockito.when(request.getParameter("note")).thenReturn(note);
        Mockito.when(request.getParameter("selectRole")).thenReturn(role);
        Mockito.when(request.getParameter("khoa")).thenReturn(khoa);
        Mockito.when(request.getSession()).thenReturn(session);
        addUserController.doPost(request, response);

        message.add("Password must be between 6 and 18 characters");
        Mockito.verify(request).setAttribute("message", message);
        //Mockito.verify(request).getRequestDispatcher("home.jsp").forward(request, response);

    }

    @Test
    @DisplayName("Should return message Password must not contain space characters when when password contain space character")
    public void returnMessageWhenPasswordContainSpaceCharacter() throws ServletException, IOException {
        String firstName = "Nguyen";
        String lastName = "Van Nam";
        String username = "manager22";
        String email = "manager22@gmail.com";
        String age = "20";
        String password = "mana ger01";
        String confirmPass = "mana ger01";
        String phone = "0123456789";
        String address = "Ha Noi";
        String note = "Nothing";
        String role = "manager";
        String khoa = "null";
        List<String> message = new ArrayList<>();
        Mockito.when(request.getParameter("firstName")).thenReturn(firstName);
        Mockito.when(request.getParameter("lastName")).thenReturn(lastName);
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getParameter("confirmPass")).thenReturn(confirmPass);
        Mockito.when(request.getParameter("email")).thenReturn(email);
        Mockito.when(request.getParameter("age")).thenReturn(age);
        Mockito.when(request.getParameter("phoneNumber")).thenReturn(phone);
        Mockito.when(request.getParameter("address")).thenReturn(address);
        Mockito.when(request.getParameter("note")).thenReturn(note);
        Mockito.when(request.getParameter("selectRole")).thenReturn(role);
        Mockito.when(request.getParameter("khoa")).thenReturn(khoa);
        Mockito.when(request.getSession()).thenReturn(session);
        addUserController.doPost(request, response);

        message.add("Password must not contain space characters");
        Mockito.verify(request).setAttribute("message", message);
        //Mockito.verify(request).getRequestDispatcher("home.jsp").forward(request, response);
    }

    @Test
    @DisplayName("Should return message Confirm password does not match when confirm password does not match")
    public void returnMessageWhenConfirmPassDoesNotMatch() throws ServletException, IOException {
        String firstName = "Nguyen";
        String lastName = "Van Nam";
        String username = "manager22";
        String email = "manager22@gmail.com";
        String age = "20";
        String password = "manager01";
        String confirmPass = "manager00";
        String phone = "0123456789";
        String address = "Ha Noi";
        String note = "Nothing";
        String role = "manager";
        String khoa = "null";
        List<String> message = new ArrayList<>();
        Mockito.when(request.getParameter("firstName")).thenReturn(firstName);
        Mockito.when(request.getParameter("lastName")).thenReturn(lastName);
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getParameter("confirmPass")).thenReturn(confirmPass);
        Mockito.when(request.getParameter("email")).thenReturn(email);
        Mockito.when(request.getParameter("age")).thenReturn(age);
        Mockito.when(request.getParameter("phoneNumber")).thenReturn(phone);
        Mockito.when(request.getParameter("address")).thenReturn(address);
        Mockito.when(request.getParameter("note")).thenReturn(note);
        Mockito.when(request.getParameter("selectRole")).thenReturn(role);
        Mockito.when(request.getParameter("khoa")).thenReturn(khoa);
        Mockito.when(request.getSession()).thenReturn(session);
        addUserController.doPost(request, response);

        message.add("Confirm password does not match");
        Mockito.verify(request).setAttribute("message", message);
        //Mockito.verify(request).getRequestDispatcher("home.jsp").forward(request, response);

    }

    /*Test age
    * Total testcase: 3
    * Pass: 3
    * Fail: 0
     */
    @Test
    @DisplayName("Should return message Age must be between 18 and 100 when age is less than 18")
    public void returnMessageWhenAgeIsLessThanEighteen() throws ServletException, IOException {
        String firstName = "Nguyen";
        String lastName = "Van Nam";
        String username = "manager22";
        String email = "manager22@gmail.com";
        String age = "13";
        String password = "manager22";
        String confirmPass = "manager22";
        String phone = "0123456789";
        String address = "Ha Noi";
        String note = "Nothing";
        String role = "manager";
        String khoa = "null";
        List<String> message = new ArrayList<>();
        Mockito.when(request.getParameter("firstName")).thenReturn(firstName);
        Mockito.when(request.getParameter("lastName")).thenReturn(lastName);
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getParameter("confirmPass")).thenReturn(confirmPass);
        Mockito.when(request.getParameter("email")).thenReturn(email);
        Mockito.when(request.getParameter("age")).thenReturn(age);
        Mockito.when(request.getParameter("phoneNumber")).thenReturn(phone);
        Mockito.when(request.getParameter("address")).thenReturn(address);
        Mockito.when(request.getParameter("note")).thenReturn(note);
        Mockito.when(request.getParameter("selectRole")).thenReturn(role);
        Mockito.when(request.getParameter("khoa")).thenReturn(khoa);
        Mockito.when(request.getSession()).thenReturn(session);
        addUserController.doPost(request, response);

        message.add("Age must be between 18 and 100");
        Mockito.verify(request).setAttribute("message", message);
        //Mockito.verify(request).getRequestDispatcher("home.jsp").forward(request, response);
    }

    @Test
    @DisplayName("Should return message Age must be between 18 and 100 when age is more than 100")
    public void returnMessageWhenAgeIsMoreThan100() throws ServletException, IOException {
        String firstName = "Nguyen";
        String lastName = "Van Nam";
        String username = "manager22";
        String email = "manager22@gmail.com";
        String age = "111";
        String password = "manager22";
        String confirmPass = "manager22";
        String phone = "0123456789";
        String address = "Ha Noi";
        String note = "Nothing";
        String role = "manager";
        String khoa = "null";
        List<String> message = new ArrayList<>();
        Mockito.when(request.getParameter("firstName")).thenReturn(firstName);
        Mockito.when(request.getParameter("lastName")).thenReturn(lastName);
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getParameter("confirmPass")).thenReturn(confirmPass);
        Mockito.when(request.getParameter("email")).thenReturn(email);
        Mockito.when(request.getParameter("age")).thenReturn(age);
        Mockito.when(request.getParameter("phoneNumber")).thenReturn(phone);
        Mockito.when(request.getParameter("address")).thenReturn(address);
        Mockito.when(request.getParameter("note")).thenReturn(note);
        Mockito.when(request.getParameter("selectRole")).thenReturn(role);
        Mockito.when(request.getParameter("khoa")).thenReturn(khoa);
        Mockito.when(request.getSession()).thenReturn(session);
        addUserController.doPost(request, response);

        message.add("Age must be between 18 and 100");
        Mockito.verify(request).setAttribute("message", message);
        //Mockito.verify(request).getRequestDispatcher("home.jsp").forward(request, response);

    }

    @Test
    @DisplayName("Should return message Age must be a number when age is not a number")
    public void returnMessageWhenAgeIsNotANumber() throws ServletException, IOException {
        String firstName = "Nguyen";
        String lastName = "Van Nam";
        String username = "manager22";
        String email = "manager22@gmail.com";
        String age = "abc";
        String password = "manager22";
        String confirmPass = "manager22";
        String phone = "0123456789";
        String address = "Ha Noi";
        String note = "Nothing";
        String role = "manager";
        String khoa = "null";
        List<String> message = new ArrayList<>();
        Mockito.when(request.getParameter("firstName")).thenReturn(firstName);
        Mockito.when(request.getParameter("lastName")).thenReturn(lastName);
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getParameter("confirmPass")).thenReturn(confirmPass);
        Mockito.when(request.getParameter("email")).thenReturn(email);
        Mockito.when(request.getParameter("age")).thenReturn(age);
        Mockito.when(request.getParameter("phoneNumber")).thenReturn(phone);
        Mockito.when(request.getParameter("address")).thenReturn(address);
        Mockito.when(request.getParameter("note")).thenReturn(note);
        Mockito.when(request.getParameter("selectRole")).thenReturn(role);
        Mockito.when(request.getParameter("khoa")).thenReturn(khoa);
        Mockito.when(request.getSession()).thenReturn(session);
        addUserController.doPost(request, response);

        message.add("Age must be a number");
        Mockito.verify(request).setAttribute("message", message);
        //Mockito.verify(request).getRequestDispatcher("home.jsp").forward(request, response);

    }



    /*Test phone
    * Total testcase: 2
    * Pass: 2
    * Fail: 0
     */
    @Test
    @DisplayName("Should return message Phone number must be between 10 and 11 characters when phone is less than 10 characters")
    public void returnMessageWhenPhoneIsLessThanTenCharacters() throws ServletException, IOException {
        String firstName = "Nguyen";
        String lastName = "Van Nam";
        String username = "manager22";
        String email = "manager22@gmail.com";
        String age = "20";
        String password = "manager22";
        String confirmPass = "manager22";
        String phone = "012345678";
        String address = "Ha Noi";
        String note = "Nothing";
        String role = "manager";
        String khoa = "null";
        List<String> message = new ArrayList<>();
        Mockito.when(request.getParameter("firstName")).thenReturn(firstName);
        Mockito.when(request.getParameter("lastName")).thenReturn(lastName);
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getParameter("confirmPass")).thenReturn(confirmPass);
        Mockito.when(request.getParameter("email")).thenReturn(email);
        Mockito.when(request.getParameter("age")).thenReturn(age);
        Mockito.when(request.getParameter("phoneNumber")).thenReturn(phone);
        Mockito.when(request.getParameter("address")).thenReturn(address);
        Mockito.when(request.getParameter("note")).thenReturn(note);
        Mockito.when(request.getParameter("selectRole")).thenReturn(role);
        Mockito.when(request.getParameter("khoa")).thenReturn(khoa);
        Mockito.when(request.getSession()).thenReturn(session);
        addUserController.doPost(request, response);

        message.add("Phone number must be between 10 and 11 characters");
        Mockito.verify(request).setAttribute("message", message);
        //Mockito.verify(request).getRequestDispatcher("home.jsp").forward(request, response);

    }

    @Test
    @DisplayName("Should return message Phone number must be between 10 and 11 characters when phone is more than 11 characters")
    public void returnMessageWhenPhoneIsMoreThanElevenCharacters() throws ServletException, IOException {
        String firstName = "Nguyen";
        String lastName = "Van Nam";
        String username = "manager22";
        String email = "manager22@gmail.com";
        String age = "20";
        String password = "manager22";
        String confirmPass = "manager22";
        String phone = "0123456789000";
        String address = "Ha Noi";
        String note = "Nothing";
        String role = "manager";
        String khoa = "null";
        List<String> message = new ArrayList<>();
        Mockito.when(request.getParameter("firstName")).thenReturn(firstName);
        Mockito.when(request.getParameter("lastName")).thenReturn(lastName);
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getParameter("confirmPass")).thenReturn(confirmPass);
        Mockito.when(request.getParameter("email")).thenReturn(email);
        Mockito.when(request.getParameter("age")).thenReturn(age);
        Mockito.when(request.getParameter("phoneNumber")).thenReturn(phone);
        Mockito.when(request.getParameter("address")).thenReturn(address);
        Mockito.when(request.getParameter("note")).thenReturn(note);
        Mockito.when(request.getParameter("selectRole")).thenReturn(role);
        Mockito.when(request.getParameter("khoa")).thenReturn(khoa);
        Mockito.when(request.getSession()).thenReturn(session);
        addUserController.doPost(request, response);

        message.add("Phone number must be between 10 and 11 characters");
        Mockito.verify(request).setAttribute("message", message);
        //Mockito.verify(request).getRequestDispatcher("home.jsp").forward(request, response);

    }

    /*Test email
    * Total testcase: 1
    * Pass: 1
    * Fail: 0
    */

    @Test
    @DisplayName("Should return messageEmail is not valid when email is not valid")
    public void returnMessageWhenEmailIsNotValid() throws ServletException, IOException {
        String firstName = "Nguyen";
        String lastName = "Van Nam";
        String username = "manager22";
        String email = "manager22@gmail";
        String age = "20";
        String password = "manager22";
        String confirmPass = "manager22";
        String phone = "0123456789";
        String address = "Ha Noi";
        String note = "Nothing";
        String role = "manager";
        String khoa = "null";
        List<String> message = new ArrayList<>();
        Mockito.when(request.getParameter("firstName")).thenReturn(firstName);
        Mockito.when(request.getParameter("lastName")).thenReturn(lastName);
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getParameter("confirmPass")).thenReturn(confirmPass);
        Mockito.when(request.getParameter("email")).thenReturn(email);
        Mockito.when(request.getParameter("age")).thenReturn(age);
        Mockito.when(request.getParameter("phoneNumber")).thenReturn(phone);
        Mockito.when(request.getParameter("address")).thenReturn(address);
        Mockito.when(request.getParameter("note")).thenReturn(note);
        Mockito.when(request.getParameter("selectRole")).thenReturn(role);
        Mockito.when(request.getParameter("khoa")).thenReturn(khoa);
        Mockito.when(request.getSession()).thenReturn(session);
        addUserController.doPost(request, response);

        message.add("Email is not valid");
        Mockito.verify(request).setAttribute("message", message);
        //Mockito.verify(request).getRequestDispatcher("home.jsp").forward(request, response);

    }

    /*Test user exist
    * Total testcase: 3
    * Pass: 3
    * Fail: 0
     */

    @Test
    @DisplayName("Should return message User with username/phone/email info is already exist when username exist")
    public void returnMessageWhenUserWithUsernameExist() throws ServletException, IOException {
        String firstName = "Nguyen";
        String lastName = "Van Nam";
        String username = "manager01";
        String email = "manager22@gmail.com";
        String age = "20";
        String password = "manager22";
        String confirmPass = "manager22";
        String phone = "0123456789";
        String address = "Ha Noi";
        String note = "Nothing";
        String role = "manager";
        String khoa = "null";
        List<String> message = new ArrayList<>();
        Mockito.when(request.getParameter("firstName")).thenReturn(firstName);
        Mockito.when(request.getParameter("lastName")).thenReturn(lastName);
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getParameter("confirmPass")).thenReturn(confirmPass);
        Mockito.when(request.getParameter("email")).thenReturn(email);
        Mockito.when(request.getParameter("age")).thenReturn(age);
        Mockito.when(request.getParameter("phoneNumber")).thenReturn(phone);
        Mockito.when(request.getParameter("address")).thenReturn(address);
        Mockito.when(request.getParameter("note")).thenReturn(note);
        Mockito.when(request.getParameter("selectRole")).thenReturn(role);
        Mockito.when(request.getParameter("khoa")).thenReturn(khoa);
        Mockito.when(request.getSession()).thenReturn(session);
        addUserController.doPost(request, response);

        message.add("User with username/phone/email info is already exist");
        Mockito.verify(request).setAttribute("message", message);
        //Mockito.verify(request).getRequestDispatcher("home.jsp").forward(request, response);

    }

    @Test
    @DisplayName("Should return message User with username/phone/email info is already exist when phone exist")
    public void returnMessageWhenUserWithPhoneExist() throws ServletException, IOException {
        String firstName = "Nguyen";
        String lastName = "Van Nam";
        String username = "manager22";
        String email = "manager22@gmail.com";
        String age = "20";
        String password = "manager22";
        String confirmPass = "manager22";
        String phone = "0862045324";
        String address = "Ha Noi";
        String note = "Nothing";
        String role = "manager";
        String khoa = "null";
        List<String> message = new ArrayList<>();
        Mockito.when(request.getParameter("firstName")).thenReturn(firstName);
        Mockito.when(request.getParameter("lastName")).thenReturn(lastName);
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getParameter("confirmPass")).thenReturn(confirmPass);
        Mockito.when(request.getParameter("email")).thenReturn(email);
        Mockito.when(request.getParameter("age")).thenReturn(age);
        Mockito.when(request.getParameter("phoneNumber")).thenReturn(phone);
        Mockito.when(request.getParameter("address")).thenReturn(address);
        Mockito.when(request.getParameter("note")).thenReturn(note);
        Mockito.when(request.getParameter("selectRole")).thenReturn(role);
        Mockito.when(request.getParameter("khoa")).thenReturn(khoa);
        Mockito.when(request.getSession()).thenReturn(session);
        addUserController.doPost(request, response);

        message.add("User with username/phone/email info is already exist");
        Mockito.verify(request).setAttribute("message", message);
        //Mockito.verify(request).getRequestDispatcher("home.jsp").forward(request, response);

    }
    @Test
    @DisplayName("Should return message User with username/phone/email info is already exist when email exist")
    public void returnMessageWhenUserWithEmailExist() throws ServletException, IOException {
        String firstName = "Nguyen";
        String lastName = "Van Nam";
        String username = "manager01";
        String email = "swptsnotexist@duck.com";
        String age = "20";
        String password = "manager22";
        String confirmPass = "manager22";
        String phone = "0123456789";
        String address = "Ha Noi";
        String note = "Nothing";
        String role = "manager";
        String khoa = "null";
        List<String> message = new ArrayList<>();
        Mockito.when(request.getParameter("firstName")).thenReturn(firstName);
        Mockito.when(request.getParameter("lastName")).thenReturn(lastName);
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getParameter("confirmPass")).thenReturn(confirmPass);
        Mockito.when(request.getParameter("email")).thenReturn(email);
        Mockito.when(request.getParameter("age")).thenReturn(age);
        Mockito.when(request.getParameter("phoneNumber")).thenReturn(phone);
        Mockito.when(request.getParameter("address")).thenReturn(address);
        Mockito.when(request.getParameter("note")).thenReturn(note);
        Mockito.when(request.getParameter("selectRole")).thenReturn(role);
        Mockito.when(request.getParameter("khoa")).thenReturn(khoa);
        Mockito.when(request.getSession()).thenReturn(session);
        addUserController.doPost(request, response);

        message.add("User with username/phone/email info is already exist");
        Mockito.verify(request).setAttribute("message", message);
        //Mockito.verify(request).getRequestDispatcher("home.jsp").forward(request, response);

    }


}
