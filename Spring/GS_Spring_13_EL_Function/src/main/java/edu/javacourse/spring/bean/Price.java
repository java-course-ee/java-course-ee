package edu.javacourse.spring.bean;

import org.springframework.stereotype.Component;

/**
 * Author: Georgy Gobozov
 * Date: 22.07.13
 */
@Component("priceBean")
public class Price {

    private int price;

    public int getWorstPrice() {
        return 999;
    }

    public int getBestPrice() {
        return 100;
    }

}
