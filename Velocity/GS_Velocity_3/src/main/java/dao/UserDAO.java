package dao;

import entity.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: gb
 * Date: 30.08.2009
 * Time: 21:02:17
 * To change this template use File | Settings | File Templates.
 */
public interface UserDAO {
    void create(User user);

    void update(User user);

    User getById(Long userId);

    List<User> getAll();

    User getByLogin(String login);

    void delete(User user);
}
