package com.geminisystems.subscription.domain;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 07.11.2011
 * Time: 13:32:27
 * To change this template use File | Settings | File Templates.
 */
public class SBeanValidator implements Validator {

    public boolean supports(Class<?> aClass) {
        return SBean.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        SBean bean = (SBean) o;
        System.out.println("bean = " + bean);
        if (!isValidEmail(bean.getEmail())) {
            errors.rejectValue("email", "subscription.invalid");
            return;
        }
        if (!bean.getHash().equals("check")) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "subscription.invalid");
            if (bean.getCategories() == null || bean.getCategories().size() == 0) {
                errors.rejectValue("email", "subscription.invalid.categories");
                return;
            }
        }
    }

    private boolean isValidEmail(String email) {
        String email_pattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-.]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(email_pattern);
        return pattern.matcher(email).matches();
    }
}
