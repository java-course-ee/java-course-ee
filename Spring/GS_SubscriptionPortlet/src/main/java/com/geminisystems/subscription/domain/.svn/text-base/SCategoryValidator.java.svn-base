package com.geminisystems.subscription.domain;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 16.11.2011
 * Time: 14:27:34
 * To change this template use File | Settings | File Templates.
 */
public class SCategoryValidator implements Validator {

     public boolean supports(Class<?> aClass) {
        return SBean.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        SCategory category = (SCategory) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "subscription.invalid.title");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "paths", "subscription.invalid.path");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "atName", "subscription.invalid.atname");
        
    }

}
