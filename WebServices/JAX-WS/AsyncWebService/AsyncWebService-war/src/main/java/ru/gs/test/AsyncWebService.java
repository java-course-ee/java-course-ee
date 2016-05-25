package ru.gs.test;

import javax.jws.WebService;

@WebService
public class AsyncWebService {

    public String sayHelloSloooooowly(String name) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello " + name;
    }

}
