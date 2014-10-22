package edu.javacourse.spring;

import edu.javacourse.spring.bean.RegionManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExample {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});


        //beforeAspect(context);

        // afterAspect(context);


        //  afterReturnAspect(context);

        //afterThrowAspect(context);

        aroundAspect(context);
    }


    private static void beforeAspect(ApplicationContext context) {
        RegionManager regionManager = (RegionManager) context.getBean("regionManager");
        System.out.println("===============================================");
        System.out.println(regionManager.getNumber());
        System.out.println("===============================================");
        regionManager.createRegion("SPB");
    }


    private static void afterAspect(ApplicationContext context) {
        RegionManager regionManager = (RegionManager) context.getBean("regionManager");
        System.out.println("===============================================");
        System.out.println(regionManager.getNumber());
        System.out.println("===============================================");
        regionManager.createRegion("SPB");
    }

    private static void afterReturnAspect(ApplicationContext context) {
        RegionManager regionManager = (RegionManager) context.getBean("regionManager");
        System.out.println("===============================================");
        System.out.println(regionManager.getNumber());
        System.out.println("===============================================");
        regionManager.createRegion("SPB");
    }

    private static void afterThrowAspect(ApplicationContext context) {
        RegionManager regionManager = (RegionManager) context.getBean("regionManager");
        System.out.println("===============================================");
        System.out.println(regionManager.getNumber());
        System.out.println("===============================================");
        regionManager.createRegion(null);
    }

    private static void aroundAspect(ApplicationContext context) {
        RegionManager regionManager = (RegionManager) context.getBean("regionManager");
        System.out.println("===============================================");
        System.out.println(regionManager.getNumber());
        System.out.println("===============================================");
        regionManager.createRegion("SPB");
    }

}
