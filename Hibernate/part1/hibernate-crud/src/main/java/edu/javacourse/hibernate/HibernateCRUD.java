package edu.javacourse.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * @author ASaburov
 * @author Georgy Gobozov
 */
public class HibernateCRUD {

    private static final Logger log = LoggerFactory.getLogger(HibernateCRUD.class);

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

    static Serializable id = null;

    public static void main(String[] args) {
        init();

        create();

        get();
        load();

        getVsLoad();

        update();
        delete();

        destroy();
    }

    private static void create() {
        log.info("==============CREATE=================");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Region region = new Region("Saint-Petersburg!");
        session.save(region);
        session.getTransaction().commit();
        id = region.getRegionId();
    }

    private static void get() {
        log.info("==============GET=================");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Region region = (Region) session.get(Region.class, id);
        log.info("region = {}", region);
        session.getTransaction().commit();
    }

    private static void load() {
        log.info("==============LOAD=================");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Region region = (Region) session.load(Region.class, id);
        log.info("region = {}", region);
        session.getTransaction().commit();
    }


    private static void getVsLoad() {
        log.info("==============GET_VS_LOAD=================");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Region region = (Region) session.get(Region.class, id);
        City city1 = new City();
        city1.setCityName("Surgut");
        city1.setRegion(region);
        session.save(city1);

        region = (Region) session.load(Region.class, id);
        City city2 = new City();
        city2.setCityName("Nizhnevartovsk");
        city2.setRegion(region);
        id = session.save(city2);

        session.getTransaction().commit();
    }

    private static void update() {
        log.info("==============UPDATE=================");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        City city = (City) session.load(City.class, id);
        city.setCityName("nefteugansk");
        session.saveOrUpdate(city);
        log.info("city = {}", city);

        session.getTransaction().commit();
    }


    private static void delete() {
        log.info("==============DELETE=================");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        City city = (City) session.load(City.class, id);

        session.delete(city);

        session.getTransaction().commit();
    }

}
