package com.jiecode.tdd;

public class FizzBuzz {
    //if number is divisible by 3 print fizz


    //if number is divisble by 5 print buzz


    //if bumber is divisable by 3 and 5 , pring fizzbuzz

    // if number is not divsiable 3 or 5 ,then print hhe number

    public static String computer(int i){
        StringBuilder result = new StringBuilder();
        if(i%3==0){
            result.append("Fizz");
        }
        if(i%5==0){
            result.append("Buzz");
        }
        if(result.isEmpty()){
            result.append(i);
        }
        return result.toString();
    }




  /*  public static String computer(int i) {
        if (i % 3 == 0 && i%5==0 ){
            return "FizzBuzz";
        } else if (i % 3 == 0) {
            return "Fizz";
        }else if (i % 5 == 0) {
            return "Buzz";
        }else {
            return Integer.toString(i);
        }

    }

   */
}
