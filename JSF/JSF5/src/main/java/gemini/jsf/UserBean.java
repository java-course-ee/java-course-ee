package gemini.jsf;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Map;

@ManagedBean(name = "userbean")
@ViewScoped
public class UserBean implements Serializable {



    private String name;
    private String surname;
    private String email;
    private int age;





    public UserBean() {
    }

    public UserBean(UserBean userBean) {
        this.name = userBean.getName();
        this.surname = userBean.getSurname();
        this.email = userBean.getEmail();
        this.age = userBean.getAge();
    }

    public String getName() {
        return name;
    }

    public void setName(String newValue) {
        name = newValue;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String newValue) {
        surname = newValue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }




}
