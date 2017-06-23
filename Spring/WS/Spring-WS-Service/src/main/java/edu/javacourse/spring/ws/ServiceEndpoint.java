package edu.javacourse.spring.ws;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.gs.test.SayHelloRequest;
import ru.gs.test.SayHelloResponse;

/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
@Endpoint
public class ServiceEndpoint {

    @PayloadRoot(localPart = "sayHelloRequest", namespace = "http://test.gs.ru/")
    @ResponsePayload
    public SayHelloResponse sayHello(@RequestPayload SayHelloRequest sayHello) {
        SayHelloResponse response = new SayHelloResponse();
        response.setReturn("Hello " + sayHello.getName());
        return response;
    }

}
