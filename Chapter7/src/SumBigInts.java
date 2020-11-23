/* Mario Rodriguez, CS 210
 * November 15, 2020
 * Bellevue College
 * Coding Assignment #7 - SumBigInts
 *  - This program reads all integers from an input text file and sums all integers on a line and prints the sum.  The
 *    program takes in a plain text file which contains an unknown number of lines of random integers in string format
 *    and parses each string token into an int array and adds it to an array of arrays -> then passes that model to a
 *    sum function that takes in the model and sums all int arrays in the [][]'s.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SumBigInts {

    public static final int MAX_DIGITS = 50;

    public static void main (String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(new File("src/sum.txt"));
        processFile(input);

    }

    //processes entire text file line by line
    public static void processFile(Scanner input) {

        while (input.hasNextLine()) {

            String line = input.nextLine();
            lineProcess(line);

            int[][] numbersToSum = lineProcess(line);
            int[] sum = sumIntegers(numbersToSum);

//            printSum(sum, numbersToSum);

        }

    }

    //processes each line -> parses out each token and translates into an array of arrays; aka create model
    public static int[][] lineProcess (String line) {

        String[] numbers = line.split(" ");

        int[][] numbersArray = new int [numbers.length][];

        for (int i = 0; i < numbers.length; i++) {

            int[] number = new int[numbers[i].length()];

            for (int j = 0; j < number.length ; j++) {

                char charNum = numbers[i].charAt(j);
                int num = Character.getNumericValue(charNum);
                number[j] = num;

            }
            numbersArray[i] = number;
        }
        return numbersArray;
    }

    //sum arrays. check to see if input is greater than MAX_Digit
    public static int[] sumIntegers (int[][] numbersToSum) {

        int totalNumbers = numbersToSum.length; //total numbers that need to be summed
        int largestInt = numbersToSum[0].length; //largest integer by size
        int[] sum = null; //sum placeholder

        for (int i = 1; i < numbersToSum.length; i++) {  //check to see which number is the longest int
            if (numbersToSum[i].length > largestInt) {
                largestInt = numbersToSum[i].length;
            }
        }

        if (largestInt > MAX_DIGITS) { //short-circuit if input is greater than MAX return flat array
            sum = new int[0];
            return sum;
        } else {
            sum = new int[1];
        }

        for (int i = 0; i < totalNumbers; i++) {

            int[] incrementSum = addNumbers(sum, numbersToSum[i]);
            sum = incrementSum;
            System.out.println(Arrays.toString(sum));

        }

        return sum;
    }

    public static int[] addNumbers (int[] num1, int[] num2){

        int size = num1.length;

        if(num2.length > size) {
            size = num2.length;
        }

        int[] sum = new int[size + 1];

        int i = 0;
        int j = 0;
        int k = 0;
        int carry = 0;
        int temp = 0;

        while(i < num1.length && j < num2.length) {

            temp = num1[i] + num2[j] + carry;

            if(temp < 10) {
                sum[k] = temp;
                carry = 0;
            } else {
                sum[k] = temp % 10;
                carry = temp / 10;
            }

            i++;
            j++;
            k++;

        }

        while(i < num1.length) {

            temp = num1[i] + carry;

            if(temp < 10) {
                sum[k] = temp;
                carry = 0;
            } else {
                sum[k] = temp % 10;
                carry = temp / 10;
            }

            i++;
            k++;

        }

        while(j < num2.length) {
            temp = num2[j] + carry;

            if(temp < 10)
            {
                sum[k] = temp;
                carry = 0;
            }
            else
            {
                sum[k] = temp % 10;
                carry = temp / 10;
            }

            j++;
            k++;
        }

        sum[k] = carry;

        return sum;

    }

//    public static void printSum (int[] sum, int[][] numbers) {
//
//        if (sum.length == 0) {
//            System.out.println("ArrayIndexOutOfBoundsException");
//        } else {
//
//            for (int i = 0; i < numbers.length; i++) {
//                System.out.print(Arrays.toString(numbers[i]) + " ");
//            }
//            System.out.println();
//        }
//
//    }

}
