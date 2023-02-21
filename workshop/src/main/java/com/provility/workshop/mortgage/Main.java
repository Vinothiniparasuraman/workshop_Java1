package com.provility.workshop.mortgage;

import com.provility.workshop.Mortagecal.Mortage_cal;

import java.util.Scanner;

public class Main {
    /* LinearSearch*/
    public static void main(String arg[]) {
//        int i;
//        int key = 4;
//        int array[] ={1,2,3,4,5,6};
//        for(i=0;i<array.length;i++){
//            if(array[i]== key){
//                System.out.println(i);
//            }
//            else {
//                System.out.println("not Match");
//            }


        int i,len, key, array[];

                Scanner input = new Scanner(System.in);

                System.out.println("Enter Array length:");

                len = input.nextInt();

                array = new int[len];

                System.out.println("Enter " + len + " elements");

                for (i = 0; i < len; i++)
                {
                    array[i] = input.nextInt();
                }
                System.out.println("Enter the search key value:");
                key = input.nextInt();
                for (i = 0; i < len; i++)
                {
                    if (array[i]== key)
                    {
                        System.out.println(key+" is present at location "+(i+1));
                        break;
                    }
                }
                if (i == len)
                    System.out.println(key + " doesn't exist in array.");
            }
        }


