package edu.javacourse.spring.integration;

import globalweather.GetWeatherResponse;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class Logger {

    public void log(GetWeatherResponse message){
        System.out.println("Logger: " + message.getGetWeatherResult());
    }

}
