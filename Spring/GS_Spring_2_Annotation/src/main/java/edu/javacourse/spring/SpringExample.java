package edu.javacourse.spring;

import edu.javacourse.spring.bean.BeanExample;
import edu.javacourse.spring.bean.SpringAnnotated;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExample {

    public static void main(String[] args) {
        SpringExample se = new SpringExample();
        se.demoSpring();
    }

    public void demoSpring() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});

        // Пример вызова бина, который описан аннотациями
        SpringAnnotated sa = context.getBean(SpringAnnotated.class);
        System.out.println("Annotated test:" + sa.getTestString());
        System.out.println("Annotated other:" + sa.getOtherString());
        System.out.println("Annotated spring bean:" + sa.getSpringTest().getNumber());
        System.out.println();

        // Обратить внимание на то. что объект создается через вызов метода
        BeanExample be = context.getBean(BeanExample.class);
        System.out.println("Method bean:" + be.getBasicString());
        System.out.println();
        System.out.println();

    }
}
