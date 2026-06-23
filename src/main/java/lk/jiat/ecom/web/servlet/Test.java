package lk.jiat.ecom.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.jiat.ecom.user.remote.TestRemote;

import javax.naming.InitialContext;
import java.io.IOException;

@WebServlet("/test")
public class Test extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Ecom web module test");

//        try {
//            InitialContext ic = new InitialContext();
//            UserRemote userRemote = (UserRemote)
//                    ic.lookup("java:global/ecom-user-1.0/UserSessionBean");
//            List<UserDTO> allUsers = userRemote.getAllUsers();
//            for (UserDTO user : allUsers) {
//                user.toString();
//            }
//        } catch (NamingException e) {
//            throw new RuntimeException(e);
//        }

        try {
            InitialContext ic = new InitialContext();
            TestRemote tc = (TestRemote)
                    ic.lookup("java:global/ecom-user-1.0/TestSessionBean");
            String test = tc.test();
            resp.getWriter().write(test);
        } catch (Exception e) {
            throw new ServletException(e);
        }

    }
}
