package edu.javacourse.spring;

import edu.javacourse.spring.bean.Command;
import edu.javacourse.spring.bean.CommandManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExample {

    public static void main(String[] args) {
        SpringExample se = new SpringExample();
        se.demoSpring();
    }


    //http://java.dzone.com/articles/method-injection-spring
    // Пример для демонстрации
    public void demoSpring() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});

        CommandManager cm = context.getBean("commandManager", CommandManager.class);

        System.out.println("class: " + cm.getClass().getCanonicalName());

        Command c1 = cm.createCommand();
        System.out.println("Hash C1:" + c1.hashCode());
        c1.execute();

        Command c2 = cm.createCommand();
        System.out.println("Hash C2:" + c2.hashCode());
        System.out.println("State C2:" + c2.getState());
    }
}
