package edu.javacourse.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Author: Georgy Gobozov
 * Date: 15.07.13
 */
@WebService
public class SayHelloService {


    @WebMethod
    public String sayHello(String name){
        return "Hello, "  + name;
    }


}
