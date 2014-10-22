package edu.javacourse.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Простой пример работы с программно загружаемой конфигурацией и мапингом в виде XML
 *
 * @author ASaburov
 */
public class HibernateSimple {

    public static void main(String[] args) {
        HibernateSimple hs = new HibernateSimple();

        Session s = hs.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        List<Region> regionList = s.createQuery("from Region").list();
        s.getTransaction().commit();

        for (Region r : regionList) {
            System.out.println("Region name:" + r.getRegionName());
        }
    }

    private SessionFactory getSessionFactory() {
        Configuration cfg = new Configuration()
                // Добавление класса для Entity
                .addClass(edu.javacourse.hibernate.Region.class)
                        // Можно использовать и такой вариант добавления ресурса вместо addClass
                        //.addResource("edu/javacourse/hibernate/Region.hbm.xml")
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect")
                .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
                .setProperty("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/java_backend")
                .setProperty("hibernate.connection.username", "root")
                .setProperty("hibernate.connection.password", "root")
                .setProperty("hibernate.connection.pool_size", "1")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.current_session_context_class", "thread");
        return cfg.buildSessionFactory();
    }
}
