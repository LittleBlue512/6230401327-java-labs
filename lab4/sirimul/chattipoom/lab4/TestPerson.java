/**
 * This program is to create objects from the class "Person" and test the code.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: January 6, 2020
 */

package sirimul.chattipoom.lab4;

public class TestPerson {
    public static void main(String[] args) {
        Person unknown = new Person();
        System.out.println(unknown);
        System.out.println(Person.getNumberOfPerson() + " person has been created.");
        Person sala = new Person("Sala");
        Person mane = new Person("Mane", 175, 65);
        System.out.println(sala);
        System.out.println(mane);
        Person henderson = new Person("Henderson", 180, 100);
        System.out.println(henderson);
        System.out.println(mane.getName() + "'s BMI is " + mane.getBMI());
        System.out.println(henderson.getName() + "'s BMI is " + henderson.getBMI());
        henderson.setWeight(80);
        System.out.println(henderson.getName() + "'s BMI is " + henderson.getBMI());
        System.out.println(Person.getNumberOfPerson() + " persons have been created.");
    }
}