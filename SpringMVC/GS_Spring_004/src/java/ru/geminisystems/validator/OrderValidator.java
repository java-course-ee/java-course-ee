package ru.geminisystems.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.geminisystems.entity.Order;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 11.08.2009
 * Time: 15:54:20
 * To change this template use File | Settings | File Templates.
 */
public class OrderValidator implements Validator {


    public boolean supports(Class clazz) {
        return Order.class.equals(clazz);
    }


    public void validate(Object o, Errors errors) {
        Order order = (Order) o;
        if (order == null) errors.reject("Null data received");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cpu", "cpu.empty", "PCU is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hdd", "hdd.empty", "HDD is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ram", "ram.empty", "RAM is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "startDate.empty", "startDate is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "finishDate", "finishDate.empty", "finishDate is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "applications", "applications.empty", "applications is required");

    }

}
