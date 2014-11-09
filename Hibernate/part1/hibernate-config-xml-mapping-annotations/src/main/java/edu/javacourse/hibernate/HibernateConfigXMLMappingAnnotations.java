package edu.javacourse.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Простой пример для конфигурации в виде XML
 *
 * @author ASaburov
 */
public class HibernateConfigXMLMappingAnnotations {

    private static final Logger log = LoggerFactory.getLogger(HibernateConfigXMLMappingAnnotations.class);

    public static void main(String[] args) {
        HibernateConfigXMLMappingAnnotations hs = new HibernateConfigXMLMappingAnnotations();

        SessionFactory sessionFactory = hs.getSessionFactory();
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();

        s.save(new Region("Krasnoe Selo " + System.nanoTime()));

        List<Region> regionList = s.createQuery("from Region").list();
        for (Region r : regionList) {
            System.out.println(r);
        }

        s.getTransaction().commit();

        log.debug("Transaction committed");
    }

    private SessionFactory getSessionFactory() {

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory(
                new StandardServiceRegistryBuilder()
                        .applySettings( configuration.getProperties() )
                        .build()
        );
        return sessionFactory;

    }
}
