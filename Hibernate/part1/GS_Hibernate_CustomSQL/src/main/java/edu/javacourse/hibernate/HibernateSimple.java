package edu.javacourse.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.List;

/**
 * @author ASaburov
 */
public class HibernateSimple {

    public static void main(String[] args) {
        HibernateSimple hs = new HibernateSimple();

        SessionFactory sf = hs.getSessionFactory();

        Session s = sf.getCurrentSession();
        s.beginTransaction();

        // Получить список через SQL-запрос
        List<Region> regionList = s.createQuery("from Region").list();
        for (Region r : regionList) {
            System.out.println(r);
        }

        // Добавить через SQL-запрос
        Region newRegion = new Region();
        newRegion.setRegionName("Simple Region");
        Serializable id = s.save(newRegion);
        // Изменить через SQL-запрос
        regionList.get(0).setRegionName("Other Region");

        s = restartSession(s, sf);

        // Загрузить через SQL-запрос
        //Region load = (Region) s.get(Region.class, id);
        Region load = (Region) s.load(Region.class, id);

        // Удалить через SQL-запрос
        s.delete(load);

        s.getTransaction().commit();
    }

    // Рестарт сессии сделан для уничтожения кэша. Утилитарный вызов
    private static Session restartSession(Session s, SessionFactory sf) throws HibernateException {
        s.getTransaction().commit();
        s = sf.getCurrentSession();
        s.beginTransaction();
        return s;
    }

    private SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}
