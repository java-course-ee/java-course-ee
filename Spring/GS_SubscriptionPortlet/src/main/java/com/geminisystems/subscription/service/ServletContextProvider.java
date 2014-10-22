package com.geminisystems.subscription.service;

import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 17.11.2011
 * Time: 15:46:41
 * To change this template use File | Settings | File Templates.
 */
public class ServletContextProvider implements ServletContextAware {


    private ServletContext context;

    public void setServletContext(ServletContext servletContext) {
        context = servletContext;
    }

    public ServletContext getContext() {
        return context;
    }
}
