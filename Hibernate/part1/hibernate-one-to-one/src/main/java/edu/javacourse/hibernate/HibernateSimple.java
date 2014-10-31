package edu.javacourse.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Простой пример работы со связанными таблицами
 *
 * @author ASaburov
 */
public class HibernateSimple {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

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
    }

}
