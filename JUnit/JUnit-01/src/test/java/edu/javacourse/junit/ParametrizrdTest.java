package edu.javacourse.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Artem Pronchakov artem.pronchakov@calisto.email
 */
public class ParametrizrdTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    public void parametrizrdValueSourceTest(int a) {
        assertTrue(SimpleMath.absolute(a) >= 0);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void parametrizrdMethodSourceTest(double a, double b, double result) {
        assertEquals(result, SimpleMath.div(a, b));
    }

    public static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(-1, 1, -1),
                Arguments.of(0, 1, 0),
                Arguments.of(2, 1, 2)
        );
    }

    @ParameterizedTest
    @CsvFileSource(resources = "div-parameters.csv")
    public void parametrizrdCsvFileSourceTest(double a, double b, double result) {
        assertEquals(result, SimpleMath.div(a, b));
    }

}
