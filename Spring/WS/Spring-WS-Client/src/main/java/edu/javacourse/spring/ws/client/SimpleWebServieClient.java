package edu.javacourse.spring.ws.client;

import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import ru.gs.test.SayHelloRequest;
import ru.gs.test.SayHelloResponse;

/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
public class SimpleWebServieClient extends WebServiceGatewaySupport {

    public String sayHello(String name) {
        SayHelloRequest request = new SayHelloRequest();
        request.setName(name);

        WebServiceTemplate webServiceTemplate = getWebServiceTemplate();
        SayHelloResponse response = (SayHelloResponse) webServiceTemplate.marshalSendAndReceive(request);

        return response.getReturn();

    }

}
