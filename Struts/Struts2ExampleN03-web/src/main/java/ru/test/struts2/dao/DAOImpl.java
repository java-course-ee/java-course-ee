package ru.test.struts2.dao;

//import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.test.struts2.entity.AbstractEntity;
import ru.test.struts2.entity.Person;

import java.util.List;

/**
 * @author APronchakov <artem.pronchakov@gmail.com>
 */
public class DAOImpl  implements DAO {
//    private Logger log = Logger.getLogger(DAOImpl.class);

    @Autowired
    SessionFactory sessionFactory;

    private Session getHibernateTemplate() {
        return sessionFactory.getCurrentSession();
    }

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
        entity = (T) getHibernateTemplate().merge(entity);
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
        List<Person> list = getHibernateTemplate().getNamedQuery("Person.findAll").list();
        if (readonly) {
            for (Person p : list) {
                getHibernateTemplate().evict(p);
            }
        }
        return list;
    }
}
