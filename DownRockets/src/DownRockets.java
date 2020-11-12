/* Mario Rodriguez, CS 210
 * September 30, 2020
 * Bellevue College
 * Coding Quiz #1 - DownRockets - This program prints out two rockets going down
 */

public class DownRockets {

    public static void main(String[] args) {

        doubleV();
        doubleSquare();
        dblSquareQuotes();
        doubleSquare();
        doubleV();

    }

    public static void doubleV() {

        System.out.println(" \\    /    \\    /");
        System.out.println("  \\  /      \\  /");
        System.out.println("   \\/        \\/");

    }

    public static void dblSquareQuotes() {
        System.out.println("+------+  +------+");
        System.out.println("|\"show\"|  |\"show\"|");
        System.out.println("|quotes|  |quotes|");
        System.out.println("+------+  +------+");
    }

    public static void doubleSquare() {

        System.out.println("+------+  +------+");
        System.out.println("|      |  |      |");
        System.out.println("|      |  |      |");
        System.out.println("+------+  +------+");

    }

}
