package edu.javacourse.dwr.dao;

import java.io.Serializable;
import java.util.List;

import edu.javacourse.dwr.dao.entity.Region;
import org.hibernate.SessionFactory;

/**
 *
 * @author ASaburov
 */

public class RegionDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Serializable addEntity(Region region) {
        return sessionFactory.getCurrentSession().save(region);
    }

    public void deleteEntity(Region region) {
        sessionFactory.getCurrentSession().delete(region);
    }

    public Region getEntity(Long regionId) {
        return (Region) sessionFactory.getCurrentSession().get(Region.class, regionId);
    }

    public List<Region> findregion() {
        return sessionFactory.getCurrentSession().createCriteria(Region.class).list();
    }
}
