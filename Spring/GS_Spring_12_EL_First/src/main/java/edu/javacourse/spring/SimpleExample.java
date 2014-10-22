package edu.javacourse.spring;

import edu.javacourse.spring.bean.User;
import edu.javacourse.spring.bean.UserGroup;
import edu.javacourse.spring.spel.ExpressionExample;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        SpELDemo1();
        SpELDemo2();
    }

    private static void SpELDemo1() {
        ExpressionExample ee = new ExpressionExample();
        ee.simpleString();
        ee.concat();
        ee.upperCase();
        ee.math1();
        ee.math2();
        ee.field();
    }

    private static void SpELDemo2() throws BeansException {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});

        User u = context.getBean("userBean", User.class);
        System.out.println("user full name:" + u.getFirstName() + " " + u.getLastName());

        System.out.println("==============================================");

        UserGroup group = context.getBean(UserGroup.class);
        System.out.println("Group Name = " + group.getName());
        System.out.println("Group Owner = " + group.getOwner());
    }
}
