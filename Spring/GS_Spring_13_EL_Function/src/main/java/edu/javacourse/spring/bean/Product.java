package edu.javacourse.spring.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Author: Georgy Gobozov
 * Date: 22.07.13
 */
@Component
public class Product {

    @Value("test product")
    private String name;

    @Value("#{priceBean.getBestPrice()}")
    private int price;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
