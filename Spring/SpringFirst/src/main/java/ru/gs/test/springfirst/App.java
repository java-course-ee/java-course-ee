package ru.gs.test.springfirst;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.gs.test.springfirst.dao.DAOImpl;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring-context.xml"});

        DAOImpl view = context.getBean(DAOImpl.class);
        System.out.println(view);
        view = context.getBean(DAOImpl.class);
        System.out.println(view);
        view = context.getBean(DAOImpl.class);
        System.out.println(view);
        view = context.getBean(DAOImpl.class);
        System.out.println(view);
        view = context.getBean(DAOImpl.class);
        System.out.println(view);
    }
}
