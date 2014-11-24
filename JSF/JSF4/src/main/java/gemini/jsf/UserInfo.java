package gemini.jsf;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.Map;

/**
 * Author: Georgy Gobozov
 * Date: 07.04.13
 */
@ManagedBean(name = "userinfo")
@RequestScoped
public class UserInfo {

    @ManagedProperty("#{param.username}")
    private String userName;
    private UserBean user;

    @PostConstruct
    public void  getUserInfo(){
        System.out.println("Get user info...");
        if (userName != null){
            user = Controller.getUserByName(userName);
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }
}
