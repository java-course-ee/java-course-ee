package com.geminisystems.subscription.dao;

import com.geminisystems.subscription.domain.SCategory;
import com.geminisystems.subscription.domain.SPath;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 05.12.2011
 * Time: 15:09:42
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    protected HibernateTemplate ht;

    public SCategory create(SCategory category) {
        ht.save(category);
        return category;
    }

    public void update(SCategory category) {
        ht.saveOrUpdate(category);
    }

    public List<SCategory> getAll() {
        List<SCategory> cats = ht.loadAll(SCategory.class);
        for (SCategory c : cats) {
            Hibernate.initialize(c.getPaths());
        }
        return cats;
    }

    public void delete(SCategory category) {
        ht.delete(category);
    }

    public SCategory getById(Integer id) {
        SCategory category = ht.get(SCategory.class, id);
        if (category != null) {
            Hibernate.initialize(category.getPaths());
        }
        return category;
    }

    public SPath createPath(SPath path) {
        ht.save(path);
        return path;
    }
}
