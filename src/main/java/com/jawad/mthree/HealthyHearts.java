package com.jawad.mthree;

import java.util.Scanner;

public class HealthyHearts {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello there! How old are you currently?");

        int age = scanner.nextInt();
        int maximum = 220 - age;

        System.out.println("\nYour maximum heart rate should be " + maximum + " beats per minute.");

        int lowerBound = (int) (maximum * 0.5);
        int upperBound = (int) (maximum * 0.85);
        System.out.println("Your target heart rate zone is " + lowerBound + " - " + upperBound + " beats per minute.");

    }

}
