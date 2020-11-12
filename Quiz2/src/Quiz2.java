/* Mario Rodriguez, CS 210
 * October 7, 2020
 * Bellevue College
 * Coding Quiz #2 - Prints hourglass
 */

public class Quiz2 {

    public static void main (String [] args) {

         triangleDown();
         triangleUp();
    }

    public static void triangleUp() {

        for (int i = 9; i >= 1; i--) {

            for (int j = 1; j <= i - 1; j++){
                System.out.print(" ");
            }

            for (int k = 1; k <= 21 - i * 2; k++){
                System.out.print("*");
            }

            System.out.println();

        }

    }

    public static void triangleDown() {

        for (int i = 1; i <= 10; i++) {

            for (int j = 1; j <= i - 1; j++){
                System.out.print(" ");
            }

            for (int k = 1; k <= 21 - i * 2; k++){
                System.out.print("*");
            }

            System.out.println();

        }
    }

}
