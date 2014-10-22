package edu.javacourse.spring;

import edu.javacourse.spring.aware.BeanAware;
import edu.javacourse.spring.aware.ContextAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExample {

    public static void main(String[] args) {
        SpringExample se = new SpringExample();
        se.demoSpring();
    }

    public void demoSpring() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});

        ContextAware ca = context.getBean("contextAware", ContextAware.class);
        BeanAware ba = context.getBean("beanaaaaaAware", BeanAware.class);

        // Если надо узнать, что приложение закончило работу (это только для standalone)
        // то можно использовать этот вариант
        //((ClassPathXmlApplicationContext)context).registerShutdownHook();

        // Надо привести к типу ClassPathXmlApplicationContext для использования destroy
        // Это прямой вызов уничтожения контекста Spring
        //((ClassPathXmlApplicationContext)context).destroy();

    }
}
