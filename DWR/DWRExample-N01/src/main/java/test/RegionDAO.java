package test;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASaburov
 */

@Repository
public class RegionDAO {

    private SessionFactory factory;

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    public Serializable addEntity(Region region) {
        return factory.getCurrentSession().save(region);
    }

    public void deleteEntity(Region region) {
        factory.getCurrentSession().delete(region);
    }

    public Region getEntity(Long regionId) {
        return (Region) factory.getCurrentSession().get(Region.class, regionId);
    }

    public List<Region> findregion() {
        return factory.getCurrentSession().createCriteria(Region.class).list();
    }
}
