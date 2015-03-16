package ru.test.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import ru.test.struts2.entity.LoginBean;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
@Namespace("/")
@ResultPath("/")
public class LoginAction extends ActionSupport {

    private LoginBean loginBean;

    @Override
    @Action(value = "login-action", results = {
            @Result(name = "input", location = "login.jsp"),
            @Result(name = "success", location = "success.jsp"),
            @Result(name = "failure", location = "failure.jsp")
    })
    @Validations(requiredStrings = {
            @RequiredStringValidator(fieldName = "loginBean.username", type = ValidatorType.FIELD, key = "username_required"),
            @RequiredStringValidator(fieldName = "loginBean.password", type = ValidatorType.FIELD, key = "password_required")
    })
    public String execute() throws Exception {
        if ("gemini".equals(loginBean.getUsername()) && "systems".equals(loginBean.getPassword())) {
            return "success";
        } else {
            return "failure";
        }
    }

    @Override
    @Action(value = "login-screen", results = {
            @Result(name = "input", location = "login.jsp")
    })
    public String input() throws Exception {
        return "input";
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

}
