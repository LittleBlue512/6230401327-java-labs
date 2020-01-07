/**
 * This program is to create a class "Teacher" which extends from class "PersonV2".
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: January 7, 2020
 */

package sirimul.chattipoom.lab4;

public class Teacher extends PersonV2 {
    private String teachingSubject;
    private int salary;

    public Teacher(String _name, double _height, double _weight, String str_dob, String _teachingSubject, int _salary) {
        // Initialize the first four variables (PersonV2's variables).
        super(_name, _height, _weight, str_dob);

        // Initialize Student's variables.
        this.teachingSubject = _teachingSubject;
        this.salary = _salary;
    }

    // Get this object's teaching subject.
    public String getTeachingSubject() {
        return this.teachingSubject;
    }

    // Set this object's teaching subject.
    public void getTeachingSubject(String _teachingSubject) {
        this.teachingSubject = _teachingSubject;
    }

    // Get this object's salary.
    public int getSalary() {
        return this.salary;
    }

    // Set this object's salary.
    public void setSalary(int _salary) {
        this.salary = _salary;
    }

    @Override
    public String toString() {
        String output = "";

        // Get "toString"'s output from "PersonV2" class.
        output += super.toString();

        // Add the teaching subject and salary to the output.
        output += String.format(", teachingSubject=%s, salary=%d", this.teachingSubject, this.salary);

        return output;
    }
}