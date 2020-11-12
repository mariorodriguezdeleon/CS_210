/* Mario Rodriguez, CS 210
 * October 26, 2020
 * Bellevue College
 * Coding Assignment #5 - Recommended Practice-It methods to cover.
 *  - gcd()
 *  - toBinary()
 *  - consecutive()
 *  - digitSum()
 *  - digitRange()
 */


public class Chapter5 {

    public static void main (String [] args) {

            int score=0;

            if (Chapter5.gcd(927686892, 2) == 2) score+=2; // else print comment
            if (Chapter5.gcd(0, 0) == 0) score+=2; // else print comment
            if (Chapter5.toBinary(88).equals("1011000")) score+=2; // else print comment
            if (Chapter5.toBinary(0).equals("0")) score+=2; // else print comment
            if (Chapter5.consecutive(984753,984754,984755)) score+=2; // else print comment
            if (!Chapter5.consecutive(0, 0, 0)) score+=2; // else print comment
            if (Chapter5.digitSum(568679) == 41) score+=2; // else print comment
            if (Chapter5.digitSum(0) == 0) score+=2; // else print comment
            if (Chapter5.digitRange(799857) == 5) score+=2; // else print comment
            if (Chapter5.digitRange(0) == 1) score+=2; // else print comment

            System.out.println("Your total score: " + score );
        }


    //return the greatest common divisor
    public static int gcd (int num1, int num2) {

        while (num2 != 0) {

            int mod = num1 % num2;

            num1 = num2;
            num2 = mod;
        }
        return Math.abs(num1);

    }

    //return the binary representation of the int
    public static String toBinary (int num) {

        StringBuilder binary = new StringBuilder();

        binary.append(num % 2);
        num /= 2;

        while (num != 0) {
            binary.insert(0 ,num % 2);
            num /= 2;

        }

        return binary.toString();

    }

    //return boolean true if numbers given are consecutive
    public static Boolean consecutive (int num1, int num2, int num3) {
        //to binary code
        if (num1 == num2 || num2 == num3 || num1 == num3) {
            return false;
        } else {

            int minNum = Math.min(Math.min(num1, num2), num3);
            int maxNum = Math.max(Math.max(num1, num2), num3);

            return maxNum - minNum == 2;

        }
    }

    //return sum of a given number
    public static int digitSum (int num) {

        int posNum = Math.abs(num);
        int sum = 0;

        while (posNum != 0) {
            sum += posNum % 10;
            posNum /= 10;
        }

        return sum;
    }

    //return the range of a given int
    public static int digitRange(int num) {

        int posNum = Math.abs(num);
        int min = 10;
        int max = 0;

        if (posNum / 10 == 0) {
            return 1;
        }

        while (posNum != 0) {
            int digit = posNum % 10;
            posNum /= 10;

            if(digit > max) {
                max = digit;
            } else if ( digit < min){
                min = digit;
            }
        }

        return max - min + 1;

    }

}
