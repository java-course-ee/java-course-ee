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
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        int result;
        try {
            int val1 = Integer.parseInt(request.getParameter("summand1"));
            int val2 = Integer.parseInt(request.getParameter("summand2"));
            result = val1 + val2;
            out.print(result);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } finally {
            out.close();
        }
    }
}
