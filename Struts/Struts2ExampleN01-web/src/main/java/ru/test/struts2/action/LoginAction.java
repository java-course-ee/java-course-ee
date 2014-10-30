package ru.test.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import ru.test.struts2.entity.LoginBean;

/**
 * @author APronchakov <artem.pronchakov@gmail.com>
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
