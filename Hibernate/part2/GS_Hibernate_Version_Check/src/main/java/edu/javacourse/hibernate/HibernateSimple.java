package edu.javacourse.hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Простой пример работы с вариантом версий
 * После запуска программа зависнет на 10 секунд.
 * В этот момент запустить класс HibernateSimpleTwo,
 * который изменит первую запись и увеличит ее версию.
 * И после этого наща программа выкинет исключение
 * 
 * @author ASaburov
 */
public class HibernateSimple {
    
    public static void main(String[] args) {
        HibernateSimple hs = new HibernateSimple();
        
        Session s = hs.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        
        List<Region> regionList = s.createQuery("from Region").list();
        
        // Остановим процесс на 10 секунд (можно запустить SimpleHibernateTwo
        try {
            Thread.sleep(10000);
        } catch(Exception e) {
        }
        
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
