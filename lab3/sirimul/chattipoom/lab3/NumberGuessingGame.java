/**
 * This NumberGuessingGame is to randomly generate a number for the user to guess.
 * The program continuously looping to read the user's input and check if it is valid.
 * The program ends when the user enters the correct number or runs out of guesses.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Sec: 1
 * Date: December 19, 2019
**/

package sirimul.chattipoom.lab3;

import java.util.Scanner;

class NumberGuessingGame {
    public static void main(String[] args) {
        final int minNum = 1;
        final int maxNum = 10;
        final int maxTries = 5;
        final int randNum = (int) (Math.random() * ((maxNum - minNum) + 1)) + minNum;
        Scanner userScanner = new Scanner(System.in);
        int userInput = 0;
        int numTries = 0;
        String temp = "";

        // Welcome message
        System.out.println("Welcome to a number guessing game!");

        // Looping
        while (true) {
            // Check if user has any guesses left
            if (numTries >= maxTries) {
                System.out.printf("You have tried %d times. You ran out of guesses.\n", maxTries);
                System.out.printf("The answer is %d.", randNum);
                break;
            }

            // Check if input is an integer
            System.out.printf("Enter an integer between %d and %d: ", minNum, maxNum);
            temp = userScanner.nextLine(); // Get user input
            try {
                userInput = Integer.parseInt(temp); // convert user input to integer
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input: Please enter integer only.");
                continue;
            }

            // Check if input is in range [1, 10]
            if (userInput < minNum || userInput > maxNum) {
                System.out.printf("Invalid input: Please enter integer between %d and %d.\n", minNum, maxNum);
                continue;
            }

            // Increasing user's tries
            numTries++;

            // Checking input
            if (userInput == randNum) {
                System.out.println("Congratulations!");
                System.out.printf("You have tried %d times.", numTries);
                break;
            } else if (userInput < randNum) {
                System.out.println("Try a higher number!");
            } else {
                System.out.println("Try a lower number!");
            }
        }
    }
}