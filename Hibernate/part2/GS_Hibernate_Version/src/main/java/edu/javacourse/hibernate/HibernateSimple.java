package edu.javacourse.hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
            System.out.println("Region name:" + r.getRegionName() + " " + r.getVersion());
            r.setRegionName(r.getRegionName() + " new");
        }
        
        Region region = new Region();
        region.setRegionName("Saint-Petersburg");
        s.save(region);

        regionList = s.createQuery("from Region").list();
        for (Region r : regionList) {
            System.out.println("Region name:" + r.getRegionName() + " " + r.getVersion());
        }
        s.getTransaction().commit();
    }
    
    private SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}
