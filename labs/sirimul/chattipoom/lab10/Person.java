package sirimul.chattipoom.lab10;

import java.time.LocalDate;

public class Person {
    protected String name;
    protected double weight, height;
    protected LocalDate dob;

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
        return String.format("%s is %d years %d months %d days, has weight as %.1f kg., and height as %.1f cm.", name,
                dob.getYear(), dob.getMonth(), dob.getDayOfMonth(), weight, height);
    }
}