/**
 * This program is to test the class "DrawableRectangle" and "DrawableCircle".
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: January 13, 2020
 */

package sirimul.chattipoom.lab5;

public class TestShapeV3 {
    public static void main(String[] args) {
        DrawableRectangle r1 = new DrawableRectangle();
        System.out.println("First drawable rectangle " + r1);
        System.out.println(r1.draw());
        r1.moveUp(3);
        r1.moveRight(2);
        System.out.println("After move 3 up and 2 to the right " + r1.draw());

        DrawableCircle c1 = new DrawableCircle(2, 3, 5, "Red", true);
        System.out.println("First drawable circle " + c1);
        System.out.println(c1.draw());
        c1.moveDown(3);
        c1.moveLeft(2);
        System.out.println("After move 3 down and 2 to the left " + c1.draw());
    }
}