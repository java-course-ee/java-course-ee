package edu.javacourse.spring.config;

import edu.javacourse.spring.bean.SimpleBean2;
import edu.javacourse.spring.bean.SimpleImpl;
import edu.javacourse.spring.bean.SimpleInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CoreConfig.class)
public class ApplicationConfig {

    // Здесь могут быть интерфейсы вместо классов - что может быть удобно !!!
    @Bean
    public SimpleBean2 getSimpleBean2() {
        return new SimpleBean2();
    }

    @Bean
    public SimpleInterface getSimpleInterface() {
        return new SimpleImpl();
    }


}
