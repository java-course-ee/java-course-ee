package edu.javacourse.ejb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TestAopServlet", urlPatterns = {"/TestAopServlet"})
public class TestAopServlet extends HttpServlet {
    
    @EJB
    private AopTestBean bean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            bean.aopTest1();
            bean.aopTest2();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestAopServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestAopServlet</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
