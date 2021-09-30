package main.java;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nHello and Welcome to Rock, Paper, Scissors!");
        System.out.println("\nHow many rounds would you like to play?");
        System.out.println("You can only play a maximum of 10 rounds");

        int rounds = scanner.nextInt();
        if(rounds < 1 || rounds > 10) {
            System.out.println("That is an invalid number of rounds sorry");
            return;
        }

        int playedRounds = 0;
        int ties = 0, wins = 0, losses = 0;
        while(playedRounds < rounds) {
            System.out.println("\nPlease input a number corresponding to your desired option:");
            System.out.println("1 = Rock, 2 = Paper, 3 = Scissors");

            String[] options = new String[]{"Rock", "Paper", "Scissors"};

            int choice = scanner.nextInt();
            if(choice < 1 || choice > 3) {
                System.out.println("Sorry, that is not a valid option");
                continue;
            }

            Random random = new Random();
            int computersChoice = random.nextInt(3)+1;

            System.out.println(computersChoice);

            //System.out.println("You picked " + options[choice-1] +
            //        " and the computer picked " + options[computersChoice-1]);

            int difference = choice - computersChoice;
            if(difference == 1 || difference == -2) {
                // user wins
                System.out.println("\nYou won the round!");
                wins++;
            } else if(difference == 0) {
                // tie
                System.out.println("\nThere was a tie!");
                ties++;
            } else {
                // user loses
                System.out.println("\nYou lost the round!");
                losses++;
            }

            if(playedRounds+1 == rounds) {
                System.out.println("\nFinal results were:");
                System.out.println("Wins: " + wins + "\nTies: " + ties + "\nLosses: " + losses);
                System.out.println("\nWould you like to play again? 1 = Yes, 2 = No");
                int answer = scanner.nextInt();
                if (answer == 0) {
                    System.out.println("Thanks for playing!");
                    System.exit(0);
                }
            }
            playedRounds++;
        }

        main(new String[]{});
    }

}
