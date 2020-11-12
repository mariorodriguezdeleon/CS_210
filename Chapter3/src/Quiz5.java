/* Mario Rodriguez, CS 210
 * October 28, 2020
 * Bellevue College
 * Coding Quiz #5
 */

import java.util.Random;

public class Quiz5 {

    public static void main (String [] args) {

        System.out.println((randomString(5)));
        System.out.println((randomInt(5)));

    }

    public static String randomString (int num) {

        Random random = new Random();

        int line = random.nextInt(num) + 2;

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < line; i++) {

            int numOfChar = 0;

            while (numOfChar <= 0) {
                int letter = random.nextInt(22) + 97;
                str.append((char) letter);
                numOfChar++;
            }
        }
        return String.valueOf(str);
    }

    public static int randomInt (int num) {

        int count = num;
        String str = "";

        for (int i = 0; i < count; i++) {
            Random random = new Random();
            int nextInt = random.nextInt(9);
            str += nextInt;
        }

        int number = Integer.parseInt(str);
        return number;

    }

}
