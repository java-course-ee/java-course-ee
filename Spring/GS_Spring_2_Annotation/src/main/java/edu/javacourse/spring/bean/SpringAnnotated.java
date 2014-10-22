package edu.javacourse.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

public class SpringAnnotated {

    @Value("TestString")
    private String testString;
    //
    // Здесь пример вызова значения из файла свойств (см. файл springExample.xml
    // Expression Language
    @Value("#{springProperties.initialize}")
    private String otherString;
    //

    @Autowired
    //@Qualifier(value="testSpringBean")  // Без указания конкретного бина Spring запутается
    private SpringTest springTest;

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }

    public String getOtherString() {
        return otherString;
    }

    public void setOtherString(String otherString) {
        this.otherString = otherString;
    }

    public SpringTest getSpringTest() {
        return springTest;
    }

    public void setSpringTest(SpringTest springTest) {
        this.springTest = springTest;
    }

    // Создание объекта через метод
    @Bean
    public BeanExample beanService() {
        System.out.println("BeanExample through method");
        return new BeanExample();
    }

    // Пример с аннотацией PostConstruct
    @PostConstruct
    public void postConstruct() {
        System.out.println("Post Construct");
    }
}
