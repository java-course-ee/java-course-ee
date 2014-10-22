package edu.javacourse.hibernate;

import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Простой пример для interceptor
 *
 * @author ASaburov
 * @author Georgy Gobozov
 */
public class HibernateSimple {


    public static void main(String[] args) {
        HibernateSimple hs = new HibernateSimple();
        Session session = hs.getSessionFactory(false).openSession();
        // begin transaction
        session.beginTransaction();

        SQLQuery q = session.createSQLQuery("select * from jc_region");
        q.addEntity(Region.class);
        List<Region> regionList = (List<Region>) q.list();
        for (Region region : regionList) {
            System.out.println("region = " + region);
        }

        q = session.createSQLQuery("select * from jc_region where region_name = 'Moscow'");
        q.addEntity(Region.class);
        Region region = (Region) q.uniqueResult();
        System.out.println("region = " + region);

        q = session.createSQLQuery("select * from jc_region where region_name=:name");
        q.addEntity(Region.class);
        q.setParameter("name", "Voronezh");
        region = (Region) q.uniqueResult();
        System.out.println("region = " + region);


        q = session.createSQLQuery("select * from jc_city where region_id=:reg");
        q.addEntity(City.class);
        q.setParameter("reg", region.getRegionId());
        List<City> cities = (List<City>) q.list();
        for (City city : cities) {
            System.out.println("city = " + city);
        }
    }


    private SessionFactory getSessionFactory(boolean isAutocommitCfg) {
        Configuration cfg = new Configuration();
        return isAutocommitCfg ? cfg.configure("hibernate.cfg.autocommit.xml").buildSessionFactory() : cfg.configure().buildSessionFactory();
    }
}
