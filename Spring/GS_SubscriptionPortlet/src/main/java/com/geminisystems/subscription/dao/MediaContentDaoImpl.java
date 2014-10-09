package com.geminisystems.subscription.dao;

import com.geminisystems.subscription.domain.SMediaContent;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 27.08.2012
 * Time: 18:21:53
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public class MediaContentDaoImpl implements MediaContentDao{

     @Autowired
    protected HibernateTemplate ht;

    public List<SMediaContent> getAll() {
        return (List<SMediaContent>) ht.find("from SMediaContent");
    }

    public void deleteAll() {
        Session session = ht.getSessionFactory().getCurrentSession();
        Query query = session.createQuery("delete from SMediaContent");
        query.executeUpdate();
    }

     public void deleteAll(Collection entries) {
        ht.deleteAll(entries);
    }
}
