/* Mario Rodriguez, CS 210
 * September 30, 2020
 * Bellevue College
 * Coding Quiz #1 - DownRockets - This program prints out two rockets going down
 */

public class Assignment1 {

    public static void main (String [] args) {

        printA();
        printB();
        printC();
        printB();
        printA();

    }

    public static void printA() {

        twelveStars();
        sixStars();
        twelveStars();
        sixStars();
        sixStars();
        System.out.println();

    }

    public static void printB() {

        tenStars();
        fiveStars();
        tenStars();
        fiveStars();
        tenStars();
        System.out.println();

    }

    public static void printC() {

        twelveStars();
        threeStarsColumn();
        twelveStars();
        System.out.println();

    }

    public static void threeStarsColumn() {
        System.out.println("***\n***\n***\n***\n***\n***");
    }

    public static void fiveStars() {
        System.out.println("***       **\n***       **");
    }

    public static void sixStars() {
        System.out.println("***      ***\n***      ***");
    }

    public static void tenStars() {
        System.out.println("**********\n**********");
    }

    public  static void twelveStars( ){
        System.out.println("************\n************");
    }

}
