import com.qld.quanlydiem.Controller.ConfigController;
import com.qld.quanlydiem.Controller.ConfigSubjectController;
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

public class ConfigSubjectControllerTest {
    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    HttpSession session;

    @Mock
    ConfigSubjectController configSubjectController;

    @BeforeEach
    public void init(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        configSubjectController = new ConfigSubjectController();
        List<String> message = new ArrayList<>();
    }

    @Test
    @DisplayName("Should return success message when idSubject is found")
    public void returnMessageWhenIdSubjectIsFound() throws ServletException, IOException {
        String idSubject = "INT1154";
        String selectDTP = "Chuyên cần";
        String subPercent = "12";
        
        Mockito.when(request.getParameter("idSubject")).thenReturn(idSubject);
        Mockito.when(request.getParameter("selectDTP")).thenReturn(selectDTP);
        Mockito.when(request.getParameter("subPercent")).thenReturn(subPercent);
       
        configSubjectController.doPost(request, response);
        List<String> message= new ArrayList<>();
        message.add("Cập nhật đầu điểm thành công");
        Mockito.verify(request).setAttribute("message", message);
        Mockito.verify(request).getRequestDispatcher("configSubject.jsp");
    }

    @Test
    @DisplayName("Should return success message when idSubject is not found")
    public void returnMessageWhenIdSubjectIsNotFound() throws ServletException, IOException {
        String idSubject = "INT1111";
        String selectDTP = "Chuyên cần";
        String subPercent = "10";
        Mockito.when(request.getParameter("idSubject")).thenReturn(idSubject);
        Mockito.when(request.getParameter("selectDTP")).thenReturn(selectDTP);
        Mockito.when(request.getParameter("subPercent")).thenReturn(subPercent);

        configSubjectController.doPost(request, response);
        List<String> message= new ArrayList<>();
        message.add("Không tìm thấy môn học trong hệ thống");
        Mockito.verify(request).setAttribute("message", message);
        Mockito.verify(request).getRequestDispatcher("configSubject.jsp");
    }
    
    @Test
    @DisplayName("Should return faild message when An error occurred")
    public void testCase3() throws ServletException, IOException {
        String idSubject = "INT1111";
        String selectDTP = "Chuyên cần";
        String subPercent = "10";
        Mockito.when(request.getParameter("idSubject")).thenReturn(idSubject);
        Mockito.when(request.getParameter("selectDTP")).thenReturn(selectDTP);
        Mockito.when(request.getParameter("subPercent")).thenReturn(subPercent);

        configSubjectController.doPost(request, response);
        List<String> message= new ArrayList<>();
        message.add("Cập nhật đầu điểm thất bại");
        Mockito.verify(request).setAttribute("message", message);
        Mockito.verify(request).getRequestDispatcher("configSubject.jsp");
    }
    
    @Test
    @DisplayName("Should return faild message when user enters a score greater than 100")
    public void testCase4() throws ServletException, IOException {
        String idSubject = "INT1111";
        String selectDTP = "Chuyên cần";
        String subPercent = "110";
        Mockito.when(request.getParameter("idSubject")).thenReturn(idSubject);
        Mockito.when(request.getParameter("selectDTP")).thenReturn(selectDTP);
        Mockito.when(request.getParameter("subPercent")).thenReturn(subPercent);

        configSubjectController.doPost(request, response);
        List<String> message= new ArrayList<>();
        message.add("Vui lòng nhập số lớn hơn 0 và nhỏ hơn 100");
        Mockito.verify(request).setAttribute("message", message);
        Mockito.verify(request).getRequestDispatcher("configSubject.jsp");
    }
    @Test
    @DisplayName("Should return faild message when user enters a score less than 0")
    public void testCase5() throws ServletException, IOException {
        String idSubject = "INT1111";
        String selectDTP = "Chuyên cần";
        String subPercent = "-10";
        Mockito.when(request.getParameter("idSubject")).thenReturn(idSubject);
        Mockito.when(request.getParameter("selectDTP")).thenReturn(selectDTP);
        Mockito.when(request.getParameter("subPercent")).thenReturn(subPercent);

        configSubjectController.doPost(request, response);
        List<String> message= new ArrayList<>();
        message.add("Vui lòng nhập số lớn hơn 0 và nhỏ hơn 100");
        Mockito.verify(request).setAttribute("message", message);
        Mockito.verify(request).getRequestDispatcher("configSubject.jsp");
    }
    
    @Test
    @DisplayName("Should return faild message when user enters a score greater than 30")
    public void testCase6() throws ServletException, IOException {
        String idSubject = "INT1111";
        String selectDTP = "Chuyên cần";
        String subPercent = "40";
        Mockito.when(request.getParameter("idSubject")).thenReturn(idSubject);
        Mockito.when(request.getParameter("selectDTP")).thenReturn(selectDTP);
        Mockito.when(request.getParameter("subPercent")).thenReturn(subPercent);

        configSubjectController.doPost(request, response);
        List<String> message= new ArrayList<>();
        message.add("Điểm chuyên cần phải nhỏ hơn 30%");
        Mockito.verify(request).setAttribute("message", message);
        Mockito.verify(request).getRequestDispatcher("configSubject.jsp");
    }
    
    @Test
    @DisplayName("Should return faild message when user enters a test score less than 50")
    public void testCase7() throws ServletException, IOException {
        String idSubject = "INT1111";
        String selectDTP = "Chuyên cần";
        String subPercent = "20";
        Mockito.when(request.getParameter("idSubject")).thenReturn(idSubject);
        Mockito.when(request.getParameter("selectDTP")).thenReturn(selectDTP);
        Mockito.when(request.getParameter("subPercent")).thenReturn(subPercent);

        configSubjectController.doPost(request, response);
        List<String> message= new ArrayList<>();
        message.add("Điểm thi phải lớn hơn 50%");
        Mockito.verify(request).setAttribute("message",message );
        Mockito.verify(request).getRequestDispatcher("configSubject.jsp");
    }
    
    @Test
    @DisplayName("Should return faild message when user enters idSubject less than 5 characters")
    public void testCase8() throws ServletException, IOException {
        String idSubject = "INT1";
        String selectDTP = "Chuyên cần";
        String subPercent = "10";
        Mockito.when(request.getParameter("idSubject")).thenReturn(idSubject);
        Mockito.when(request.getParameter("selectDTP")).thenReturn(selectDTP);
        Mockito.when(request.getParameter("subPercent")).thenReturn(subPercent);

        configSubjectController.doPost(request, response);
        List<String> message= new ArrayList<>();
        message.add("Mã môn học phải chứa 5 đến 7 kí tự");
        Mockito.verify(request).setAttribute("message", message);
        Mockito.verify(request).getRequestDispatcher("configSubject.jsp");
    }
    
    @Test
    @DisplayName("Should return faild message when user enters idSubject greater than 7 characters")
    public void testCase9() throws ServletException, IOException {
        String idSubject = "INTTE2334";
        String selectDTP = "Chuyên cần";
        String subPercent = "10";
        Mockito.when(request.getParameter("idSubject")).thenReturn(idSubject);
        Mockito.when(request.getParameter("selectDTP")).thenReturn(selectDTP);
        Mockito.when(request.getParameter("subPercent")).thenReturn(subPercent);

        configSubjectController.doPost(request, response);
        List<String> message= new ArrayList<>();
        message.add("Mã môn học phải chứa 5 đến 7 kí tự");
        Mockito.verify(request).setAttribute("message",message );
        Mockito.verify(request).getRequestDispatcher("configSubject.jsp");
    }
    
}
