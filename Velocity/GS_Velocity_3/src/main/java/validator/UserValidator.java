package validator;

import entity.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 04.09.2009
 * Time: 14:46:36
 * To change this template use File | Settings | File Templates.
 */
public class UserValidator implements Validator {

    public boolean supports(Class aClass) {
        return User.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if (user == null) errors.reject("Null data received");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login.empty", "Login is reqired!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty", "Email is reqired!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Password is reqired!");

    }
}
