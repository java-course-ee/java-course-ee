package edu.javacourse.hibernate;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class HibernateCriteria {

    private static final Logger log = LoggerFactory.getLogger(HibernateCriteria.class);

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

        Session s = sessionFactory.getCurrentSession();
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
            log.info("region: {}", r);
        }

        log.info("===============================================================");

        Criteria criteria2 = s.createCriteria(Catalog.class);

        //criteria2.add(Restrictions.like("catalogName", "%second%").ignoreCase());
        //criteria2.add(Restrictions.gt("catalogId", new Long(5)));
        //criteria2.add(Restrictions.lt("catalogId", new Long(12)));

        //criteria2.add(Restrictions.isNotNull("parent"));

        criteria2.add(Restrictions.isNull("parent"));


        List<Catalog> catalogs2 = criteria2.list();
        for (Catalog catalog : catalogs2) {
            log.info("catalog: {}", catalog);
        }

        log.info("===============================================================");

        Criteria criteria3 = s.createCriteria(Catalog.class);
        criteria3.add(Restrictions.eq("parent.catalogId", new Long(5)));
        criteria3.add(Restrictions.le("catalogId", new Long(10)));   // less or equals


        List<Catalog> catalogs3 = criteria3.list();
        for (Catalog catalog : catalogs3) {
            log.info("catalog: {}", catalog);
        }


        s.getTransaction().commit();

        destroy();
    }

}
