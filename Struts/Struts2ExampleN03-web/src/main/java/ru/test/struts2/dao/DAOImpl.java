package ru.test.struts2.dao;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import ru.test.struts2.entity.AbstractEntity;
import ru.test.struts2.entity.Person;

import java.util.List;

/**
 * @author APronchakov <artem.pronchakov@gmail.com>
 */
public class DAOImpl extends HibernateDaoSupport implements DAO {
    private Logger log = Logger.getLogger(DAOImpl.class);

    @Override
    public <T extends AbstractEntity> T save(T entity, boolean evict) {
        entity.setId((Long) getHibernateTemplate().save(entity));
        getHibernateTemplate().flush();
        if (evict) {
            getHibernateTemplate().evict(entity);
        }
        return entity;
    }

    @Override
    public <T extends AbstractEntity> T update(T entity, boolean evict) {
        entity = getHibernateTemplate().merge(entity);
        getHibernateTemplate().flush();
        if (evict) {
            getHibernateTemplate().evict(entity);
        }
        return entity;
    }

    @Override
    public <T extends AbstractEntity> T get(Class<T> type, Long id, boolean readonly) {
        T entity = (T) getHibernateTemplate().get(type, id);
        if (readonly) {
            getHibernateTemplate().evict(entity);
        }
        return entity;
    }

    @Override
    public <T extends AbstractEntity> void delete(T entity) {
        getHibernateTemplate().delete(entity);
    }

    @Override
    public List<Person> findAllPersons(boolean readonly) {
        List<Person> list = getHibernateTemplate().findByNamedQuery("Person.findAll");
        if (readonly) {
            for (Person p : list) {
                getHibernateTemplate().evict(p);
            }
        }
        return list;
    }
}
