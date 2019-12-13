/**
 * This Athlete program is to accept three arguments: athlete name, the sport name 
*  that that athlete plays, and the nationality of that athlete.  Its output format is “My 
*  favorite athlete is <athlete_name> who plays <sport_name> and has 
* nationality as <athlete_nationality>”  
*
* Author: Chattipoom Sirimul
* ID: 623040132-7
* Sec: 1
* Date: December 13, 2019
*
**/

package sirimul.chattipoom.lab2;

public class Athlete {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.printf("Athlete <athlete name> <sport name> <nationality>");
        } else {
            String athletename = args[0], sportName = args[1], nationality = args[2];
            System.out.printf("My favorite athlete is %s who plays %s and has nationality as %s.", athletename, sportName, nationality);
        }
    }
}