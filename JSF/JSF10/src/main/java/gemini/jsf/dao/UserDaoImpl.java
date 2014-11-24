package gemini.jsf.dao;

import gemini.jsf.entity.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author: Georgy Gobozov
 * Date: 09.04.13
 */
@Transactional
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void update(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    public User getById(Long userId) {
        return (User) sessionFactory.getCurrentSession().get(User.class, userId);
    }

    public List<User> getAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM User order by login").list();
    }

    public User getByLogin(String login) {
        final Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.login = ?");
        query.setParameter(1, login);
        return (User)query.uniqueResult();
    }

    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

}
