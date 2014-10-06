package edu.javacourse.hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Второй класс для запуска и демонстрации работы с версиями
 * 
 * @author ASaburov
 */
public class HibernateSimpleTwo {
    
    public static void main(String[] args) {
        HibernateSimpleTwo hs = new HibernateSimpleTwo();
        
        Session s = hs.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        
        List<Region> regionList = s.createQuery("from Region").list();
        
        Region region = regionList.get(0);
        System.out.println("Region name before:" + region.getRegionName());
        region.setRegionName("Saint-Petersburg " + System.currentTimeMillis());
        s.save(region);
        System.out.println("Region name after:" + region.getRegionName());

        s.getTransaction().commit();
    }
    
    private SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}
