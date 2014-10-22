package edu.javacourse.spring.dao;

import edu.javacourse.spring.model.Region;
import edu.javacourse.spring.validation.RegionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;

import java.util.Locale;

/**
 * Author: Georgy Gobozov
 * Date: 18.07.13
 */
public class RegionDao {

    @Autowired
    private RegionValidator validator;

    @Autowired
    private MessageSource messageSource;

    public void saveRegion(Region region) {
        final BindException errors = new BindException(region, region.getClass().getName());
        validator.validate(region, errors);
        if (errors.hasErrors()) {
            for (ObjectError e : errors.getAllErrors()) {
                System.out.println(e.getCode() + " " + e.getDefaultMessage());
                System.out.println(messageSource.getMessage(e, Locale.getDefault()));
            }
            return;
        }
        System.out.println("Region Saved...");

    }

}
