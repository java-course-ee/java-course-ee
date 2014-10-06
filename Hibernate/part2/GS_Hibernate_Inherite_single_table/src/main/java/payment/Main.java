package payment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Author: Georgy Gobozov
 * Date: 23.06.13
 */
public class Main {

    public static void main(String[] args) {


        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
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

        session.getTransaction().commit();
        session.close();

    }

}
