/**
 * This program is to create a class "Rectangle" which extends from "Shape" class.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: January 13, 2020
 */

package sirimul.chattipoom.lab5;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rectangle extends Shape {
    protected double width;
    protected double length;

    public Rectangle() {
        super();
        this.width = 1.0;
        this.length = 2.0;
    }

    public Rectangle(double _width, double _length) {
        super();
        this.width = _width;
        this.length = _length;
    }

    public Rectangle(double _width, double _length, String _color, boolean _filled) {
        super(_color, _filled);
        this.width = _width;
        this.length = _length;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double _width) {
        this.width = _width;
    }

    public double getLength() {
        return this.length;
    }

    public void setLength(double _length) {
        this.length = _length;
    }

    @Override
    public double getArea() {
        // Calculate the area of this rectangle.
        double area = this.width * this.length;

        // Round the area to two decimal places.
        BigDecimal bd = BigDecimal.valueOf(area);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Override
    public double getPerimeter() {
        // Calculate the perimeter of this rectangle.
        double perimeter = 2 * (this.width + this.length);

        // Round the perimeter to two decimal places.
        BigDecimal bd = BigDecimal.valueOf(perimeter);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Override
    public String toString() {
        String output = "";

        // Get the string from super's toString method.
        output += super.toString();

        // Add this rectangle's width and height to the output.
        output += String.format(", width:%.1f, length:%.1f", this.width, this.length);

        return output;
    }
}