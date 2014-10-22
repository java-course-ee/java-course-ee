package edu.javacourse.spring;

import edu.javacourse.spring.bean.CityManager;
import edu.javacourse.spring.bean.RegionManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExample {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});


        // pointcut1(context);

        //pointcut2(context);


        pointcut3(context);


    }


    private static void pointcut1(ApplicationContext context) {
        RegionManager regionManager = (RegionManager) context.getBean("regionManager");
        System.out.println("===============================================");
        System.out.println(regionManager.getNumber());
        System.out.println(regionManager.getName());
        System.out.println(regionManager.getClass());
        System.out.println("===============================================");
        regionManager.createRegion("SPB");
    }


    private static void pointcut2(ApplicationContext context) {
        CityManager cityManager = (CityManager) context.getBean("cityManager");
        cityManager.deleteCity();
        cityManager.getNumber();
        cityManager.getName();
        cityManager.createCity("test");

    }

    private static void pointcut3(ApplicationContext context) {
        RegionManager regionManager = (RegionManager) context.getBean("regionManager");
        System.out.println(regionManager.getNumber());
        System.out.println(regionManager.getName());
        System.out.println(regionManager.getClass());
        regionManager.createRegion("SPB");
    }


}
