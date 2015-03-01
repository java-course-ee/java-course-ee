package edu.javacourse;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
@WebServlet(name = "GreetingServletJNDI", urlPatterns = {"/greetingServletJNDI"})
public class GreetingServletJNDI extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Greeting greetingStateful;
        Greeting greetingStateless;
        try {
            Context context = new InitialContext();
            greetingStateful = (Greeting) context.lookup("java:module/GreetingStatefulEJB");
            greetingStateless = (Greeting) context.lookup("java:module/GreetingStatelessEJB");

            response.getWriter().write("Stateful class: " + greetingStateful.getClass().getCanonicalName() + "\n");
            response.getWriter().write("Stateless class: " + greetingStateless.getClass().getCanonicalName() + "\n");

            final String name = request.getParameter("name");
            String helloStsteful = greetingStateful.sayHello(name);
            String helloStsteless = greetingStateless.sayHello(name);

            response.getWriter().write("First invoke:\n");
            response.getWriter().write("Stateful: " + helloStsteful + "\n");
            response.getWriter().write("Stateless: " + helloStsteless + "\n");
            response.getWriter().write("\n\n");

            helloStsteful = greetingStateful.sayHello(name);
            helloStsteless = greetingStateless.sayHello(name);

            response.getWriter().write("Second invoke:\n");
            response.getWriter().write("Stateful: " + helloStsteful + "\n");
            response.getWriter().write("Stateless: " + helloStsteless + "\n");

            response.getWriter().close();
        } catch (NamingException e) {
            throw new ServletException("Error while creating JNDI context");
        }
    }
}
