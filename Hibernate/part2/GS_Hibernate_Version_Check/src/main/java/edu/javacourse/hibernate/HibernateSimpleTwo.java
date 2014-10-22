package edu.javacourse.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

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
        System.out.println("Region name before:" + region.getRegionName() + ", version: " + region.getVersion());
        region.setRegionName("Saint-Petersburg " + System.currentTimeMillis());
        s.save(region);
        s.flush();
        System.out.println("Region name after:" + region.getRegionName() + ", version: " + region.getVersion());

        s.getTransaction().commit();
    }

    private SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}
