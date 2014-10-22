package edu.javacourse.spring.dao;

import edu.javacourse.spring.model.Region;
import edu.javacourse.spring.validation.RegionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Author: Georgy Gobozov
 * Date: 18.07.13
 */
public class RegionDao {

    @Autowired
    private RegionValidator validator;

    @Autowired
    private MessageSource messageSource;

    public void createRegion(Region region) {

        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();

//        final BindException errors = new BindException(region, region.getClass().getName());
//        validator.validate(region, errors);
//        if (errors.hasErrors()){
//            for (ObjectError e :errors.getAllErrors()){
//                System.out.println(e.getCode() + " "  + e.getDefaultMessage());
//                System.out.println(messageSource.getMessage(e, Locale.getDefault()));
//            }
//            return;
//        }

        Set<ConstraintViolation<Region>> constraintViolations = validator.validate(region);
        System.out.println(String.format("Кол-во ошибок: %d",
                constraintViolations.size()));

        for (ConstraintViolation<Region> cv : constraintViolations)
            System.out.println(String.format(
                    "Внимание, ошибка! property: [%s], value: [%s], message: [%s]",
                    cv.getPropertyPath(), cv.getInvalidValue(), cv.getMessage()));

        System.out.println("Region Saved...");

    }

}
