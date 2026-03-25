package com.jiecode.tdd;

import org.junit.jupiter.api.*;

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

}
