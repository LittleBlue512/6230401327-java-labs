package sirimul.chattipoom.lab5;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Circle extends Shape {
    protected double radius;

    // Constructor without parameters.
    public Circle() {
        super();
        this.radius = 1.0;
    }

    // Constructor with 1 parameter: radius.
    public Circle(double _radius) {
        super();
        this.radius = _radius;
    }

    // Constructor with 3 parameters: radius, color, filled.
    public Circle(double _radius, String _color, boolean _filled) {
        // Initialize 2 variables (Shape class's variables)
        super(_color, _filled);

        // Initialize the radius variable (Circle class's variable)
        this.radius = _radius;
    }

    // Getter for radius.
    public double getRadius() {
        return this.radius;
    }

    // Setter for radius.
    public void setRadius(double _radius) {
        this.radius = _radius;
    }

    // Get the area of this circle.
    @Override
    public double getArea() {
        // Calculate the area of this circle.
        double area = Math.PI * Math.pow(this.radius, 2);

        // Code from searching google ~
        BigDecimal bd = BigDecimal.valueOf(area);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    // Get the perimeter of this circle.
    @Override
    public double getPerimeter() {
        // Calculate the perimeter of this circle.
        double perimeter = 2 * Math.PI * this.radius;

        // Code from searching google ~
        BigDecimal bd = BigDecimal.valueOf(perimeter);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Override
    public String toString() {
        String output = "";

        // Get the string from super's toString method.
        output += super.toString();

        // Add this circle's radius to the output.
        output += String.format(", radius:%.1f", this.radius);

        return output;
    }
}