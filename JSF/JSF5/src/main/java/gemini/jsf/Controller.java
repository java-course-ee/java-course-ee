package gemini.jsf;

import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Author: Georgy Gobozov
 * Date: 31.03.13
 */
@ManagedBean(name = "controller")
@ViewScoped
public class Controller implements Serializable {


    public static List<UserBean> users = new ArrayList<UserBean>();
    private boolean isEdit;

    @ManagedProperty(value = "#{userbean}")
    private UserBean currentUser;

    public UserBean getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserBean currentUser) {
        this.currentUser = currentUser;
    }

    public List<UserBean> getUsers() {
        return users;
    }

    public void setUsers(List<UserBean> users) {
        this.users = users;
    }

    public String addUser() {
        if (isEdit) {
            isEdit = false;
        } else {
            users.add(currentUser);
        }
        currentUser = new UserBean();
        // post redirect get
        return "index.xhtml?faces-redirect=true";
    }

    public void deleteUser() {
        Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String name = params.get("action");
        currentUser = getUserByName(name);
        users.remove(currentUser);
        currentUser = new UserBean();
    }


    public void editUser(String name) {
        currentUser = getUserByName(name);
        isEdit = true;
    }


    public static UserBean getUserByName(String name){
        if (users == null || users.isEmpty())
            return null;
        for(UserBean u: users){
            if (u.getName().equals(name))
                return u;
        }
        return null;
    }

}
