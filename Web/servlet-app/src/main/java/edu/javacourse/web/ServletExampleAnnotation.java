package edu.javacourse.web;

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
@WebServlet(name = "ServletExampleAnnotation", urlPatterns = "/servlet-annotation")
public class ServletExampleAnnotation extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        PrintWriter out = resp.getWriter();

        try {

            out.write("<html><head><title>My First Servlet Response</title></head><body><h1>Hello " + name + "</h1></body></html>");

        } finally {
            out.close();
        }
    }
}
