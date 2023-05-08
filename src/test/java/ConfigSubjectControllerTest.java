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
    }

    @Test
    @DisplayName("Should return success message when idSubject is found")
    public void returnMessageWhenIdSubjectIsFound() throws ServletException, IOException {
        String idSubject = "INT1154";
        String selectDTP = "Chuyên cần";
        String subPercent = "10";
        Mockito.when(request.getParameter("idSubject")).thenReturn(idSubject);
        Mockito.when(request.getParameter("selectDTP")).thenReturn(selectDTP);
        Mockito.when(request.getParameter("subPercent")).thenReturn(subPercent);

        configSubjectController.doPost(request, response);
        Mockito.verify(request).setAttribute("message", "success");
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
        Mockito.verify(request).setAttribute("message", "failure");
        Mockito.verify(request).getRequestDispatcher("configSubject.jsp");
    }
}
