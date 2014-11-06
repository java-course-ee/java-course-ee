package ru.test.struts2.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.test.struts2.entity.AbstractEntity;
import ru.test.struts2.entity.Person;

import java.util.List;

/**
 * @author artem.pronchakov@calisto.email
 */
public class DAOImpl implements DAO {
    private static final Logger log = LoggerFactory.getLogger(DAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public <T extends AbstractEntity> T save(T entity, boolean evict) {
        entity.setId((Long) getCurrentSession().save(entity));
        getCurrentSession().flush();
        if (evict) {
            getCurrentSession().evict(entity);
        }
        return entity;
    }

    @Override
    public <T extends AbstractEntity> T update(T entity, boolean evict) {
        entity = (T) getCurrentSession().merge(entity);
        getCurrentSession().flush();
        if (evict) {
            getCurrentSession().evict(entity);
        }
        return entity;
    }

    @Override
    public <T extends AbstractEntity> T get(Class<T> type, Long id, boolean readonly) {
        T entity = (T) getCurrentSession().get(type, id);
        if (readonly) {
            getCurrentSession().evict(entity);
        }
        return entity;
    }

    @Override
    public <T extends AbstractEntity> void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<Person> findAllPersons(boolean readonly) {
        List<Person> list = getCurrentSession().getNamedQuery("Person.findAll").list();
        if (readonly) {
            for (Person p : list) {
                getCurrentSession().evict(p);
            }
        }
        return list;
    }
}
