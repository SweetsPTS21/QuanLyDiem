import com.qld.quanlydiem.Controller.LoginController;
import com.qld.quanlydiem.Controller.LogoutController;
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

import static org.junit.jupiter.api.Assertions.*;

class LogoutControllerTest {
    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    HttpSession session;

    @Mock
    LogoutController logoutController;

    @BeforeEach
    public void init(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        logoutController = new LogoutController();
    }
    @Test
    @DisplayName("Should set attribute and redirect to home.jsp when username and password are correct")
    public void TestMethod1() throws ServletException, IOException {
        Mockito.when(request.getSession()).thenReturn(session);
        logoutController.processRequest(request, response);
        Mockito.verify(session).removeAttribute("username");
        Mockito.verify(session).removeAttribute("userID");
        Mockito.verify(session).removeAttribute("role");
        Mockito.verify(response).sendRedirect("index.jsp");
    }

}