package sirimul.chattipoom.lab4;

public class Person {
    private String name;
    private double height;
    private double weight;
    private static int numberOfPerson = 0;

    public Person() {
        this.name = "unknown";
        this.weight = 0.0f;
        this.height = 0.0f;
        Person.numberOfPerson++;
    }

    public Person(String _name) {
        this.name = _name;
        this.weight = 0.0f;
        this.height = 0.0f;
        Person.numberOfPerson++;
    }

    public Person(String _name, double _height, double _weight) {
        this.name = _name;
        this.height = _height; // cm
        this.weight = _weight; // kg
        Person.numberOfPerson++;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double _height) {
        this.height = _height;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double _weight) {
        this.weight = _weight;
    }

    @Override
    public String toString() {
        String output = "";
        output += String.format("Name: %s\n", this.name);
        output += String.format("Name: %.2f\n", this.height);
        output += String.format("Name: %.2f", this.weight);
        return output;
    }

    public String getBMI() {
        double height = this.getHeight() / 100; // cm -> m
        double weight = this.getWeight();
        return String.format("%.2f", weight / (height * height));
    }

    public static int getNumberOfPerson() {
        return Person.numberOfPerson;
    }
}