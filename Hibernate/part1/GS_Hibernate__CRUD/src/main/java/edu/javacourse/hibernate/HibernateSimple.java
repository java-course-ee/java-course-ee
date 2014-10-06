package edu.javacourse.hibernate;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.EmptyInterceptor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.Type;

/**
 * Простой пример для interceptor
 *
 * @author ASaburov
 * @author Georgy Gobozov
 */
public class HibernateSimple {

    static HibernateSimple hs = new HibernateSimple();

    static Serializable id = null;

    public static void main(String[] args) {
        create();
        createAutocommit();

        get();
        load();

        getVsLoad();

        update();
        delete();

    }

    private static void create() {
        System.out.println("==============CREATE=================");
        // Create hibernate session
        Session session = hs.getSessionFactory(false).openSession();
        // begin transaction
        session.beginTransaction();
        // create object
        Region region = new Region("Saint-Petersburg!");
        //save object
        session.save(region);
        session.getTransaction().commit();
        session.close();
    }


    private static void createAutocommit() {
        System.out.println("==============AUTOCOMMIT=================");
        // Create hibernate session
        Session session = hs.getSessionFactory(true).openSession();
        // create object
        Region region = new Region("HMAO");
        //save object
        id = session.save(region);
        System.out.println("id = " + id);
        session.flush();
        session.close();

    }


    private static void get() {
        System.out.println("==============GET=================");
        Session session = hs.getSessionFactory(false).openSession();
        session.beginTransaction();
        Region region = (Region) session.get(Region.class, id);
        System.out.println("region = " + region);
        session.getTransaction().commit();
        session.close();
    }

    private static void load() {
        System.out.println("==============LOAD=================");
        Session session = hs.getSessionFactory(false).openSession();
        session.beginTransaction();
        Region region = (Region) session.load(Region.class, id);
        System.out.println("region = " + region);
        session.getTransaction().commit();
        session.close();
    }


    private static void getVsLoad() {
        System.out.println("==============GET_VS_LOAD=================");
        Session session = hs.getSessionFactory(false).openSession();
        session.beginTransaction();
        Region region = (Region) session.get(Region.class, id);
        City city1 = new City();
        city1.setCityName("Surgut");
        city1.setRegion(region);
        session.save(city1);

        region = (Region) session.load(Region.class, id);
        City city2 = new City();
        city2.setCityName("Nizhnevartovsk");
        city2.setRegion(region);
        id = session.save(city2);


        session.getTransaction().commit();
        session.close();

    }

    private static void update() {
        System.out.println("==============UPDATE=================");
        Session session = hs.getSessionFactory(false).openSession();
        session.beginTransaction();
        City city = (City) session.load(City.class, id);
        city.setCityName("nefteugansk");
        session.saveOrUpdate(city);
        System.out.println("city = " + city);

        session.getTransaction().commit();
        session.close();

    }


    private static void delete() {
        System.out.println("==============DELETE=================");
        Session session = hs.getSessionFactory(false).openSession();
        session.beginTransaction();
        City city = (City) session.load(City.class, id);

        session.delete(city);

        session.getTransaction().commit();
        session.close();

    }



    private SessionFactory getSessionFactory(boolean isAutocommitCfg) {
        Configuration cfg = new Configuration();
        return isAutocommitCfg ? cfg.configure("hibernate.cfg.autocommit.xml").buildSessionFactory() : cfg.configure().buildSessionFactory();
    }
}
