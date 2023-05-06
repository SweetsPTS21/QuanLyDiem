import com.qld.quanlydiem.Controller.FindStudentController;
import com.qld.quanlydiem.Controller.PointTrackingController;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PointTrackingControllerTest {
    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    HttpSession session;

    @Mock
    PointTrackingController pointTrackingController;
    @BeforeEach
    public void init(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        pointTrackingController = new PointTrackingController();
    }
    @Test
    public void TestMethod1() throws ServletException, IOException {
        String TKByLHP = "LHP-01";
        Mockito.when(request.getParameter("TKByLHP")).thenReturn(TKByLHP);
        pointTrackingController.doGet(request, response);
        Mockito.verify(request).getRequestDispatcher("exportReport.jsp");
    }

    @Test
    public void TestMethod2() throws ServletException, IOException{
        String findGrade = "D19";
        String findSubject = "Kiểm thử";
        String findClass = "CN5";
        String findTerm = "HK1";
        String findKhoa = "Công nghệ thông tin";
        Mockito.when(request.getParameter("findGrade")).thenReturn(findGrade);
        Mockito.when(request.getParameter("findSubject")).thenReturn(findSubject);
        Mockito.when(request.getParameter("findClass")).thenReturn(findClass);
        Mockito.when(request.getParameter("findTerm")).thenReturn(findTerm);
        Mockito.when(request.getParameter("findKhoa")).thenReturn(findKhoa);
        pointTrackingController.doPost(request, response);
        Mockito.verify(request).getRequestDispatcher("managePoint.jsp");
    }
}