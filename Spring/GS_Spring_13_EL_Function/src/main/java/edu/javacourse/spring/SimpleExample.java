package edu.javacourse.spring;

import edu.javacourse.spring.bean.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleExample {

    public static void main(String[] args) throws NoSuchMethodException {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});
        Customer customer = context.getBean(Customer.class);
        System.out.println("customer = " + customer);


    }


}
