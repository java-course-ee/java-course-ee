package edu.javacourse.spring;

import edu.javacourse.spring.bean.PrototypeBean;
import edu.javacourse.spring.bean.SingletonBean;
import edu.javacourse.spring.bean.ThreadScopeBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExample {

    public static void main(String[] args) {
        SpringExample se = new SpringExample();
        se.demoSpring();
    }

    // Пример для демонстрации
    public void demoSpring() {
        final ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});

        SingletonBean st1 = context.getBean("testSpringBean", SingletonBean.class);
        System.out.println("Singleton 1 hashcode:" + st1.hashCode());
        System.out.println("Singleton 1 Child hashcode:" + st1.getChild().hashCode());

        System.out.println("------------------------------------------------------");

        SingletonBean st2 = context.getBean("testSpringBean", SingletonBean.class);
        System.out.println("Singleton 2 hashcode:" + st2.hashCode());
        System.out.println("Singleton 2 Child hashcode:" + st2.getChild().hashCode());

        System.out.println("=========================================================");
        PrototypeBean stCh1 = context.getBean("dependedBean", PrototypeBean.class);
        System.out.println("Prototype 1 hashcode:" + stCh1.hashCode());

        System.out.println("------------------------------------------------------");
        PrototypeBean stCh2 = context.getBean("dependedBean", PrototypeBean.class);
        System.out.println("Prototype 2 hashcode" + stCh2.hashCode());

        System.out.println("=========================================================");

        ThreadScopeBean cst1 = (ThreadScopeBean) context.getBean("customScopeBean");
        System.out.println("ThreadScopeBean 1 hashcode:" + cst1.hashCode());
        System.out.println("------------------------------------------------------");
        ThreadScopeBean cst2 = (ThreadScopeBean) context.getBean("customScopeBean");
        System.out.println("ThreadScopeBean 2 hashcode:" + cst2.hashCode());
        System.out.println("=========================================================");


        new Thread() {
            @Override
            public void run() {
                ThreadScopeBean cst3 = (ThreadScopeBean) context.getBean("customScopeBean");
                System.out.println("ThreadScopeBean 3 hashcode:" + cst3.hashCode());
                System.out.println("=========================================================");
            }
        }.start();

        ((ClassPathXmlApplicationContext) context).destroy();
    }
}
