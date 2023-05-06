import com.qld.quanlydiem.Controller.DeleteUserController;
import com.qld.quanlydiem.Controller.LoginController;
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

class DeleteUserControllerTest {
    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    HttpSession session;

    @Mock
    DeleteUserController deleteUserController;

    @BeforeEach
    public void init(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        deleteUserController = new DeleteUserController();
    }

    @Test
    public void TestMethod1() throws ServletException, IOException {
        String userId = "2";
        Mockito.when(request.getParameter("userId")).thenReturn(userId);
        Mockito.when(request.getSession()).thenReturn(session);
        deleteUserController.doGet(request, response);
        Mockito.verify(response).sendRedirect("home.jsp");
    }

}