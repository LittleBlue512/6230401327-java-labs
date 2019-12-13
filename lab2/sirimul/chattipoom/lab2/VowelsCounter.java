/**
 * This VowelsCounter program accepts string and returns how many vowels are in that string, as an integer.
 *
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Sec: 1
 * Date: December 13, 2019
 *
**/

package sirimul.chattipoom.lab2;

public class VowelsCounter {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("VowelsCounter <String>");
        } else {
            char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
            char[] msg = args[0].toCharArray();
            int vowelsCnt = 0, length = msg.length;
            for (int i = 0; i < length; i++) {
                if (contains(vowels, msg[i]))
                    vowelsCnt++;
            }
            System.out.println("Total number of vowels is " + vowelsCnt);
        }
    }

    public static boolean contains(final char[] vowels, final char target) {
        int length = vowels.length;
        for (int i = 0; i < length; i++) {
            if (vowels[i] == target)
                return true;
        }
        return false;
    }
}
