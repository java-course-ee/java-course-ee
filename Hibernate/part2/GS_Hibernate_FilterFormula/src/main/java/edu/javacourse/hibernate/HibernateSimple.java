package edu.javacourse.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Простой пример для конфигурации в виде XML
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
            System.out.println(r);
        }

        System.out.println();
        System.out.println("Filter for RegionId applied:");
        s.enableFilter("filterRegionId").setParameter("minId", 2);
        regionList = s.createQuery("from Region").list();
        for (Region r : regionList) {
            System.out.println(r);
        }

        System.out.println();
        System.out.println("Formula demo:");
        s.disableFilter("filterRegionId");
        // Обратить внимание, что вычисляемая строка прекрасно используется в разделе WHERE
//        regionList = s.createQuery("from Region where formula like '%other%' and complexFormula=1").list();
//        for(Region r : regionList) {
//            System.out.println(r);
//            System.out.println("Fields:" + r.getFullName() + " " + r.getComplexFormula());
//            System.out.println("Cities count:" + r.getCitiesCount());
//        }

        regionList = s.createQuery("from Region").list();
        for (Region r : regionList) {
            System.out.println(r);
            System.out.println("Cities count:" + r.getCitiesCount());
            System.out.println("Full Name :" + r.getFullName());
            System.out.println("Even - Odd :" + (r.isEven() ? "Even" : "Odd"));
            System.out.println("=====================");
        }

        s.getTransaction().commit();
    }

    private SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}
