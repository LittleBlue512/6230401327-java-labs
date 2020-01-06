/**
 * This program is to create a class named "Person".
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: January 6, 2020
 */

package sirimul.chattipoom.lab4;

public class Person {
    // Object's variables. (Access through class's methods)
    private String name;
    private double height;
    private double weight;

    // Class's variable.
    private static int numberOfPerson = 0;

    // Constructor with no parameters.
    public Person() {
        this.name = "unknown";
        this.weight = 0.0f;
        this.height = 0.0f;
        Person.numberOfPerson++;
    }

    // Constructor with a parameter: name
    public Person(String _name) {
        this.name = _name;
        this.weight = 0.0f;
        this.height = 0.0f;
        Person.numberOfPerson++;
    }

    // Constructor with 3 parameters: name, height, weight
    public Person(String _name, double _height, double _weight) {
        this.name = _name;
        this.height = _height; // cm
        this.weight = _weight; // kg
        Person.numberOfPerson++;
    }

    // Get the object's name.
    public String getName() {
        return this.name;
    }

    // Set the object's name.
    public void setName(String _name) {
        this.name = _name;
    }

    // Get the object's height.
    public double getHeight() {
        return this.height;
    }

    // Set the object's height.
    public void setHeight(double _height) {
        this.height = _height;
    }

    // Get the object's weight.
    public double getWeight() {
        return this.weight;
    }

    // Set the object's weight.
    public void setWeight(double _weight) {
        this.weight = _weight;
    }

    // Show infomations of the object.
    @Override
    public String toString() {
        String output = String.format("name=%s, height=%.1f cm. weight=%.1f m.", this.name, this.height, this.weight);
        return output;
    }

    // Get BMI value of the object.
    public String getBMI() {
        double height = this.getHeight() / 100; // cm -> m
        double weight = this.getWeight();
        return String.format("%.2f", weight / (height * height));
    }

    // Get number of Person's objects.
    public static int getNumberOfPerson() {
        return Person.numberOfPerson;
    }
}