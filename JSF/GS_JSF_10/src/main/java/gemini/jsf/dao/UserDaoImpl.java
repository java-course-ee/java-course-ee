package gemini.jsf.dao;

import gemini.jsf.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author: Georgy Gobozov
 * Date: 09.04.13
 */
@Transactional
public class UserDaoImpl implements UserDao {


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
        return (User)template.find("from User u where u.login = ?", login).get(0);
    }

    public void delete(User user) {
        template.delete(user);
    }

}
