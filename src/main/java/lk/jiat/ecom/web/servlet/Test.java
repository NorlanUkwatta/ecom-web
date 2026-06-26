package lk.jiat.ecom.web.servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/test", loadOnStartup = 1)
public class Test extends HttpServlet {
//
//    @EJB(lookup = "java:global/ecom-user-1.0/TestNewSessionBean") //J2EE 5+
//    private TestRemote testRemote;
//
//    @EJB
//    private AppSetting appSetting;

    @Inject
    private MyApp myApp;

    @Override
    public void init() throws ServletException {
        System.out.println("Test init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Ecom web module test<br>");

//        try {
        //J2EE 1+
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

//        try {
//            InitialContext ic = new InitialContext();
//            TestRemote tc = (TestRemote)
//                    ic.lookup("java:global/ecom-user-1.0/TestSessionBean");
//            String test = tc.test();
//            resp.getWriter().write(test);
//        } catch (Exception e) {
//            throw new ServletException(e);
//        }

//        resp.getWriter().write("App Name: " + appSetting.getName());
        req.getSession();
        myApp.doSomething();


    }
}
