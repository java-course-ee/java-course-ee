package edu.javacourse.spring;

import edu.javacourse.spring.bean.*;
import edu.javacourse.spring.bean.init.InitBean2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExample {

    public static void main(String[] args) {
        SpringExample se = new SpringExample();
        se.demoSpring();
    }

    public void demoSpring() {
        // Вариант относительного пути к файлу
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});

        // Вариант вызова файла, который включает в себя другие файлы
//        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springSuit.xml"});

        // Вариант абсолютного пути к файлу
//        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(new String[]{"springExample.xml"});


        // пример, показывающий каким образом можно проинициализировать бины и уничтожить их.
        test0(context);

        // test1(context);

        // test2(context);

        // test3(context);

        // test4(context);

//        test5(context);


    }

    private void test0(ApplicationContext context) {
        // Вызов бинов с постинициализацией и преддестроем - здесь показан старый вариант приведения типа
        //InitBean1 init1 = (InitBean1) context.getBean("init1");
        InitBean2 init2 = (InitBean2) context.getBean("init2");
        InitBean2 init3 = (InitBean2) context.getBean("init2");

        // Надо привести к типу ClassPathXmlApplicationContext для использования destroy
        ((ClassPathXmlApplicationContext) context).destroy();
    }

    private void test5(ApplicationContext context) {
        // List example

        SpringList springList = (SpringList) context.getBean("listBean");
        for (String s : springList.getStringList()) {
            System.out.println("List item = " + s);
        }


        // Инициализация свойства типа Map
        SpringMap test5 = context.getBean("testMap", SpringMap.class);
        System.out.println("===> Map");
        for (String s : test5.getAccounts().keySet()) {
            Float f = test5.getAccounts().get(s);
            System.out.println(s + ":" + f);
        }
        System.out.println();
        System.out.println();
    }

    private void test4(ApplicationContext context) {
        // Создание обхекта с указанием параметров в конструкторе
        SpringTestConstructor test4 = context.getBean("constructorBean", SpringTestConstructor.class);
        System.out.println("===> Constructor");
        System.out.println(test4.getNumber());
        System.out.println(test4.getName());
        System.out.println(test4.getTest().getNumber());
        System.out.println(test4.getTest().getChild().getHello());
        System.out.println();
        System.out.println();
    }

    private void test3(ApplicationContext context) {
        // Создание обхекта через статический вызов
        System.out.println("===> getInstance");
        SpringTestInstance test2 = context.getBean("instanceBean1", SpringTestInstance.class);
        test2.sayHello();
        SpringTestInstance test3 = context.getBean("instanceBean2", SpringTestInstance.class);
        test3.sayHello();
        System.out.println();
        System.out.println();
    }

    private void test2(ApplicationContext context) {
        // Вызов бина с внутренним описанием еще одного бина
        SpringTest stInner = context.getBean("outerbean", SpringTest.class);
        System.out.println(stInner.getNumber());
        System.out.println(stInner.getChild().getHello());
        System.out.println();
        System.out.println();
    }

    private void test1(ApplicationContext context) {
        // Пример вызова бина, который указан в конфигурационном файле
        // Теперь можно указывать класс явно
        System.out.println();
        System.out.println();
        SpringTest st = context.getBean("testSpringBean", SpringTest.class);
        System.out.println(st.getNumber());
        System.out.println(st.getChild().getHello());
        System.out.println(st.getOtherChild().getHello());
        System.out.println();
        System.out.println();
    }
}
