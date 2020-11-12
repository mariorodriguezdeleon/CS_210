/* Mario Rodriguez, CS 210
 * October 5, 2020
 * Bellevue College
 * Coding Assignment #2 - This program calls static methods ->
 * - fibonacci() -> Prints the first 12 Fibonacci numbers in the series
 * - numberTriangle() -> Prints a triangle of numbers in ascending order from 1 - 7
 *   with each level printing the same number as many times incremented
 * - spacesAndNumbers() -> Prints a triangle of numbers in ascending order from 1 - 5
 *   with spaces to the left of the number replaced by the incremented number
 * - starFigure -> Prints a pyramid of stars
 */

public class Chapter2 {

    public static void main(String [] args) {

        fibonacci();
        numberTriangle();
        spacesAndNumbers();
        starFigure();

    }

    public static void fibonacci () {

        int k1 = 1;
        int k2 = 1;

        for (int i = 0; i < 12; i++) {

            int k = k1;

            if (i < 2) {
                System.out.print ( k + " ");
            } else {
                k = k1 + k2;
                k2 = k1;
                k1 = k;

                System.out.print(k + " ");
            }
        }

        System.out.println();
        System.out.println();
    }

    public static void numberTriangle() {

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }

            System.out.println();

        }

        System.out.println();

    }

    public static void spacesAndNumbers() {

        for (int i = 1; i <= 5; i++) {

            for (int j = 5; j > i; j--) {
                System.out.print(" ");
            }

            for (int k = 1; k <= i; k++) {
                System.out.print(i);
            }

            System.out.println();
        }
        System.out.println();
    }

    public static void starFigure() {

        for (int i = 1; i <= 5; i++) {

            for (int j = 1; j <= 20 - i * 4; j++){
                System.out.print("/");
            }

            for (int k = 1; k <= 8 * i - 8; k++){
                System.out.print("*");
            }

            for (int l = 1; l <= 20 - i * 4; l++){
                System.out.print("\\");
            }

            System.out.println();

        }

        System.out.println();

    }

}