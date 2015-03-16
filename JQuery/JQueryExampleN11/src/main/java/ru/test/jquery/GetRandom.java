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
public class GetRandom extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {

            Thread.sleep(3000);
            out.print(Math.round(Math.random() * 1000));
        } catch (InterruptedException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        } finally {
            out.close();
        }
    }
}
