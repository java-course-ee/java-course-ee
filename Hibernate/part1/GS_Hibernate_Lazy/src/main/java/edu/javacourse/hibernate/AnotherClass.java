package edu.javacourse.hibernate;

import java.util.List;

/**
 * Author: Georgy Gobozov
 * Date: 27.06.13
 */
public class AnotherClass {


    public static void printAgain(List<Region> regions) {
        System.out.println("======================================");
        for (Region r : regions) {
            System.out.println("Region name:" + r);
            List<City> cities = r.getCityList();
            for (City city : cities) {
                System.out.println("City name:" + city.getCityName());
            }
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        }
    }

}
