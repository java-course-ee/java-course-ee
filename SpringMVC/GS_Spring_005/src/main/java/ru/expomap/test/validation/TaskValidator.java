package ru.expomap.test.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.expomap.test.model.Task;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 01.12.2011
 * Time: 17:46:40
 * To change this template use File | Settings | File Templates.
 */
public class TaskValidator implements Validator {


    public boolean supports(Class<?> aClass) {
        return Task.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        Task task = (Task) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Task name is required");
        if (task.getProject() == null)
            errors.rejectValue("project", "", "Task project is required, choose s project");
        if (task.getUsers() == null || task.getUsers().size() < 1)
            errors.rejectValue("users", "", "Task users is required, choose at least one");

    }


}
