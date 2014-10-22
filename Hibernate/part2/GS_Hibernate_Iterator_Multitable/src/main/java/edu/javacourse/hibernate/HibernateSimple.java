package edu.javacourse.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;

/**
 * Простой пример работы с итератором
 *
 * @author ASaburov
 */
public class HibernateSimple {

    public static void main(String[] args) {
        HibernateSimple hs = new HibernateSimple();

        Session s = hs.getSessionFactory().getCurrentSession();
        s.beginTransaction();

        // read
        Iterator<Region> regionIt = s.createQuery("from Region").iterate();
        while (regionIt.hasNext()) {
            Region r = regionIt.next();
            System.out.println("Region iterator:" + r);
        }


        //insert
        Region pskov = new Region("Pskov");
        pskov.setRegionLeader("Turchak");
        s.save(pskov);


        s.getTransaction().commit();
    }

    private SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}
