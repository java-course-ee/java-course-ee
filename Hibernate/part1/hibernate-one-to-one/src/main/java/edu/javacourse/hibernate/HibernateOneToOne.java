package edu.javacourse.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Простой пример работы со связанными таблицами
 *
 * @author ASaburov
 */
public class HibernateOneToOne {

    private static final Logger log = LoggerFactory.getLogger(HibernateOneToOne.class);

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    private static void init() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    private static void destroy() {
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }

    public static void main(String[] args) {
        init();

        Session s = sessionFactory.openSession();
        s.beginTransaction();
        List<Region> regionList = s.createQuery("from Region").list();

        for (Region r : regionList) {
            System.out.println("Region name:" + r);
            System.out.println("Gubernator name:" + r.getGubernator().getName());
        }

        Region spb = new Region("SPb");
        Gubernator gubernator = new Gubernator("Poltavchenko");

        spb.setGubernator(gubernator);
        gubernator.setRegion(spb);

        s.save(spb);

        regionList = s.createQuery("from Region").list();

        for (Region r : regionList) {
            System.out.println("Region name:" + r);
            System.out.println("Gubernator name:" + r.getGubernator().getName());

        }

        s.getTransaction().commit();

        log.debug("Transaction committed");

        destroy();
    }

}
