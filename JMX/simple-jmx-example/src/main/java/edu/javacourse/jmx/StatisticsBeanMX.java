package edu.javacourse.jmx;

import javax.management.MXBean;

/**
 * @author Artem Pronchakov artem.pronchakov@ocrv.ru
 */
@MXBean
public interface StatisticsBeanMX {

    // Ottributes (must start with 'get')
    String getCurrentTime();
    int getRandomNumber();

    // Operations
    void printSomethingToLog(String saySomething);

}
