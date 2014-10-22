package edu.javacourse.spring.bean.init;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class InitBean5 {

    @PostConstruct
    public void annotationInit() {
        System.out.println("Annotation Init for Bean 5");
    }

    @PreDestroy
    public void annotationDestroy() {
        System.out.println("Annotation Destroy for Bean 5");
    }

}
