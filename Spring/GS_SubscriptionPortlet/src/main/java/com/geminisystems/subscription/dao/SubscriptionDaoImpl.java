package com.geminisystems.subscription.dao;

import com.geminisystems.subscription.domain.SBean;
import com.geminisystems.subscription.domain.SType;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 05.12.2011
 * Time: 15:10:29
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public class SubscriptionDaoImpl implements SubscriptionDao {

    @Autowired
    protected HibernateTemplate ht;

    public SBean getByEmail(String email) {
        List<SBean> beans = (List<SBean>) ht.find("from SBean b where b.email = ?", email.toLowerCase());
        if (beans == null || beans.size() == 0) return null;
        return beans.get(0);
    }

    public SBean create(SBean bean) {
        bean.setEmail(bean.getEmail().toLowerCase());
        ht.save(bean);
        return bean;
    }

    public SBean update(SBean bean) {
        bean.setEmail(bean.getEmail().toLowerCase());
        ht.saveOrUpdate(bean);
        return bean;
    }

    public void delete(SBean bean) {
        ht.delete(bean);
    }

    public List<SBean> getAll() {
        return ht.loadAll(SBean.class);
    }

    public List<SBean> getAllActive(SType type) {

        // get all active subscriptors with subscription type = USERS
        Session session = ht.getSessionFactory().getCurrentSession();
        Query query = session.createQuery("from SBean b where b.isActive = true and b.type = :type");
        query.setParameter("type", type);
        List<SBean> beans = query.list();
        //return (List<SBean>) ht.find("from SBean b where b.isActive = true and b.type = SType.USERS");
        return beans;
    }
}
