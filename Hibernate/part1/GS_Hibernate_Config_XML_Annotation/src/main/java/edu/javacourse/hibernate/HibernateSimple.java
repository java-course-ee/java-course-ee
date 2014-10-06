package edu.javacourse.hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Простой пример для конфигурации в виде XML
 * 
 * @author ASaburov
 */
public class HibernateSimple {

    public static void main(String[] args) {
        HibernateSimple hs = new HibernateSimple();

        SessionFactory sessionFactory = hs.getSessionFactory();
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();

        List<Region> regionList = s.createCriteria(Region.class).list();
        for (Region r : regionList) {
            System.out.println(r);
        }

        s.getTransaction().commit();
    }

    private SessionFactory getSessionFactory() {
//        return new Configuration().configure().buildSessionFactory();
        Configuration configuration = new Configuration();
        configuration = configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }
}
