package edu.javacourse.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommandLineArgumentsApplicationArguments {

    @Autowired
    private ApplicationArguments arguments;

    public ApplicationArguments getArguments() {
        return arguments;
    }

    public void setArguments(ApplicationArguments arguments) {
        this.arguments = arguments;
    }

    public List<String> getString() {
        return arguments.getOptionValues("somestring");
    }

    public List<String> getInt() {
        return arguments.getOptionValues("someint");
    }
}
