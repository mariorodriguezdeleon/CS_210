
import java.util.*;

// This is a very simple and easy program.
// But many people make mistake in real-world.
// let's practice ArrayList to avoid the mistakes.
//
// We want to create an app that creates sports teams.
// There is a list of people who want to be a team.
// Each team consists of two people; one captain and one member.
// The algorithm is that we remove the first two people from the list,
// then designates the first person as the captain and the second one becomes a member.
// We do this until the list is empty.
//
// Now, suppose there are 6 in the list(a, b, c, d, e, f).
// The expected output is
// Captain: a Member: b
// Captain: c Member: d
// Captain: e Member: f
//
// However, the following program produces different output.
//
// What's wrong with the program? Correct the program to get the correct results.
// Also use the comment lines at the top of your program to explain why
// this program produces incorrect output.



public class Quiz4ArrayListTest {

    public static void main(String args[]) {

        ArrayList<Character> myArrayList = new ArrayList<>();

        // create a list of people
        for (char c='a';c<='f';c++) {
            myArrayList.add(c);
        }

        System.out.println(myArrayList);

        // remove first two people from the list to make a team. Each team consists of captain and member.
        for (int i = 0; i < myArrayList.size(); i++){
            char captain = myArrayList.remove(i);
            char member = myArrayList.remove(i+1);
            System.out.println("Captain: "+ captain + " Member: "+member);
            System.out.println(myArrayList);
        }
    }

}
