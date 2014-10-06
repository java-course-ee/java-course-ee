package payment;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

public class PaymentDAO {

    public Serializable addPayment(Payment payment) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Serializable id = session.save(payment);
        session.getTransaction().commit();
        return id;
    }

    public void deletePayment(Payment payment) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(payment);
        session.getTransaction().commit();
    }

    public void deleteAllPayment() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM Payment").executeUpdate();
        session.getTransaction().commit();
    }

    public List<Payment> findPayment() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Payment> result = session.createQuery("from Payment").list();
        session.getTransaction().commit();
        return result;
    }

    public List<Payment> findPaymentPage() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("from Payment");
        q.setFirstResult(0);
        q.setMaxResults(10);
        List<Payment> result = q.list();
        session.getTransaction().commit();
        return result;
    }

    public List<Payment> findPaymentByAmount(Double amount) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.getNamedQuery("Payment.findByAmount");
        q.setDouble("amount", amount);
        return q.list();
    }

    public List<Double> findAmountOnly() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.getNamedQuery("Payment.findAmountOnly");
        return q.list();
    }

    public List<CashPayment> findCashPayment() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<CashPayment> result = session.createQuery("from CashPayment").list();
        session.getTransaction().commit();
        return result;
    }

    public List<ChequePayment> findChequePayment() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<ChequePayment> result = session.createQuery("from ChequePayment").list();
        session.getTransaction().commit();
        return result;
    }

    public List<CreditCardPayment> findCreditCardPayment() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<CreditCardPayment> result = session.createQuery("from CreditCardPayment").list();
        session.getTransaction().commit();
        return result;
    }

    public List findNativeSQL() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        return session.createSQLQuery("SELECT * FROM jc_payment")
                .addScalar("PAYMENT_ID")
                .addScalar("PAYMENT_TYPE")
                .addScalar("AMOUNT")
                .addScalar("CARD_NUMBER")
                .addScalar("CASH_DESK")
                .addScalar("BANK_ID")
                .list();
    }
}
