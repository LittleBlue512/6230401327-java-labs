
/**
 * This program is to use overloading methods to handle multiple cases of input.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Sec: 1
 * Date: December 25, 2019
 */

import java.util.ArrayList;
import java.util.List;

public class Overloading {
    public static void main(String[] args) {
        display("Hello");
        display("Hello", "Bye");
        display(2, 3);
        display(2, 3, 4);
    }

    // Handle single string argument
    private static void display(String str) {
        System.out.println(str);
    }

    // Handle multiple string arguments
    private static void display(String... strs) {
        String output = "";

        // Format the output
        output = String.join(" and ", strs);

        // Print the result
        System.out.println(output);
    }

    // Handle multiple int arguments
    private static void display(int... nums) {
        int sum = 0;
        String output = "";
        List<String> numsChars = new ArrayList<>();

        // Iterate through the array of arguments
        for (int num : nums) {
            // Add the value of each element to sum
            sum += num;
            // Convert each element to String and add to the list of String.
            numsChars.add(Integer.toString(num));
        }

        // Format the output
        output = String.join(" + ", numsChars) + String.format(" = %d", sum);

        // Print the result
        System.out.println(output);
    }
}
