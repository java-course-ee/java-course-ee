package edu.javacourse;

import io.hawt.embedded.Main;

/**
 * @author Artem Pronchakov artem.pronchakov@ocrv.ru
 */
public class HawtioSample {

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.setWar("Hawtio/hawtio-default-1.5.7.war");
        main.run();
    }

}
