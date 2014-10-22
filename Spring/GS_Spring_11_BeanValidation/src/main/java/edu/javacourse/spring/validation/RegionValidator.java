package edu.javacourse.spring.validation;

import edu.javacourse.spring.model.Region;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Author: Georgy Gobozov
 * Date: 18.07.13
 */
public class RegionValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return Region.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        Region r = (Region) o;
        if (r.getRegionName() == null || r.getRegionName().equals(""))
            errors.rejectValue("regionName", "invalid.name");

        if (r.getPopulation() <= 0)
            errors.rejectValue("population", "invalid.population");

    }
}
