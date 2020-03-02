package sirimul.chattipoom.lab10;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    protected String name;
    protected double weight, height;
    protected LocalDate dob;

    public Person() {
        this.name = "";
        this.weight = 0f;
        this.height = 0f;
        this.dob = null;
    }

    public Person(String name, double weight, double height, LocalDate dob) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.dob = dob;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        String name = this.getName();
        LocalDate dob = this.getDob();
        double weight = this.getWeight();
        double height = this.getHeight();

        Period diff = Period.between(dob, LocalDate.now());
        
        int ageYears = diff.getYears();
        int ageMonths = diff.getMonths();
        int ageDays = diff.getDays();

        return String.format("%s is %d years %d months %d days, has weight as %.1f kg., and height as %.1f cm.", name,
                ageYears, ageMonths, ageDays, weight, height);
    }
}