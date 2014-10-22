package edu.javacourse.spring.lifecyrcle;

import org.springframework.context.Lifecycle;

public class LifeTest implements Lifecycle {

    private boolean started = false;

    @Override
    public void start() {
        started = true;
        System.out.println("Start 1");
    }

    @Override
    public void stop() {
        started = false;
        System.out.println("Stop 1");
    }

    @Override
    public boolean isRunning() {
        System.out.println("isRunning 1:" + started);
        return started;
    }
}
