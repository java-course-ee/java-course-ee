package edu.javacourse.ejb;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Future;

@WebServlet(name = "AsyncServlet", urlPatterns = {"/asyncServlet"})
public class AsyncServlet extends HttpServlet {

    @EJB
    private AsyncEJB bean;

    private Future<String> answer; // ! WARNING ! Don't do that. This field will be accessible by other servlet users.

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            if (answer == null) {
                answer = bean.sayHello();
            }
            out.println("<html>");
            out.println("<body>");
            out.println("<h2>EJB says:" + answer.isDone() + "</h2>");
            if (answer.isDone()) {
                out.println("<h3>" + answer.get() + "</h3>");
                answer = null;
            }
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

}
