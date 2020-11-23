/* Mario Rodriguez, CS 210
 * November 11, 2020
 * Bellevue College
 * Coding Quiz #6 - singleLineSpaces
 *  - This program takes in a plain text file which contains random text with random spacing and collapses it to
 *    one line with single spaces.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Quiz6 {

    public static void main (String [] args) throws FileNotFoundException {

        File file = new File("src/whatever.txt");
        Scanner text = new Scanner(file);
        System.out.println(singleSpacedLine(text));

    }

    public static String singleSpacedLine (Scanner text) {

        String cleanedString = "";

        while (text.hasNext()) {

            String line = text.nextLine();
            Scanner input = new Scanner(line);

            while (input.hasNext()) {
                cleanedString += " " + input.next();
            }
        }
        return cleanedString;
    }

}
