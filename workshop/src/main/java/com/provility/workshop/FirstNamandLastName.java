package com.provility.workshop;

import java.util.Scanner;

/*Please enter your first name and last name, separated by a space.
        ? Mary Smith
        Your first name is Mary, which has 4 characters
        Your last name is Smith, which has 5 characters
        Your initials are MS*/

public class FirstNamandLastName {
    public static void main(String[] args) {
        System.out.println("Enter a NAME");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ener a firstname");
        String getFirstName = sc.next();
        System.out.println("Enter a lastname");
        String getLastName = sc.next();

        System.out.println(getFirstName+ " " + getLastName);
        System.out.println("Your firstname is " + getFirstName + " which has " + getFirstName.length() +" character ");
        System.out.println("Your firstname is " + getLastName + " which has " + getLastName.length()+ " character ");
        System.out.println("Your initials are " + getFirstName.charAt(0) + getLastName.charAt(0));



    }
}
