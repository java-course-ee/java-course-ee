package edu.javacourse.camel.simpleroute;

import org.apache.camel.Body;

public class Multiplier {
    public Integer multipleByTwo(@Body Integer input) {
        return input * 2;
    }
}
