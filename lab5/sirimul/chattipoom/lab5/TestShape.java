/**
 * This program is to test the class "circle".
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: January 13, 2020
 */

package sirimul.chattipoom.lab5;

public class TestShape {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        System.out.println(c1);
        System.out.println("Circle 1 : Area = " + c1.getArea() + " Perimeter = " + c1.getPerimeter());
        if (c1.isFilled())
            System.out.println("Circle is filled.");
        else
            System.out.println("Circle is NOT filled.");

        Circle c2 = new Circle(2.0);
        System.out.println(c2);
        System.out.println("Circle 2 : Area = " + c2.getArea() + " Perimeter = " + c2.getPerimeter());

        Circle c3 = new Circle(3.0, "Red", true);
        System.out.println(c3);
        System.out.println("Circle 3 : Area = " + c3.getArea() + " Perimeter = " + c3.getPerimeter());
        if (c3.isFilled())
            System.out.println("Circle is filled.");
        else
            System.out.println("Circle is NOT filled."); 
    }
}