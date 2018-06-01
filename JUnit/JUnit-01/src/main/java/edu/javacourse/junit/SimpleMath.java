package edu.javacourse.junit;

import edu.javacourse.junit.exception.DivideByZero;

/**
 * @author Artem Pronchakov artem.pronchakov@ocrv.ru
 */
public class SimpleMath {

    public static double div(double a, double b) {
        if (b == 0) {
            throw new DivideByZero();
        }
        return a / b;
    }

    public static int absolute(int a) {
        return a < 0 ? a * -1 : a;
    }

}
