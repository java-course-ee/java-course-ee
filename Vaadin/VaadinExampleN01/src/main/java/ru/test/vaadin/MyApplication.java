package ru.test.vaadin;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

import javax.servlet.annotation.WebServlet;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
@WebServlet(value = "/*", asyncSupported = true)
@VaadinServletConfiguration(productionMode = false, ui = MyWindow.class)
public class MyApplication extends VaadinServlet {
}
