/**
 * This Calculator program is to accept three arguments: operation operand1 operand2.
 * It outputs the result of the operation.
 * The program ends when the user inputs 'q' or 'Q'.
 *
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Sec: 1
 * Date: December 13, 2019
 *
**/

package sirimul.chattipoom.lab2;

public class Calculator {
    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();
        if (args.length != 0 && (args[0].equals("Q") || args[0].equals("q"))) {
            System.out.println("Execution Time: " + (System.currentTimeMillis() - beginTime) + " ms");
            System.out.println("Quitting the program...");
            return;
        } else if (args.length != 3) {
            System.out.printf("Calculator <operator> <operand1> <operand2>");
        } else {
            String operator = args[0], output;
            double operand1 = Double.parseDouble(args[1]), operand2 = Double.parseDouble(args[2]);
            output = String.format("%.2f %s %.2f = ", operand1, operator, operand2);
            switch (operator) {
            case "+":
                output += String.format("%.2f", operand1 + operand2);
                break;
            case "-":
                output += String.format("%.2f", operand1 - operand2);
                break;
            case "x":
                output += String.format("%.2f", operand1 * operand2);
                break;
            case "/":
                if (operand2 == 0) {
                    output = "The second operand cannot be zero.";
                } else {
                    output += String.format("%.2f", operand1 / operand2);
                }
                break;
            default:
                System.out.println("Valid operators: + - x /");
                return;
            }
            System.out.println(output);
        }
    }
}