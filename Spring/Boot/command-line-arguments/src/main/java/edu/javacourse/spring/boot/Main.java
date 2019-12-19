package edu.javacourse.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

//    Run with arguments: --someint=123 --somestring=hahaha --somestring=hohoho
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

        CommandLineArgumentsAnnotation argumentBean = context.getBean(CommandLineArgumentsAnnotation.class);
        log.info("Annotation Bean's int value: {}", argumentBean.getSomeInt());
        log.info("Annotation Bean's String value: {}", argumentBean.getSomeString());

        CommandLineArgumentsApplicationArguments argumentBeanApplicationArguments = context.getBean(CommandLineArgumentsApplicationArguments.class);
        log.info("ApplicationArguments Bean's int value: {}", argumentBeanApplicationArguments.getInt());
        log.info("ApplicationArguments Bean's String value: {}", argumentBeanApplicationArguments.getString());

    }
}
