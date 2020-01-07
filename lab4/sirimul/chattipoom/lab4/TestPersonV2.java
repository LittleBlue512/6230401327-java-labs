/**
 * This program is to create objects from the class "PersonV2" and test the code.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: January 7, 2020
 */

package sirimul.chattipoom.lab4;

public class TestPersonV2 {
    public static void main(String[] args) {
        PersonV2 doraemon = new PersonV2("Doraemon", 100, 100, "2017-05-26");
        PersonV2 nobita = new PersonV2("Nobita", 120, 25, "2012-01-05");
        System.out.println(doraemon);
        System.out.println(nobita);
        doraemon.howOld();
        nobita.howOld();
        doraemon.compareAge(nobita);
        nobita.compareAge(doraemon);
        doraemon.isBirthdat();
        nobita.isBirthdat();
        System.out.println(Person.getNumberOfPerson() + " persons have been created.");
    }
}