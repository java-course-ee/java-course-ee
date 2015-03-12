package ru.expomap.test.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 01.12.2011
 * Time: 11:08:47
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public class AbstractDaoImpl<T> implements AbstractDao<T> {

    @Autowired
    protected HibernateTemplate ht;
    private Class<T> type;

    public AbstractDaoImpl(Class<T> type) {
        this.type = type;
    }

    public T getById(Integer id) {
        return ht.get(type, id);
    }

    public List<T> findAll() {
        return ht.loadAll(type);
    }

    public T create(T entyty) {
        ht.save(entyty);
        return entyty;
    }

    public T update(T entity) {
        ht.getSessionFactory().getCurrentSession().clear();
        ht.saveOrUpdate(entity);
        return entity;
    }

    public void delete(T entity) {
        ht.delete(entity);
    }
}
