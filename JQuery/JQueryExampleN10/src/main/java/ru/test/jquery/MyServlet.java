/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.test.jquery;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author APronchakov <artem.pronchakov@gmail.com>
 */
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        String result;
        try {
            Integer val1 = Integer.parseInt(request.getParameter("MyParam1"));
            Integer val2 = Integer.parseInt(request.getParameter("MyParam2"));
            result = String.valueOf(val1 + val2);
        } catch (NumberFormatException e) {
            result = "You should input only numbers!";
        }

        try {
            out.print(result);
        } finally {
            out.close();
        }
    }
}
