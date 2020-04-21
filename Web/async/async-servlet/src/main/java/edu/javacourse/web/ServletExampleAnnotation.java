package edu.javacourse.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author Intern
 */
@WebServlet(name = "AsyncServlet", urlPatterns = "/servlet", asyncSupported = true)
public class ServletExampleAnnotation extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(ServletExampleAnnotation.class);

    @Resource
    private ManagedExecutorService managedExecutorService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("doGet start");
        AsyncContext asyncContext = req.startAsync(req, resp);
        final PrintWriter writer = resp.getWriter();

        log.info("Before submit runnable");
        managedExecutorService.submit(() -> {
            log.info("Runnable start");
            try {
                Thread.sleep(10000);
                writer.write("Data constructed at " + new Date());
                log.info("Data constructed");
                Thread.sleep(5000);
                log.info("Before async complete");
                asyncContext.complete();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("Runnable end");
        });
        log.info("doGet end");
    }
}
