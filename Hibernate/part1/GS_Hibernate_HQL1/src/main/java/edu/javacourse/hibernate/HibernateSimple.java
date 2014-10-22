package edu.javacourse.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * @author Georgy Gobozov
 */
public class HibernateSimple {

    // http://docs.jboss.org/hibernate/orm/3.3/reference/en/html/queryhql.html

    public static void main(String[] args) {
        HibernateSimple hs = new HibernateSimple();

        Session s = hs.getSessionFactory().getCurrentSession();
        s.beginTransaction();


        test1(s);
        test2(s);
        test3(s);
        test4(s);
        test5(s);
        test6(s);
        s.getTransaction().commit();
    }

    // select all regions
    private static void test1(Session s) {

        Query q = s.createQuery("from Region");
        List<Region> regionList = q.list();
        for (Region r : regionList) {
            System.out.println("Region name:" + r);
        }
        System.out.println("======================================");

    }

    // select all regions with cities
    private static void test2(Session s) {

        Query q = s.createQuery("from Region order by regionName");
        List<Region> regionList = q.list();
        for (Region r : regionList) {
            System.out.println("Region name:" + r);
            for (City c : r.getCityList()) {
                System.out.println("     City name:" + c);
            }
        }
        System.out.println("======================================");
    }


    // select regions where id < 3
    private static void test3(Session s) {

        Query q = s.createQuery("from Region as r where r.regionId < 3");
        List<Region> regionList = q.list();
        for (Region r : regionList) {
            System.out.println("Region name:" + r);
        }
        System.out.println("======================================");
    }


    // select cities by region name
    private static void test4(Session s) {

//        Query namedQuery = s.getNamedQuery("Region.MyQueryName");


        Query q = s.createQuery("from City c where c.region.regionName=:n");
        q.setParameter("n", "Moscow");

        List<City> cityList = q.list();
        for (City c : cityList) {
            System.out.println("City :" + c);
        }
        System.out.println("======================================");
    }

    // select cities order by
    private static void test5(Session s) {

        Query q = s.createQuery("from City c  ORDER BY c.cityName");

        List<City> cityList = q.list();
        for (City c : cityList) {
            System.out.println("City :" + c);
        }
        System.out.println("======================================");
    }

    // select cities order by
    private static void test6(Session s) {

        Query q = s.createQuery("from Region r  where r.cityList  is empty");

        List<Region> regionList = q.list();
        for (Region r : regionList) {
            System.out.println("Region name:" + r);
        }
        System.out.println("======================================");
    }


    private SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}
