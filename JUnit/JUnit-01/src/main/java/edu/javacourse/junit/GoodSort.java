package edu.javacourse.junit;

/**
 * @author Artem Pronchakov pronchakov.artem@ocrv.ru
 */
public class GoodSort {

    public static Comparable[] sortStringArray(Comparable[] input) {

        for (int ordered_index = 0; ordered_index < input.length; ordered_index++) {
            int current_minimum = ordered_index;
            for (int i = ordered_index; i < input.length; i++) {
                if (less(input[i], input[current_minimum])) {
                    current_minimum = i;
                }
            }
            exch(input, ordered_index, current_minimum);
        }

        return input;
    }

    protected static boolean less(Comparable c1, Comparable c2) {
        return (c1.compareTo(c2) < 0);
    }

    protected static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0 + 1; i <= a.length - 1; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

}
