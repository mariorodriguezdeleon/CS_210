/* Mario Rodriguez, CS 210
 * October 11, 2020
 * Bellevue College
 * Coding Quiz #3 - Two methods:
 *  - minAngle => returns smallest angle
 *  - replaceSpaces => replaces empty spaces in a string with a pipe |
 */

public class Quiz3 {
    public static void main (String [] args) {

        System.out.println(minAngle(6.6, 2.2, 0.4));
        System.out.println(replaceSpaces("Mark the spaces ?"));
        
    }

    public static double minAngle(double a, double b, double c) {
        double smallestAngle = Math.min(Math.min(Math.toDegrees(a), Math.toDegrees(b)), Math.toDegrees(c));
        return Math.toRadians(smallestAngle);
    }

    public static String replaceSpaces (String str) {

        StringBuilder strSpacesReplaced = new StringBuilder();

        for (char c : str.toCharArray()) {

            if (c == ' ') {
                strSpacesReplaced.append("|");
            } else {
                strSpacesReplaced.append(c);
            }
        }
        return String.valueOf(strSpacesReplaced);
    }
}
