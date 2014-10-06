package edu.javacourse.hibernate;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.internal.SessionFactoryServiceRegistryFactoryImpl;

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
        
        Criteria criteria = s.createCriteria(City.class);
        List<City> cityList = criteria.list();
        
        for (City city: cityList) {
            System.out.println("city id: " + city.getCityId());
            System.out.println("city name: " + city.getCityName());
            System.out.println("city region id: " + city.getRegion().getRegionId());
            System.out.println("city region name: " + city.getRegion().getRegionName());
            System.out.println("");
        }
        
        
//        List<Region> regionList = s.createQuery("from Region").list();
        
//        for(Region r : regionList) {
//            System.out.println("Region name:" + r);
//            for(City c : r.getCityList()) {
//                System.out.println("     City name:" + c);
//            }
//        }


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
//
//        s.save(spb);



        s.getTransaction().commit();
    }

    private SessionFactory getSessionFactory() {
        Configuration cfg = new Configuration();
        return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().build());
    }
}
