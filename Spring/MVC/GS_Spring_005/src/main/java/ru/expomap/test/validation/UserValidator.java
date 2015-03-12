package ru.expomap.test.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.expomap.test.model.User;

import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 01.12.2011
 * Time: 17:46:40
 * To change this template use File | Settings | File Templates.
 */
public class UserValidator implements Validator {


    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        User user = (User) o;


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "User name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "User email is required");

        if (!isValidEmail(user.getEmail()) && errors.getErrorCount() < 1) {
            errors.rejectValue("email", "", "Invalid email address");
            return;
        }


    }

    private boolean isValidEmail(String email) {
        String email_pattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-.]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(email_pattern);
        return pattern.matcher(email).matches();
    }
}
