/* Mario Rodriguez, CS 210
 * October 11, 2020
 * Bellevue College
 * Coding Assignment #3 - Recommended Practice-It methods to cover.
 *  - largestAbsVal();
 *  - lastDigit();
 *  - scientific();
 *  - triangleArea();
 *  - padString();
 */

public class Chapter3 {

    public static void main(String[] args) {

        //Should return 53
        System.out.println(largestAbsVal(-27, -53, 11));

        //Should return 9
        System.out.println(lastDigit(73259));

        //Should return => 800.0
        System.out.println(scientific(8, 2));

        //Should return => 232.94241153931173
        System.out.println(triangleArea(18.8, 25.6, 27.7));

        //Should return => "   hello"
        System.out.println(padString("hello", 8));
    }

    //Practice problem 3.7
    //returns the absolute maximum of three given values
    public static int largestAbsVal(int num1, int num2, int num3) {
        return Math.max(Math.max(Math.abs(num1), Math.abs(num2)), Math.abs(num3));
    }

    //Practice problem 3.9
    //return the last digit of a given integer
    public static int lastDigit(int num) {
        int lastNum = num % 10;
        return (Math.abs(lastNum));
    }

    //Practice problem 3.12
    //returns the base multiplied by 10 to the given exponent
    public static double scientific(double base, double exp) {
        //returns computed base
        return base * Math.pow(10, exp);
    }

    //Practice problem 3.16 - Heron's Formula
    //returns computed area of a triangle given three sides
    public static double triangleArea(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return (Math.sqrt(s * (s - a) * (s - b) * (s - c)));
    }

    //Practice Problem 3.17
    //returns a new string with added padding if required, otherwise returns the same string
    public static String padString(String str, int padding) {

        StringBuilder paddedStr = new StringBuilder();

        if (str.length() >= padding) {
            return str;
        } else {
            for (int i = 1; i <= padding - str.length(); i++) {
                paddedStr.append(" ");
            }
            paddedStr.append(str);
        }
        return String.valueOf(paddedStr);
    }
}
