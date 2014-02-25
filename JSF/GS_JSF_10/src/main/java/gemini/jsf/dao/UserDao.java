package gemini.jsf.dao;

import gemini.jsf.entity.User;

import java.util.List;

/**
 * Author: Georgy Gobozov
 * Date: 09.04.13
 */
public interface UserDao {

    void create(User user);
    void update(User user);
    User getById(Long userId);
    List<User> getAll();
    User getByLogin(String login);
    void delete(User user);

}
