package edu.javacourse.hibernate;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class HibernateSimple {

    public static void main(String[] args) {
        HibernateSimple hs = new HibernateSimple();

        Session s = hs.getSessionFactory().getCurrentSession();
        s.beginTransaction();

        Criteria criteria1 = s.createCriteria(Region.class)
                .add(Restrictions.or(
                        Restrictions.like("regionName", "Region=region%"),
                        Restrictions.or(
                                Restrictions.like("regionName", "Region=A%"),
                                Restrictions.like("regionName", "Region=M%")
                        )))
                .addOrder(Order.asc("regionName"));

        criteria1.setMaxResults(50);
        List<Region> regions = criteria1.list();

        for (Region r : regions) {
            System.out.println(r);
        }

        System.out.println("===============================================================");

        Criteria criteria2 = s.createCriteria(Catalog.class);

        //criteria2.add(Restrictions.like("catalogName", "%second%").ignoreCase());
        //criteria2.add(Restrictions.gt("catalogId", new Long(5)));
        //criteria2.add(Restrictions.lt("catalogId", new Long(12)));

        //criteria2.add(Restrictions.isNotNull("parent"));

        criteria2.add(Restrictions.isNull("parent"));


        List<Catalog> catalogs2 = criteria2.list();
        for (Catalog catalog : catalogs2) {
            System.out.println(catalog);
        }

        System.out.println("===============================================================");

        Criteria criteria3 = s.createCriteria(Catalog.class);
        criteria3.add(Restrictions.eq("parent.catalogId", new Long(5)));
        criteria3.add(Restrictions.le("catalogId", new Long(10)));   // less or equals


        List<Catalog> catalogs3 = criteria3.list();
        for (Catalog catalog : catalogs3) {
            System.out.println(catalog);
        }


        s.getTransaction().commit();
    }

    private SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}
