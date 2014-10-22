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

        Session s = hs.getSessionFactory().openSession();
        s.beginTransaction();

        Query q = s.createQuery("from Region");
        List<Region> regionList = q.list();
        for (Region r : regionList) {
            System.out.println("Region name:" + r);
            System.out.println("Cities size:" + r.getCityList().size());
        }
        System.out.println("======================================");
        s.flush();
        s.getTransaction().commit();
        s.close();


        // AnotherClass.printAgain(regionList); // uncomment this and comment this System.out.println("Cities size:" + r.getCityList().size());


    }


    private SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}
