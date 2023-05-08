
import com.mysql.cj.Session;
import com.qld.quanlydiem.Controller.LoginController;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sondt
 */
@DisplayName("Test Login Controller")
public class TestLoginController {
    @Mock
    HttpServletRequest request;
    
    @Mock
    HttpServletResponse response;
    
    @Mock
    HttpSession session;
    
    @Mock
    LoginController loginController;
    
    @BeforeEach
    public void init(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        loginController = new LoginController();
    }
    
    @Test
    @DisplayName("Should set attribute and redirect to home.jsp when username and password are correct")
    public void TestMethod1() throws ServletException, IOException{
        String username = "manager01";
        String password = "manager01";
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getSession()).thenReturn(session);
        loginController.doPost(request, response);
        Mockito.verify(session).setAttribute("username", username);
        Mockito.verify(session).setAttribute("userId", "15");
        Mockito.verify(session).setAttribute("role", "manager");
        Mockito.verify(response).sendRedirect("home.jsp"); 
    }
    
    @Test
    @DisplayName("Should return message when username less than 6 character")
    public void TestMethod2() throws ServletException, IOException{
        String username = "admin";
        String password = "admin123";
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getSession()).thenReturn(session);
        loginController.doPost(request, response);
        Mockito.verify(request).setAttribute("message","Username must be between 6 and 30 characters"); 
    }
    
    @Test
    @DisplayName("Should return message Username must not contain special characters when username has special characters")
    public void TestMethod3() throws ServletException, IOException{
        String username = "admin123 4";
        String password = "admin123";
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getSession()).thenReturn(session);
        loginController.doPost(request, response);
        Mockito.verify(request).setAttribute("message","Username must not contain special characters");
    }

    @Test
    @DisplayName("Should return message Password must not contain space characters when password has space characters")
    public void TestMethod4() throws ServletException, IOException{
        String username = "admin1234";
        String password = "admin 123";
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getSession()).thenReturn(session);
        loginController.doPost(request, response);
        Mockito.verify(request).setAttribute("message","Password must not contain space characters");
    }
    
    @Test
    @DisplayName("Should return message Username must be between 6 and 30 characters when username/password more than 30 character")
    public void TestMethod6() throws ServletException, IOException{
        String username = "adminnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn";
        String password = "adminnnnnn";
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getSession()).thenReturn(session);
        loginController.doPost(request, response);
        Mockito.verify(request).setAttribute("message","Username must be between 6 and 30 characters"); 
    }
    
    
            
    @Test
    @DisplayName("Should return message Username or password is incorrect when username password not correct")
    public void TestMethod7() throws ServletException, IOException{
        String username = "adminnnn2";
        String password = "adminnnnnn";
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(request.getSession()).thenReturn(session);
        loginController.doPost(request, response);
        Mockito.verify(request).setAttribute("message","Username or password is incorrect"); 
    }
}
