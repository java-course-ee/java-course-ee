package edu.javacourse.web;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Intern
 */
@WebServlet(name = "ServletExampleAnnotation", urlPatterns = "/servlet-annotation", asyncSupported = true)
public class ServletExampleAnnotation extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AsyncContext asyncContext = req.startAsync(req, resp);
        

    }
}
