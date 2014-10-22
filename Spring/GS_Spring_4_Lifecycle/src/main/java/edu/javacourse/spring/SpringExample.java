package edu.javacourse.spring;

import edu.javacourse.spring.lifecyrcle.LifeTest;
import edu.javacourse.spring.lifecyrcle.LifeTest2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExample {

    public static void main(String[] args) {
        SpringExample se = new SpringExample();
        se.demoSpring();
    }

    public void demoSpring() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});

        LifeTest lt = context.getBean("lifeTest", LifeTest.class);
        LifeTest2 lt2 = context.getBean("lifeTest2", LifeTest2.class);

        // Надо привести к типу ClassPathXmlApplicationContext для использования destroy
        ((ClassPathXmlApplicationContext) context).start();
        ((ClassPathXmlApplicationContext) context).stop();
        //((ClassPathXmlApplicationContext)context).close();
        ((ClassPathXmlApplicationContext) context).refresh();
    }
}
