package edu.javacourse.ejb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "InterceptorsServlet", urlPatterns = {"/interceptorsServlet"})
public class InterceptorsServlet extends HttpServlet {

    @EJB
    private InterceptorEJB bean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        bean.hello();
        bean.goodbye();
    }

}
