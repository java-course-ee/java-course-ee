package service;

import dao.UserDAO;
import entity.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: gb
 * Date: 30.08.2009
 * Time: 21:06:23
 * To change this template use File | Settings | File Templates.
 */
public class UserService {

    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void create(User user) {
        userDAO.create(user);
    }

    public void update(User user) {
        userDAO.update(user);
    }

    public User getById(Long userId) {
        return userDAO.getById(userId);
    }

    public List<User> getAll() {
        return userDAO.getAll();
    }

    public User getByLogin(String login) {
        return userDAO.getByLogin(login);
    }

    public void delete(User user) {
        userDAO.delete(user);
    }
}
