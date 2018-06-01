package edu.javacourse.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Artem Pronchakov artem.pronchakov@calisto.email
 */
@DisplayName("Pretty name test")
public class PrettyNamesTest {

    @Test
    @DisplayName("Addition operation")
    public void testAdd() {
        assertEquals(4, 2 + 2);
    }

}
