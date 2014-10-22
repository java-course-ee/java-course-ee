package edu.javacourse.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class SpringExample {

    public static void main(String[] args) {
        SpringExample se = new SpringExample();
        se.demoSpring();
    }

    public void demoSpring() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"config.xml"});

        DataSource dataSource = (DataSource) context.getBean("dataSource");
        System.out.println("dataSource = " + dataSource);

        PropertiesBean propertiesBean = (PropertiesBean) context.getBean("propertyBean");
        System.out.println("propertiesBean = " + propertiesBean);


    }
}
