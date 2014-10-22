package edu.javacourse.spring;

import edu.javacourse.spring.bean.RegionManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExample {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});


        RegionManager regionManager = (RegionManager) context.getBean("regionProxy");
        System.out.println(regionManager.getNumber());


        //regionManager.throwException();

        regionManager.getInfo();


    }
}
