package gemini.jsf;

import gemini.jsf.dao.UserDao;
import gemini.jsf.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Georgy Gobozov
 * Date: 08.04.13
 */
@ManagedBean(name = "user")
@ViewScoped
public class UserBean implements Serializable {

    @ManagedProperty(value = "#{userDao}")
    private UserDao userDao;

    private User user = new User();


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers(){
        return userDao.getAll();
    }

    public void addUser(){
        userDao.create(user);
        user = new User();
    }

    public void deleteUser(User u){
        userDao.delete(u);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }




}
