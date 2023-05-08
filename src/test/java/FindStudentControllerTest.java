import com.qld.quanlydiem.Controller.FindStudentController;
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

class FindStudentControllerTest {
    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    HttpSession session;

    @Mock
    FindStudentController findStudentController;
    @BeforeEach
    public void init(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        findStudentController = new FindStudentController();
    }
    @Test
    public void TestMethod1() throws ServletException, IOException {
        String khoa = "Công nghệ thông tin";
        Mockito.when(request.getParameter("khoa")).thenReturn(khoa);
        Mockito.when(request.getSession()).thenReturn(session);
        findStudentController.doGet(request, response);
        Mockito.verify(request).getRequestDispatcher("exportReport.jsp");
    }

    @Test
    public void TestMethod2() throws ServletException, IOException{
        String findLHP = "LHP-01";
        String khoa = "Công nghệ thông tin";
        Mockito.when(request.getParameter("findLHP")).thenReturn(findLHP);
        Mockito.when(request.getParameter("khoa")).thenReturn(khoa);
        findStudentController.doPost(request, response);
        Mockito.verify(request).getRequestDispatcher("exportReport.jsp");
    }
}