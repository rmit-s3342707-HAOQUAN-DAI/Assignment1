package ozlympic;

import java.util.*;

public class Utility {
    //final static String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
    final static String[] firstNames = {
            "John", "Jack", "Albert", "Bob", "Charlie", "Donald", "Elan", "Frank", "George", "Harry", "Ian", "Kevin", "Michael"
    };

    final static String[] lastNames = {
            "Adam", "Bill", "Crown", "Dixon", "Evans", "Fernando", "Gordon", "Hamilton", "Doe" ,"Joe","Puppy"
    };
    
    final static String[] stateNames ={
    		"VIC","QLD","NT","ACT","NSW","TAS","SA","WA"
    };
    
    final static java.util.Random rand = new java.util.Random();
    //final static Set<String> identifiers = new HashSet<String>();

    static int GetRandom(int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }

    static String GetPersonName() {
        int firstNameIndex = GetRandom(0, firstNames.length - 1);
        int lastNameIndex = GetRandom(0, lastNames.length - 1);
        int stateNameIndex = GetRandom(0,stateNames.length -1);
        return firstNames[firstNameIndex] + " " + lastNames[lastNameIndex] + " "+ stateNames[stateNameIndex];
    }

}