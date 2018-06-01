package edu.javacourse.junit;

import edu.javacourse.junit.exception.DivideByZero;
import org.junit.jupiter.api.Test;

import static java.time.Duration.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Artem Pronchakov artem.pronchakov@calisto.email
 */
public class AssertionsTest {

    @Test
    public void simpleAssertions() {
        assertTrue(256 == 256, "assert checks that condition is true");
        assertEquals("Hello", "Hello", "assert checks that 'actual' is equal to 'expected'");
    }

    @Test
    public void exceptionAssertions() {
        assertThrows(DivideByZero.class, () -> SimpleMath.div(3, 0), "assert checks that code throws exception");
    }

    @Test
    public void timeoutAssertions() {
        assertTimeout(ofSeconds(7), () -> Thread.sleep(6000), "assert checks that code run time is less than N");
    }

}
