package ru.gs.test;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
@Stateless
public class SimpleWebService {

    @WebMethod
    public String sayHello(String name) {
        return "Hello " + name;
    }

}
