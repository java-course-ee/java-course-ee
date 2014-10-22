package edu.javacourse.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author ASaburov
 */
public class HibernateSimple {

    public static void main(String[] args) {
        HibernateSimple hs = new HibernateSimple();

        Session s = hs.getSessionFactory().getCurrentSession();
        s.beginTransaction();

//        List<User> userList = s.createQuery("from User").list();
//        for(User user : userList) {
//            System.out.println("User:" + user);
//        }
//
//        User newUser = new User();
//        newUser.setMiddleName("Nikolaevich");
//        newUser.setUserId(new UserId("Alexey", "Sidorov"));
//        s.save(newUser);
//
//        System.out.println();
//        userList = s.createQuery("from User").list();
//        for(User user : userList) {
//            System.out.println("User:" + user);
//        }


        User withAddress = new User();
        withAddress.setMiddleName("Ivanovich");
        withAddress.setUserId(new UserId("Ivan", "Ivanov"));


        Address address = new Address();
        address.setStreet("Pobedy");
        address.setHouse(45);

        withAddress.setAddress(address);
        s.save(withAddress);


        s.getTransaction().commit();
    }

    private SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}
