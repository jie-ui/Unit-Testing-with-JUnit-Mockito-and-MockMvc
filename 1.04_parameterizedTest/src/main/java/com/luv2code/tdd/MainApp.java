package com.luv2code.tdd;

import com.jiecode.tdd.FizzBuzz;

public class MainApp {
    public static void main(String[] args) {
        for( int i = 0; i < 100; i++ ) {
            System.out.println(FizzBuzz.computer(i+1));

        }
    }
}
