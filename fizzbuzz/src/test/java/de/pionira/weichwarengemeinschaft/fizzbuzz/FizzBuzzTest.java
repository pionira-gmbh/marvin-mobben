package de.pionira.weichwarengemeinschaft.fizzbuzz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @ParameterizedTest
    @MethodSource(value = "provideImpl")
    void test3(FizzBuzz fizzBuzz) {
        String expected = "1,2,Fizz";
        String actual = fizzBuzz.fizzbuzz(3);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource(value = "provideImpl")
    void test5(FizzBuzz fizzBuzz) {
        String expected = "1,2,Fizz,4,Buzz";
        String actual = fizzBuzz.fizzbuzz(5);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource(value = "provideImpl")
    void test16(FizzBuzz fizzBuzz) {
        String expected = "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz,16";
        String actual = fizzBuzz.fizzbuzz(16);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource(value = "provideImpl")
    void testFizz(FizzBuzz fizzBuzz) {
        String expected = "Fizz";
        String expectedAlt = "FizzBuzz";
        for (int i = 1; i <= 33; i++) {
            String result = fizzBuzz.fizzbuzz(i * 3);

            assertTrue(result.endsWith(expected) || result.endsWith(expectedAlt), "wrong result: " + result);
        }
    }

    @ParameterizedTest
    @MethodSource(value = "provideImpl")
    void testBuzz(FizzBuzz fizzBuzz) {
        String expected = "Buzz";
        String expectedAlt = "FizzBuzz";
        for (int i = 1; i <= 20; i++) {
            String result = fizzBuzz.fizzbuzz(i * 5);

            assertTrue(result.endsWith(expected) || result.endsWith(expectedAlt), "wrong result: " + result);
        }
    }

    @ParameterizedTest
    @MethodSource(value = "provideImpl")
    void testFizzBuzz(FizzBuzz fizzBuzz) {
        String expected = "FizzBuzz";
        for (int i = 1; i <= 6; i++) {
            String result = fizzBuzz.fizzbuzz(i * 3 * 5);

            assertTrue(result.endsWith(expected), "wrong result: " + result);
        }
    }

    @ParameterizedTest
    @MethodSource(value = "provideImpl")
    void negativ(FizzBuzz fizzBuzz) {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                continue;
            }
            var result = fizzBuzz.fizzbuzz(i);
            assertTrue(result.endsWith(String.valueOf(i)));
        }
    }

    @ParameterizedTest
    @MethodSource(value = "provideImpl")
    void evilSeniorTester(FizzBuzz fizzBuzz) {
        var result = fizzBuzz.fizzbuzz(-1);
        assertEquals("", result);
        result = fizzBuzz.fizzbuzz(0);
        assertEquals("", result);
    }

    @ParameterizedTest
    @MethodSource(value = "provideImpl")
    void runTimePerf(FizzBuzz fizzBuzz) {
        long before = System.currentTimeMillis();
        fizzBuzz.fizzbuzz(1000000);
        long after = System.currentTimeMillis();
        long elapsed = after - before;

        System.out.println("Runtime of " + fizzBuzz.getClass().getName() + ": " + elapsed);
    }

    static Stream<Arguments> provideImpl() {
        return Stream.of(
                Arguments.of(new FizzBuzzTimo()), Arguments.of(new FizzBuzzStream()), Arguments.of(new FizzBuzzBenni()), Arguments.of(new FizzBuzzTern())
                );
    }
}