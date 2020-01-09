/**
 * This program is to create a class "PersonV2" which extends from class "Person".
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: January 7, 2020
 */

package sirimul.chattipoom.lab4;

import java.time.LocalDate;
import java.time.Period;

public class PersonV2 extends Person {
    private LocalDate dob;

    // Constructor with 4 parameters: name, height, weight, date of birth (Ex:2020-01-25)
    public PersonV2(String _name, double _height, double _weight, String str_dob) {
        // Initialize the first three variables (Person's variables).
        super(_name, _height, _weight);

        // Initialize new variables (PersonV2's variable).
        this.dob = LocalDate.parse(str_dob);
    }

    // Get the date of birth.
    public LocalDate getDOB() {
        return dob;
    }

    // Set the date of birth.
    public void setDOB(String str_dob) {
        // Convert "String" to "LocalDate" then store it in the "dob" variable.
        this.dob = LocalDate.parse(str_dob);
    }

    // Check if today is the birthday of this object.
    public void isBirthday() {
        // Get the curretn date.
        LocalDate currentDate = LocalDate.now();

        // Get days and months.
        int birthDay = this.dob.getDayOfMonth();
        int birthMonth = this.dob.getMonthValue();
        int currentDay = currentDate.getDayOfMonth();
        int currentMonth = currentDate.getMonthValue();
        
        // Check if today is "this"'s birthday.
        if (birthDay == currentDay && birthMonth == currentMonth) {
            System.out.printf("Today is %s's birthday.\n", this.getName());
        } else {
            System.out.printf("Today is NOT %s's birthday.\n", this.getName());
        }
    }

    // Calculate the age of this object (Ex:years months days old)
    public void howOld() {
        // Get this object's name.
        String name = this.getName();

        // Get the current date.
        LocalDate birthOfDate = this.dob;
        LocalDate currentDate = LocalDate.now();

        // Get the difference from birthOfDate to currentDate.
        Period intervalPeriod = Period.between(birthOfDate, currentDate.minusDays(1));

        // Get the amount of years, months and days.
        int diffYears = intervalPeriod.getYears();
        int diffMonths = intervalPeriod.getMonths();
        int diffDays = intervalPeriod.getDays();

        // Print the result.
        System.out.printf("%s is %d years %d months %d days old.\n", name, diffYears, diffMonths, diffDays);
    }

    public void compareAge(PersonV2 other) {
        // Get "this" and "other"'s name.
        String thisName = this.getName();
        String otherName = other.getName();

        // Get "this" and "other"'s date of birth.
        LocalDate thisDateOfBirth = this.dob;
        LocalDate otherDateOfBirth = other.getDOB();

        // Compare both birthday. The "compareTo" method returns 0 if both LocalDate are equal.
        int compareRes = thisDateOfBirth.compareTo(otherDateOfBirth);

        // Check compareRes
        if (compareRes == 0) {
            System.out.printf("%s and %s are the same age.\n", thisName, otherName);
        } else if (compareRes < 0) {
            // "this" is older than "other".
            // Get the difference from thisDateOfBirth to otherDateOfBirth.
            Period intervalPeriod = Period.between(thisDateOfBirth, otherDateOfBirth);

            // Get the amount of years, months and days.
            int diffYears = intervalPeriod.getYears();
            int diffMonths = intervalPeriod.getMonths();
            int diffDays = intervalPeriod.getDays();

            // Print the result.
            System.out.printf("%s is %d years %d months %d days older than %s.\n", thisName, diffYears, diffMonths, diffDays, otherName);
        } else {
            // "other" is older than "this".
            // Get the difference from thisDateOfBirth to otherDateOfBirth.
            Period intervalPeriod = Period.between(otherDateOfBirth, thisDateOfBirth);

            // Get the amount of years, months and days.
            int diffYears = intervalPeriod.getYears();
            int diffMonths = intervalPeriod.getMonths();
            int diffDays = intervalPeriod.getDays();

            // Print the result.
            System.out.printf("%s is %d years %d months %d days older than %s.\n", otherName, diffYears, diffMonths, diffDays, thisName);
        }
    }
    
    @Override
    public String toString() {
        String output = "";

        // Get "toString"'s output from "Person" class.
        output += super.toString();

        // Add the birthday to the output.
        output += String.format(", Birthday=%s", dob.toString());

        return output;
    }
}
