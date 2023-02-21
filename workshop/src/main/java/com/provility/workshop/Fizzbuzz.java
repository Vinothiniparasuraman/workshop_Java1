package com.provility.workshop;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fizzbuzz {
    public static void main(String[] arg) {

//        int number[] = {10, 20, 3, 6, 7, 8, 5,15};
//        for (int i = 0; i < number.length; i++) {
//
//              if (number[i] % 5 == 0) {
//                System.out.println(" Divisible by 5 Buzz =" + number[i]);
//
//            }  else if (number[i] % 3 == 0) {
//                  System.out.println(" Divisible by 3 Fuzz = " + number[i]);
//
//            }  if (number[i] % 5 == 0 && number[i] % 3 == 0) {
//                System.out.println("Divisible by 5 and 3 FuzzBuzz= " + number[i]);
//
//            }
////            if (b) {
////                System.out.println(number[i]);
////            }
//
//        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Number : ");
         Integer number = sc.nextInt();
              if (number % 5 == 0 && number % 3 == 0) {
                 System.out.println("Divisible by 5 and 3 FuzzBuzz= " + number);
                 return;
              }
              if (number % 5 == 0) {
                System.out.println(" Divisible by 5 Buzz =" + number);
                return;

             }  if (number % 3 == 0) {
                  System.out.println(" Divisible by 3 Fuzz = " + number);
                  return;

            }
            System.out.println(number);

    }
}




