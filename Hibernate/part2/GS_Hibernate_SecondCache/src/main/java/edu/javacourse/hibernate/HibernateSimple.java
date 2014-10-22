package edu.javacourse.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Простой пример для конфигурации в виде XML
 *
 * @author ASaburov
 */
public class HibernateSimple {

    public static void main(String[] args) {
        HibernateSimple hs = new HibernateSimple();
        hs.testCache();
    }

    private void testCache() {
        SessionFactory sessionFactory = getSessionFactory();

        // Делаем дважды для демонстрации - SELECT вызывается один раз или два
        // в зависимости от настроек кэша
        checkQuery(sessionFactory);
        checkQuery(sessionFactory);

        // Делаем дважды для демонстрации - SELECT вызывается один раз или два
        // в зависимости от настроек кэша
        checkOne(sessionFactory);
        checkOne(sessionFactory);

        // Обращение к статистике только при включенном кэше
        showStatistics(sessionFactory);
    }

    private void checkQuery(SessionFactory sessionFactory) throws HibernateException {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query createQuery = session.createQuery("from Region");
        // Если не ставить кэширование, то запрос будет дважды
        // И обязательно в hibernate.cfg.xml дожно быть установлено 
        // <property name="cache.use_query_cache">true</property>
        // Если включить без кэша - то интересный эффект
        createQuery.setCacheable(true);
        List<Region> regionList1 = createQuery.list();
        for (Region r : regionList1) {
            System.out.println(r);
        }
        session.getTransaction().commit();
    }

    private void checkOne(SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Region r = (Region) session.get(Region.class, 1L);
        System.out.println("Region:" + r);
        session.getTransaction().commit();
    }

    private void showStatistics(SessionFactory sessionFactory) {
        if (sessionFactory.getStatistics().getSecondLevelCacheStatistics("CacheForRegion") != null) {
            Map ce = sessionFactory.getStatistics().getSecondLevelCacheStatistics("CacheForRegion").getEntries();

            for (Iterator en = ce.keySet().iterator(); en.hasNext(); ) {
                Object key = en.next();
                Object value = ce.get(key);
                System.out.println("Key:" + key);
                System.out.println("Value:" + value);
            }
        } else {
            System.out.println("No statistics for second level");
        }
    }

    private SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}
