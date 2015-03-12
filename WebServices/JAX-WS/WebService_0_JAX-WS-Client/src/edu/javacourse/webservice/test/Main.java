package edu.javacourse.webservice.test;

import edu.javacourse.webservice.SayHelloService;
import edu.javacourse.webservice.SayHelloServiceService;

/**
 * Author: Georgy Gobozov
 * Date: 15.07.13
 */
public class Main {

    public static void main(String[] args) {

        SayHelloServiceService service = new SayHelloServiceService();
        SayHelloService port = service.getSayHelloServicePort();


        String response = port.sayHello("Georgy!");
        System.out.println("response = " + response);


    }

}
