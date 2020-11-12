/* Mario Rodriguez, CS 210
 * November 9, 2020
 * Bellevue College
 * Coding Assignment #6 - Web Crawler (basic)
 *  - This program takes in a plain text HTML file and parses out the urls from the href tags.  It also
 *    does some light processing of special hexadecimal characters and translates them into their char equivalents;
 *    this light processing does not include translating special HTML chars such as &amp or &quot.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Chapter6 {

    public static void main (String[] args) throws FileNotFoundException{

        Scanner input = new Scanner(new File("src/BCwebSiteHTML.txt"));
        System.out.println(countHref(input));

    }

    public static int countHref (Scanner input) {  //token-based processing of entire file

        int count = 0;

        while (input.hasNext()) {

            String text = input.next();
            String url = null;

            if (text.contains("href=\"http")) { //assumption that all valid url links begin with "http" and all correspond to an href tag

                url = text.substring(6, text.length() - 1); //extract the substring for the url

                if (url.contains("%")) {  //testing to see if url needs to be cleaned from special characters
                    String fixedText = cleanText(url);
                    System.out.println(fixedText);
                } else {
                    System.out.println(url);
                }

                count += 1;

            }
        }

        return count;

    }

    public static String cleanText (String text) {

        StringBuilder fixedString = new StringBuilder();

        char[] chars = text.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            StringBuilder hexString = new StringBuilder(); //holder to build hex string

            if (chars[i] == '%') {

                hexString.append(chars[i+1]);
                hexString.append(chars[i+2]);

                String hex = String.valueOf(hexString);//need to extract the value of the StringBuilder obj

                int decimal = Integer.parseInt(hex, 16); //parse hex to decimal

                char c = (char) decimal; //cast decimal into it's char value

                fixedString.append(c);

                i+=2; //increment i to bypass the next two chars that make up the hex

            } else {

                fixedString.append(chars[i]);

            }
        }

        return String.valueOf(fixedString);

    }

}
