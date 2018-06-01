package edu.javacourse.junit;

import org.junit.jupiter.api.*;

/**
 * @author Artem Pronchakov artem.pronchakov@calisto.email
 */
public class BeforeAfterTest {

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("afterAll");
    }

    @BeforeEach
    public  void beforeEach() {
        System.out.println("beforeEach");
    }

    @AfterEach
    public  void afterEach() {
        System.out.println("afterEach");
    }

}
