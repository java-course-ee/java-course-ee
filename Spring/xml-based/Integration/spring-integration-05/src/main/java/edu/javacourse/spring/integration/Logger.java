package edu.javacourse.spring.integration;

import java.util.List;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class Logger {

    public String log(String message){
        message = message.toUpperCase();
        System.out.println("Logger: " + message);
        return message;
    }

    public void logs(List<String> messageList) {
        System.out.println(messageList);
    }

}
