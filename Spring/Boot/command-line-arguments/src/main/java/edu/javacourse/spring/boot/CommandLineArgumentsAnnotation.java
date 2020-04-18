package edu.javacourse.spring.boot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommandLineArgumentsAnnotation {

    @Value("${someint}")
    private Long someInt;

    @Value("${somestring}")
    private List<String> someString;

    public Long getSomeInt() {
        return someInt;
    }

    public void setSomeInt(Long someInt) {
        this.someInt = someInt;
    }

    public List<String> getSomeString() {
        return someString;
    }

    public void setSomeString(List<String> someString) {
        this.someString = someString;
    }
}
