package edu.javacourse.ejb;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;

@Stateless
@LocalBean
@Interceptors(edu.javacourse.ejb.interceptor.MyInterceptor1.class)
public class AopTestBean {

    @Resource
    TimerService timerService;
    
    public void aopTest1() {
        System.out.println("AOP TEST 1 method");
    }

    @Interceptors(value = {edu.javacourse.ejb.interceptor.MyInterceptor2.class, edu.javacourse.ejb.interceptor.MyInterceptor3.class})
    @ExcludeClassInterceptors
    public void aopTest2() {
        timerService.createTimer(2000, "Timer example");
        // Еще варианты установки таймера
        // Регулярный вызов через 1000 миллисек
        //timerService.createTimer(0, 1000, "Timer example");
        // Вызов в конкретное время
        //timerService.createTimer(new Date(), "Timer example");
        System.out.println("AOP TEST 2 method");
    }

    @Timeout
    // or bean must implement the javax.ejb.TimedObject interface
    public void timeout(Timer timer) {
        System.out.println("Timeout occurred:" + timer.getInfo());
    }
}
