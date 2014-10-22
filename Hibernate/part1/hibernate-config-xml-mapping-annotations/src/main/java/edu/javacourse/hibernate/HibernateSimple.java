package edu.javacourse.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;

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

        List<Region> regionList = s.createQuery("from Region").list();
        for (Region r : regionList) {
            System.out.println(r);
        }

        s.getTransaction().commit();

    }

    private SessionFactory getSessionFactory() {

        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory(
                new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry());
        return sessionFactory;

    }
}
