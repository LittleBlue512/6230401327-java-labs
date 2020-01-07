package sirimul.chattipoom.lab4;

public class TestPersonV3 {
    public static void main(String[] args) {
        Teacher onizuka = new Teacher("Onizuka", 185, 80, "1998-07-07", "social study", 15000);
        Student zuckerberg = new Student("Zuckerberg", 180, 25, "1984-05-14", "Computer Engineering", 4.00);
        System.out.println(onizuka);
        System.out.println(zuckerberg);
        onizuka.howOld();
        zuckerberg.howOld();
        System.out.println(Person.getNumberOfPerson() + " persons has been created.");
        PersonV2 mickey = new PersonV2("mickey", 60, 25, "1982-01-01");
        System.out.println(mickey);
        mickey = new Student("mickey", 60, 25, "1982-01-01", "Animation", 3.00);
        System.out.println(mickey);
        System.out.println(Person.getNumberOfPerson() + " persons has been created.");
    }
}