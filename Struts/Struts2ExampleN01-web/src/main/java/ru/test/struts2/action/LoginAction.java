package ru.test.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import ru.test.struts2.entity.LoginBean;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class LoginAction extends ActionSupport {

    private LoginBean loginBean;

    @Override
    public String execute() throws Exception {
        if ("gemini".equals(loginBean.getUsername()) && "systems".equals(loginBean.getPassword())) {
            return "success";
        } else {
            return "failure";
        }
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

}
