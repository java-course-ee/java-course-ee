package edu.javacourse.spring;

import edu.javacourse.spring.bean.RegionManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExample {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});


        simpleAdvisor(context);

        //anotherAdvisor(context);


        //regexpAdvisor(context);


    }

    private static void regexpAdvisor(ApplicationContext context) {
        System.out.println("===============================================");

        RegionManager regRegionManager = (RegionManager) context.getBean("regexpRegionProxy");
        System.out.println(regRegionManager.getNumber());
        regRegionManager.getInfo();
        regRegionManager.setName("test");
        regRegionManager.setNumber(1);
        System.out.println("=====================================================");
    }

    private static void anotherAdvisor(ApplicationContext context) {
        System.out.println("===============================================");

        RegionManager newRegionManager = (RegionManager) context.getBean("newRegionProxy");
        System.out.println(newRegionManager.getNumber());
        newRegionManager.getInfo();
    }

    private static void simpleAdvisor(ApplicationContext context) {
        RegionManager regionManager = (RegionManager) context.getBean("regionProxy");

        System.out.println(regionManager.getNumber());
        regionManager.getInfo();
    }
}
