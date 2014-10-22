package dao;

import entity.User;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: gb
 * Date: 30.08.2009
 * Time: 21:15:34
 * To change this template use File | Settings | File Templates.
 */
public class UserDAOImpl implements UserDAO {

    private HibernateTemplate template;

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    public void create(User user) {
        template.save(user);
    }

    public void update(User user) {
        template.saveOrUpdate(user);
    }

    public User getById(Long userId) {
        return (User) template.get(User.class, userId);
    }

    public List<User> getAll() {
        //noinspection JpaQlInspection
        return template.find("FROM User order by login");
    }

    public User getByLogin(String login) {
        //noinspection JpaQlInspection
        return (User) template.find("from User u where u.login = ?", login).get(0);
    }

    public void delete(User user) {
        template.delete(user);
    }
}
