package edu.javacourse.spring;

import edu.javacourse.spring.service.RegionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: Georgy Gobozov
 * Date: 25.07.13
 */
public class SpringServlet extends HttpServlet {

    ApplicationContext context = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegionService regionService = (RegionService) context.getBean("regionService");
        regionService.readOnly("test");
    }
}
