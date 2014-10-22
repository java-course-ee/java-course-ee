package edu.javacourse.spring.aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


/*1 For bean implemented InitializingBean, it will run afterPropertiesSet() after all bean properties have been set.
  2 For bean implemented DisposableBean, it will run destroy() after Spring container is released the bean.
  3 BeanNameAware interface provide to know  bean information like name aware
  */
public class BeanAware implements BeanNameAware, InitializingBean, DisposableBean {

    public String property;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
        System.out.println("setProperty is called:" + property);
    }


    // Обратить внимание на то, что метод setBeanName вызывается ПЕРЕД
    // afterPropertiesSet
    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName:" + name);
    }

    // А этот метод после инициализации свойств
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    // Иллюстрация для destroy/registerShutdownHook
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

}
