package com.jawad.mthree;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DogGenetics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        ArrayList<String> breeds = new ArrayList<String>() {
            {
                add("St. Bernard");
                add("Chihuahua");
                add("Dramatic RedNosed Asian Pug");
                add("Common Cur");
                add("King Doberman");
                add("Afador");
                add("Aussie Doodle");
                add("Bichon Frise");
                add("Dalmation");
                add("Bulldog");
                add("Icelandic Sheepdog");
            }
        };

        System.out.println("Hello There! What is your dog's name?");
        String dogName = scanner.next();
        System.out.println("Processing...");
        System.out.println("\nHere is " + dogName + "'s background ethnicity report:");

        int firstPercentage = random.nextInt(101);
        int secondPercentage = random.nextInt(101 - firstPercentage);
        int thirdPercentage = random.nextInt(101 - (firstPercentage + secondPercentage));
        int finalPercentage = 100 - (firstPercentage + secondPercentage + thirdPercentage);

        String firstBreed = breeds.get(random.nextInt(breeds.size()));
        breeds.remove(firstBreed);
        String secondBreed = breeds.get(random.nextInt(breeds.size()));
        breeds.remove(secondBreed);
        String thirdBreed = breeds.get(random.nextInt(breeds.size()));
        breeds.remove(thirdBreed);
        String fourthBreed = breeds.get(random.nextInt(breeds.size()));

        System.out.println(firstBreed + ": " + firstPercentage + "%");
        System.out.println(secondBreed + ": " + secondPercentage + "%");
        System.out.println(thirdBreed + ": " + thirdPercentage + "%");
        System.out.println(fourthBreed + ": " + finalPercentage + "%");
        System.out.println();
        System.out.println("Thanks for taking the DNA test!");
    }

}
