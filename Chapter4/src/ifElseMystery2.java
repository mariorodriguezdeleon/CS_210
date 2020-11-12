/* Mario Rodriguez, CS 210
 * September 30, 2020
 * Bellevue College
 * Coding Quiz #1 - DownRockets - This program prints out two rockets going down
 */

public class ifElseMystery2 {

    public static void main (String [] args) {

//        ifElseMystery(10, 2);
//        ifElseMystery(3, 8);
//        ifElseMystery(4, 4);
//        ifElseMystery(10, 30);

//        System.out.println(evenOdd(20));
//        System.out.println(evenOdd(23));
//        System.out.println(evenOdd(90));
//        System.out.println(evenOdd(7));

        System.out.println(fractionSum(15));
        
    }

    public static void ifElseMystery(int a, int b) {
        if (a * 2 < b) {
            a = a * 3;
        }
        if (b < a) {
            b++;
        } else {
            a--;
        }
        System.out.println(a + " " + b);
    }

    public static String evenOdd (int num) {

        if (num % 2 == 0) {
            return "even";
        } else {
            return "odd";
        }
    }

    public static double fractionSum(int num) {
        double sum = 0.0;

        for (double i = 1.0; i <= num; i++) {
            sum += 1 / i;
        }
        return sum;
    }

}
