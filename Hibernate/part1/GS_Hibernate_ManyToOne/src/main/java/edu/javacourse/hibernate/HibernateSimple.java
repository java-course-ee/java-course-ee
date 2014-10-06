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

        Session s = hs.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        List<Region> regionList = s.createCriteria(Region.class).list();
        
        for(Region r : regionList) {
            System.out.println("Region name:" + r);
            for(City c : r.getCityList()) {
                System.out.println("     City name:" + c);
            }
        }

//        Region spb = new Region("SPb");
//        s.save(spb);
//
//        City gatchina = new City();
//        gatchina.setCityName("Gatchina");
//        gatchina.setRegion(spb);
//        s.save(gatchina);
//
//        City pushkin = new City();
//        pushkin.setCityName("Pushkin");
//        pushkin.setRegion(spb);
//        s.save(pushkin);

        s.getTransaction().commit();
    }

    private SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}
