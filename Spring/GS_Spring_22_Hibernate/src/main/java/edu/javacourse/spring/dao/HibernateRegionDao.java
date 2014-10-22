package edu.javacourse.spring.dao;

import edu.javacourse.spring.model.Region;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Author: Georgy Gobozov
 * Date: 22.07.13
 */
@Repository
public class HibernateRegionDao implements RegionDao {

    @Autowired
    SessionFactory sFactory;

    @Override
    public Integer createRegion(Region region) {
        Integer r = (Integer) sFactory.getCurrentSession().save(region);
        return r;
    }

    @Override
    public void deleteRegion(Region region) {
        sFactory.getCurrentSession().delete(region);
    }

    @Override
    public Region getRegionByName(String name) {
        Query query = sFactory.getCurrentSession().createQuery("from Region r where r.name = ?");
        query.setParameter(0, name);
        return (Region) query.uniqueResult();
    }
}
