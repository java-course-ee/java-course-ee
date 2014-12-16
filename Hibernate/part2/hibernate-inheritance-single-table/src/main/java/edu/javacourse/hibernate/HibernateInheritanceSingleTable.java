package edu.javacourse.hibernate;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Author: Georgy Gobozov
 * Date: 23.06.13
 */
public class HibernateInheritanceSingleTable {

    private static final Logger log = LoggerFactory.getLogger(HibernateInheritanceSingleTable.class);

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    private static void init() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    private static void destroy() {
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }

    public static void main(String[] args) {
        init();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Payment payment = new Payment();
        payment.setAmount(123.12);
        session.save(payment);

        CashPayment cashPayment = new CashPayment();
        cashPayment.setAmount(423.1);
        cashPayment.setCashDesk("super cash desk");
        session.save(cashPayment);

        ChequePayment chequePayment = new ChequePayment();
        chequePayment.setAmount(987.54);
        chequePayment.setBankId("VTB 24");
        session.save(chequePayment);

        CreditCardPayment cardPayment = new CreditCardPayment();
        cardPayment.setAmount(45.1);
        cardPayment.setCardNumber("1234567890");
        session.save(cardPayment);

        Criteria criteria = session.createCriteria(Payment.class);
        List<Payment> payments = criteria.list();

        for (Payment pay: payments) {
            log.info("Payment: class: {}, toString: {}", pay.getClass().getCanonicalName(), pay);
        }

        log.info("=========================================");

        criteria = session.createCriteria(CashPayment.class);
        payments = criteria.list();

        for (Payment pay: payments) {
            log.info("CashPayment: class: {}, toString: {}", pay.getClass().getCanonicalName(), pay);
        }

        session.getTransaction().commit();

        destroy();
    }

}
