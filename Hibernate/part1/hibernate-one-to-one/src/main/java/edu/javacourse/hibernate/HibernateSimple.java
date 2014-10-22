package edu.javacourse.hibernate;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Простой пример работы со связанными таблицами
 * 
 * @author ASaburov
 */
public class HibernateSimple {

    public static void main(String[] args) {
        HibernateSimple hs = new HibernateSimple();

        Session s = hs.getSessionFactory().openSession();
        s.beginTransaction();
        List<Region> regionList = s.createQuery("from Region").list();
        
        for(Region r : regionList) {
            System.out.println("Region name:" + r);
            System.out.println("Gubernator name:" + r.getGubernator().getLeader());

        }


        Region spb = new Region("SPb");
        Gubernator gubernator = new Gubernator("Poltavchenko");

        spb.setGubernator(gubernator);
        gubernator.setRegion(spb);

        s.save(spb);


        regionList = s.createQuery("from Region").list();

        for(Region r : regionList) {
            System.out.println("Region name:" + r);
            System.out.println("Gubernator name:" + r.getGubernator().getLeader());

        }


        s.getTransaction().commit();
    }

    private SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}
