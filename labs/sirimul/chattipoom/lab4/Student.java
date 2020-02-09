/**
 * This program is to create a class "Student" which extends from class "PersonV2".
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: January 7, 2020
 */

package sirimul.chattipoom.lab4;

public class Student extends PersonV2 {
    private String major;
    private double GPA;

    // Constructor with 6 parameters: name, height, weight, date of birth, major, GPA
    public Student(String _name, double _height, double _weight, String str_dob, String _major, double _GPA) {
        // Initialize the first four variables (PersonV2's variables).
        super(_name, _height, _weight, str_dob);

        // Initialize Student's variables.
        this.major = _major;
        this.GPA = _GPA;
    }

    // Get this object's major.
    public String getMajor() {
        return this.major;
    }

    // Set this object's major.
    public void setMajor(String _major) {
        this.major = _major;
    }

    // Get this object's GPA.
    public double getGPA() {
        return this.GPA;
    }

    // Set this object's GPA.
    public void setGPA(double _GPA) {
        this.GPA = _GPA;
    }

    @Override
    public String toString() {
        String output = "";

        // Get "toString"'s output from "PersonV2" class.
        output += super.toString();

        // Add the major and GPA to the output.
        output += String.format(", major=%s, GPA=%.1f", this.major, this.GPA);

        return output;
    }
}