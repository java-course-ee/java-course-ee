package edu.javacourse.ejb;

import javax.ejb.EJB;
import javax.ejb.Timer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */

@WebServlet(name = "TimerServlet", urlPatterns = {"/timerServlet"})
public class TimerServlet extends HttpServlet {

    @EJB
    private TimerServiceEJB ejb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Collection<Timer> timers = ejb.getAllTimers();
        for (Timer timer : timers) {
            resp.getWriter().write(timer.toString() + "\n\n\n");
        }
        resp.getWriter().close();

    }
}
