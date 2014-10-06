package edu.javacourse.hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Простой пример работы с программно загружаемой конфигурацией и мапингом в виде XML
 * 
 * @author ASaburov
 */
public class HibernateSimple {

    public static void main(String[] args) {
        HibernateSimple hs = new HibernateSimple();

        Session s = hs.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        List<Region> regionList = s.createQuery("from Region").list();
        s.getTransaction().commit();
        
        for(Region r : regionList) {
            System.out.println("Region name:" + r.getRegionName());
        }
    }

    private SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}
