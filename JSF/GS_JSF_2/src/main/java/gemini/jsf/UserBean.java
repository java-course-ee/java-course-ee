package gemini.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "user")
@SessionScoped
public class UserBean {

    private String name;
    private String password;


    public String getName() {
        return name;
    }

    public void setName(String newValue) {
        name = newValue;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String newValue) {
        password = newValue;
    }
}
