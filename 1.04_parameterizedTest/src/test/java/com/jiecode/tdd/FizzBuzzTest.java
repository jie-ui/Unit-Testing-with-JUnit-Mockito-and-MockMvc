package com.jiecode.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {

    //if number is divisible by 3 print fizz


    //if number is divisble by 5 print buzz


    //if bumber is divisable by 3 and 5 , pring fizzbuzz

    // if number is not divsiable 3 or 5 ,then print hhe number

    @Test
    @DisplayName("Dvisible by Three")
    @Order(1)
    void testForDivsibleByThree() {
         String expected = "Fizz";
         assertEquals(expected,FizzBuzz.computer(3),"should return fizz");
    }


    @DisplayName("Divsible By Five")
    @Test
    @Order(2)
    void testForDivsibleByFive() {
        String expected = "Buzz";
        assertEquals(expected,FizzBuzz.computer(5),"should return buzz");
    }

    @DisplayName("Divsible By Three And FIve")
    @Test
    @Order(3)
    void testForDivsibleByThreeAndFive() {
        String expected = "FizzBuzz";
        assertEquals(expected,FizzBuzz.computer(15),"should return Fizzbuzz");
    }

    @DisplayName("Divsible By Three or FIve")
    @Test
    @Order(4)
    void testForDivsibleByThreeOrFive() {
        String expected = "1";
        assertEquals(expected,FizzBuzz.computer(1),"should return number");
    }

    @DisplayName("Testing wiht samll data file")
    @ParameterizedTest(name = "value={0},expected={1}")
    @CsvFileSource(resources = "/small-test-data.csv")
    @Order(5)
    void testSallDataFile(int value, String expected) {

        assertEquals(expected,FizzBuzz.computer(value),"should return number");
    }

    @DisplayName("Testing wiht Medium data file")
    @ParameterizedTest(name = "value={0},expected={1}")
    @CsvFileSource(resources = "/medium-test-data.csv")
    @Order(6)
    void testMediumDataFile(int value, String expected) {

        assertEquals(expected,FizzBuzz.computer(value),"should return number");
    }

    @DisplayName("Testing wiht Large data file")
    @ParameterizedTest(name = "value={0},expected={1}")
    @CsvFileSource(resources = "/large-test-data.csv")
    @Order(7)
    void testLargeDataFile(int value, String expected) {

        assertEquals(expected,FizzBuzz.computer(value),"should return number");
    }



}
