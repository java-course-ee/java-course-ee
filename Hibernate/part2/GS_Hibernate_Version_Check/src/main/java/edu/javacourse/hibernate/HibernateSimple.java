package edu.javacourse.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

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
            Thread.sleep(20000);
        } catch (Exception e) {
        }

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
