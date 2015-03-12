package edu.javacourse.webservice;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.jws.WebService;
import java.util.List;

/**
 * Author: Georgy Gobozov
 * Date: 14.07.13
 */
@WebService(endpointInterface = "edu.javacourse.webservice.RegionService")
public class RegionServiceImpl implements RegionService {

    private static SessionFactory sessionFactory;

    static {
        sessionFactory = getSessionFactory();
    }

    private static SessionFactory getSessionFactory() {
        Configuration cfg = new Configuration();
        return cfg.configure().buildSessionFactory();
    }

    public Region[] getAllRegions() {
        Session session = sessionFactory.openSession();
        List<Region> regionList = session.createQuery("from Region").list();
        return regionList.toArray(new Region[]{});
    }

    public Region getRegionByName(String name) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Region r where r.regionName =:name");
        query.setParameter("name", name);
        Region region = (Region) query.uniqueResult();
        return region;
    }

    public Region sayHello(String name) {
        return new Region("test");
    }

}
