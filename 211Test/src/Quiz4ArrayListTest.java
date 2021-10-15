/* Mario Rodriguez, CS 211
 * 980384835
 * October 14, 2021
 * Bellevue College
 * Coding Quiz 4 - Arraylist
 */

import java.util.*;

// The reason that this program produces incorrect results is because when an element is removed from an ArrayList
// all other elements are shifted to close any gaps left by the removal of any element; elements can also be shifted
// when inserting a new element at the beginning or somewhere in the middle of the ArrayList.  The loop variable 'i'
// was also  incremented at the end of the loop, and incremented in the second call to populate the 'member',
// this index reference grew much faster than required.
//
// To correct the program I realized that the first element is removed and the ArrayList is then adjusted to reflect
// the change, i.e., the other elements are moved down. So, when 'a' is removed from index 0, 'b' takes it's place
// and all other elements are adjusted accordingly. With this in hand I simply changed the i variable in the loop
// to always be set to 0, that is to never be incremented.

public class Quiz4ArrayListTest {

    public static void main(String args[]) {

        ArrayList<Character> myArrayList = new ArrayList<>();

        // create a list of people
        for (char c = 'a';c <= 'h'; c++) {
            myArrayList.add(c);
        }

        // remove first two people from the list to make a team. Each team consists of captain and member.
        for (int i = 0; i < myArrayList.size(); i = 0){

            char captain = myArrayList.remove(0);
            char member = myArrayList.remove(0);

            System.out.println("Captain: "+ captain + " Member: "+member);

        }
    }

}
