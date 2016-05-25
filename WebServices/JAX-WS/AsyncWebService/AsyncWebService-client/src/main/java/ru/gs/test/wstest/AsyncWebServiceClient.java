package ru.gs.test.wstest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.gs.test.AsyncWebService;
import ru.gs.test.AsyncWebServiceService;
import ru.gs.test.SayHelloSloooooowlyResponse;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import java.util.concurrent.Future;

public class AsyncWebServiceClient {

    private static final Logger log = LoggerFactory.getLogger(AsyncWebServiceClient.class);

    public static void main(String[] args) throws Exception {

        AsyncWebServiceService service = new AsyncWebServiceService();
        AsyncWebService port = service.getAsyncWebServicePort();

        log.info("Sync - start");
        String syncResponse = port.sayHelloSloooooowly("Alika");
        log.info("Sync - end. result: {}", syncResponse);



        log.info("");
        log.info("");
        log.info("");

        log.info("Async Response - start");
        Response<SayHelloSloooooowlyResponse> asyncResponse = port.sayHelloSloooooowlyAsync("Loren");
        log.info("Request is sent");
        while (!asyncResponse.isDone()) {
            log.info("waiting...");
            Thread.sleep(1000);
        }
        log.info("Async Response end: {}", asyncResponse.get().getReturn());



        log.info("");
        log.info("");
        log.info("");

        log.info("Async Handler - start");
        Future<?> handlerResponse = port.sayHelloSloooooowlyAsync("Shelby", new AsyncHandler<SayHelloSloooooowlyResponse>() {
            @Override
            public void handleResponse(Response<SayHelloSloooooowlyResponse> res) {
                try {
                    log.info("Async Handler end: {}", res.get().getReturn());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        log.info("Request is sent");
        while (!handlerResponse.isDone()) {
            log.info("waiting...");
            Thread.sleep(1000);
        }
        log.info("Continue to work");

    }
}
