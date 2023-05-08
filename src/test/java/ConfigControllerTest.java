import com.qld.quanlydiem.Controller.ConfigController;
import com.qld.quanlydiem.Controller.LoginController;
import com.qld.quanlydiem.DAO.SubjectDAO;
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

import static org.junit.jupiter.api.Assertions.*;

class ConfigControllerTest {
    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    HttpSession session;

    @Mock
    ConfigController configController;

    @BeforeEach
    public void init(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        configController = new ConfigController();
    }

    @Test
    public void TestMethod1() throws ServletException, IOException {
        ArrayList<String> ids = SubjectDAO.getInstance().getAllSubjectId();
        configController.doPost(request, response);
        Mockito.verify(request).setAttribute("ids", ids);
        Mockito.verify(request).getRequestDispatcher("configSubject.jsp");

    }

}