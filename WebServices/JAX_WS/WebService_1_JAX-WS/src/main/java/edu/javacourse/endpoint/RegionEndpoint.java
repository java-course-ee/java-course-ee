package edu.javacourse.endpoint;

import edu.javacourse.webservice.RegionServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * Author: Georgy Gobozov
 * Date: 14.07.13
 */
public class RegionEndpoint {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/regionService", new RegionServiceImpl());
    }

}
