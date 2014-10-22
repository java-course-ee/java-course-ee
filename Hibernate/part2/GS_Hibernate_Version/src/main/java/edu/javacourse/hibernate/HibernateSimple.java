package edu.javacourse.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Пример работы с версионной системой
 *
 * @author ASaburov
 */
public class HibernateSimple {

    public static void main(String[] args) {
        HibernateSimple hs = new HibernateSimple();

        Session s = hs.getSessionFactory().getCurrentSession();
        s.beginTransaction();

        List<Region> regionList = s.createQuery("from Region").list();
        for (Region r : regionList) {
            System.out.println("Region name:" + r.getRegionId() + ", " + r.getRegionName() + " " + r.getVersion());
            r.setRegionName(r.getRegionName() + " new");
        }
        System.out.println("=================");
        Region region = new Region();
        region.setRegionName("Saint-Petersburg");
        s.save(region);
        System.out.println("=================");
        regionList = s.createQuery("from Region").list();
        for (Region r : regionList) {
            System.out.println("Region name:" + r.getRegionId() + ", " + r.getRegionName() + " " + r.getVersion());
        }
        s.getTransaction().commit();
    }

    private SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}
