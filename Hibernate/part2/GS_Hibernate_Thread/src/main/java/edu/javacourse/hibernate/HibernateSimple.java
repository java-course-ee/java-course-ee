package edu.javacourse.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Пример для демонстрации работы пула коннектов для большого количества Session
 * Также можно посмотреть увеличение производительности при отключении "show_sql"
 * 
 * @author ASaburov
 */
public class HibernateSimple {

    public static void main(String[] args) {
        HibernateSimple hs = new HibernateSimple();

        SessionFactory sessionFactory = hs.getSessionFactory();
        for (int i = 0; i < 3000; i++) {
            MyThread m = new MyThread(sessionFactory);
            m.start();
        }
    }

    private SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}

class MyThread extends Thread {

    private SessionFactory sf;

    public MyThread(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public void run() {
        Session s1 = sf.openSession();
        s1.beginTransaction();
        s1.createQuery("from Region").list();
        s1.getTransaction().commit();
       // s1.close();
    }
}