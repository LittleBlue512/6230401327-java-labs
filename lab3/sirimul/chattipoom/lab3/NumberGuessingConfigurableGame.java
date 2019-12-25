/**
 * This NumberGuessingGame is to randomly generate a number for the user to guess.
 * The program continuously looping to read the user's input and check if it is valid.
 * The program ends when the user enters the correct number or runs out of guesses.
 * User can change minimum and maximum number to guess.
 * User can change maximum number of tries.
 * When the game ends, user can play the game again without reopening it.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Sec: 1
 * Date: December 19, 2019
**/

package sirimul.chattipoom.lab3;

import java.util.Scanner;

public class NumberGuessingConfigurableGame {
    static Scanner userScanner = new Scanner(System.in);
    static int answer;
    static int numTries;
    static int maxTries = 5;
    static int minNum = 1;
    static int maxNum = 10;

    public static void main(String[] args) {
        String userInput = "";

        // Get valid configurations
        while (true) {
            if (getConfigs())
                break;
        }

        // "Gaming all day"
        while (true) {
            genAnswer();
            playGame();

            // Check if user want to play again
            System.out.print("Want to play again? (Y or y): ");
            userInput = userScanner.nextLine();
            if (!(userInput.equals("Y") || userInput.equals("y"))) {
                System.out.println("Thank you for playing our games. Bye!");
                break;
            }
        }
        userScanner.close();
    }

    // Get configurations
    private static boolean getConfigs() {
        String input1, input2, input3;
        int minTemp, maxTemp, triesTemp;

        // Get inputs
        System.out.print("Enter the min value: ");
        input1 = userScanner.nextLine();
        System.out.print("Enter the max value: ");
        input2 = userScanner.nextLine();
        System.out.print("Enter the maximum number of tries: ");
        input3 = userScanner.nextLine();

        // Check if all inputs are integer
        try {
            minTemp = Integer.parseInt(input1);
            maxTemp = Integer.parseInt(input2);
            triesTemp = Integer.parseInt(input3);
        } catch (NumberFormatException ex) {
            System.out.println("Invalid input: Please enter integer only.");
            return false;
        }

        // Make sure that max is greater than min
        if (maxTemp < minTemp) {
            System.out.println("Invalid input: Max value must be greater than min value.");
            return false;
        }

        // Set configurations
        minNum = minTemp;
        maxNum = maxTemp;
        maxTries = triesTemp;
        return true;
    }

    // Get answer
    private static void genAnswer() {
        answer = (int) (Math.random() * ((maxNum - minNum) + 1)) + minNum;
    }

    // Start game
    private static void playGame() {
        String inputTemp = "";
        int userInput = 0;

        numTries = maxTries;

        // Welcome message
        System.out.println("Welcome to a number guessing game!");

        // Looping
        while (true) {
            // Check if user has any guesses left
            if (numTries <= 0) {
                System.out.printf("You have tried %d times. You ran out of guesses.\n", maxTries);
                System.out.printf("The answer is %d.", answer);
                break;
            }

            // Check if input is an integer
            System.out.printf("Enter an integer between %d and %d: ", minNum, maxNum);
            inputTemp = userScanner.nextLine(); // Get user input
            try {
                userInput = Integer.parseInt(inputTemp); // convert user input to integer
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input: Please enter integer only.");
                continue;
            }

            // Check if input is in range [minNum, maxNum]
            if (userInput < minNum || userInput > maxNum) {
                System.out.printf("Invalid input: Please enter integer between %d and %d.\n", minNum, maxNum);
                continue;
            }

            // Decreasing user's tries
            numTries--;

            // Checking input
            if (userInput == answer) {
                System.out.println("Congratulations!");
                System.out.printf("You have tried %d times.\n", maxTries - numTries);
                break;
            } else if (userInput < answer) {
                System.out.println("Try a higher number!");
            } else {
                System.out.println("Try a lower number!");
            }
        }
    }
}