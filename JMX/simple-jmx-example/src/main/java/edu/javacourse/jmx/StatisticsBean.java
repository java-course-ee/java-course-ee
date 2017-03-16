package edu.javacourse.jmx;

import java.util.Date;
import java.util.Random;

/**
 * @author Artem Pronchakov artem.pronchakov@ocrv.ru
 */
public class StatisticsBean implements StatisticsBeanMX {

    public String getCurrentTime() {
        return new Date().toString();
    }

    public int getRandomNumber() {
        return new Random().nextInt();
    }

    public void printSomethingToLog(String saySomething) {
        System.out.println("I have to say: " + saySomething);
    }

}
