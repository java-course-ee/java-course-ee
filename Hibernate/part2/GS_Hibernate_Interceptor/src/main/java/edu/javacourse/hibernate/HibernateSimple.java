package edu.javacourse.hibernate;

import org.hibernate.EmptyInterceptor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/**
 * Простой пример для interceptor
 *
 * @author ASaburov
 * @author Georgy Gobozov
 */
public class HibernateSimple {

    private static int loads = 0;

    public static void main(String[] args) {
        HibernateSimple hs = new HibernateSimple();

        // В этом вызове для открытия сессии мы создаем интерсептор
        Session s = hs.getSessionFactory().openSession(new SimpleInterceptor());

        s.beginTransaction();

        List<Region> regionList = s.createQuery("from Region").list();
        for (Region r : regionList) {
            System.out.println(r);
        }
        System.out.println("LOADS:" + loads);

        Region deleteMeRegion = new Region("Delete me!");
        s.save(deleteMeRegion);

        s.delete(deleteMeRegion);

        s.getTransaction().commit();
        s.close();
    }

    private SessionFactory getSessionFactory() {
        Configuration cfg = new Configuration();
        return cfg.configure().buildSessionFactory();
    }

    // Вариант объявления интерсептора - наследуемся от самого простого
    // готового класса. Иначе можно реализовать свой интерсептор от интерфейса Interceptor
    private static class SimpleInterceptor extends EmptyInterceptor {

        @Override
        public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
            System.out.println("Interceptor: ON_LOAD");
            HibernateSimple.loads++;
            return false;
        }

        @Override
        public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
            System.out.println("Interceptor: ON_DELETE");
        }

        @Override
        public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
            System.out.println("Interceptor: ON_FLUSHDIRTY");
            return false;
        }

        @Override
        public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
            System.out.println("Interceptor: ON_SAVE");
            return super.onSave(entity, id, state, propertyNames, types);
        }


        //called after committed into database
        @Override
        public void postFlush(Iterator entities) {
            System.out.println("Interceptor: ON_POSTFLUSH");
        }

        //called before commit into database
        @Override
        public void preFlush(Iterator entities) {
            System.out.println("Interceptor: ON_PREFLUSH");
        }

        @Override
        public void afterTransactionBegin(Transaction tx) {
            System.out.println("Interceptor: ON_TRANSACTION_BEGIN");
            super.afterTransactionBegin(tx);
        }

        @Override
        public void afterTransactionCompletion(Transaction tx) {
            System.out.println("Interceptor: ON_TRANSACTION_COMPLETE");
            super.afterTransactionCompletion(tx);
        }
    }
}
