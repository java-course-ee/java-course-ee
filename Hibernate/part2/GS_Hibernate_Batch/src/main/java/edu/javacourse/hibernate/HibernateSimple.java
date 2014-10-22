package edu.javacourse.hibernate;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * Простой пример для interceptor
 *
 * @author ASaburov
 */
public class HibernateSimple {

    private static int loads = 0;

    public static void main(String[] args) {
        HibernateSimple hs = new HibernateSimple();

        Session s = hs.getSessionFactory().openSession();
        s.beginTransaction();

        for (int i = 0; i < 20000; i++) {
            Region r = new Region();
            r.setRegionName("region " + i);
            s.save(r);
            if (i % 20 == 0) {
                s.flush();
                s.clear();
            }
        }

        s.getTransaction().commit();
        s = hs.getSessionFactory().getCurrentSession();
        s.beginTransaction();

        ScrollableResults regionList = s.createQuery("from Region")
                .setCacheMode(CacheMode.IGNORE)
                .scroll(ScrollMode.FORWARD_ONLY);
        int count = 0;
        while (regionList.next()) {
            Region region = (Region) regionList.get(0);
            region.setRegionName(region.getRegionName() + System.currentTimeMillis());
            if (++count % 20 == 0) {
                s.flush();
                s.clear();
            }
        }
        s.getTransaction().commit();
    }

    private SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}
