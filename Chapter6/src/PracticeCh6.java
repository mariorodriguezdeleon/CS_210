import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class PracticeCh6 {

    public static void main (String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(new File("C:\temp\new files\test.dat"));

        String[] input = {
                "src/evenNumbers.txt",
                "src/flipLines",
                "src/whatever.txt"
        };

        File file = new File(input[1]);
        Scanner text = new Scanner(file);

//        evenNumbers(text);
//        negativeSum(text);
        flipLines(text);

    }

    /*
     * Write a method named evenNumbers that accepts a Scanner as a parameter
     * reading input from a file containing a series of integers, and report
     * various statistics about the integers. You may assume that there is at
     * least one integer in the file. Report the total number of numbers, the
     * sum of the numbers, the count of even numbers and the percent of even
     * numbers.
     */
    public static void evenNumbers (Scanner input) {

        int totalNum = 0;
        int sum = 0;
        int evenNum = 0;

        while (input.hasNext()) {

            int num = input.nextInt();
            totalNum++;
            sum += num;

            if (num % 2 == 0) {
                evenNum++;
            }

        }

        System.out.printf("%d numbers, sum = %d\n", totalNum, sum);
        System.out.printf("%d evens (%.2f%%)\n", evenNum, 100.0 * evenNum / totalNum);

    }

    /*
     * Write a method named negativeSum that accepts a Scanner as a parameter reading
     * input from a file containing a series of integers, and determine whether the
     * sum starting from the first number is ever negative. The method should print
     * a message indicating whether a negative sum is possible and should return true
     * if a negative sum can be reached and false if not.
     */
    public static boolean negativeSum (Scanner input) {

        int sum = 0;
        int steps = 0;

        while (input.hasNextInt()) {

            sum += input.nextInt();
            steps += 1;

            if (sum < 0) {
                System.out.printf("%d after %d steps", sum, steps);

                return true;
            }
        }
        System.out.println("no negative sum");
        return false;
    }

    /*
     * Write a method named countCoins that accepts as its parameter a Scanner for an
     * input file whose data represents a person's money grouped into stacks of coins.
     * Your method should add up the cash values of all the coins and print the total
     * money at the end. The input consists of a series of pairs of tokens, where each
     * pair begins with an integer and is followed by the type of coin, which will be
     * either "pennies" (1 cent each), "nickels" (5 cents each), "dimes" (10 cents each),
     * or "quarters" (25 cents each), case-insensitively. A given coin might appear more
     * than once on the same line.
     * You may assume that the file contains at least 1 pair of tokens. You may also assume
     * that the input is valid; that the input has an even number of tokens, that every
     * other token is an integer, and that the others are valid coin types.
     */
    public static void countCoins (Scanner input) {

        int cashSum = 0;

        while (input.hasNext()) {

            int cents = input.nextInt();
            String coinType = input.next().toLowerCase();

            if (coinType.equals("pennies")) {
                cashSum += cents * 1;
            } else if (coinType.equals("nickels")) {
                cashSum += cents * 5;
            } else if (coinType.equals("dimes")) {
                cashSum += cents * 10;
            } else {
                cashSum += cents * 25;
            }
        }

        if (cashSum % 100 < 10) {
            System.out.printf("Total money: $%d.0%d", cashSum / 100, cashSum % 100);
        } else {
            System.out.printf("Total money: $%d.%d", cashSum / 100, cashSum % 100);
        }
    }

    /*
     * Write a static method named collapseSpaces that accepts a Scanner representing
     * a file as a parameter and writes that file's text to the console, with multiple
     * spaces or tabs reduced to single spaces between words that appear on the same line.
     */
    public static void collapseSpaces (Scanner file) {

        while (file.hasNext()) {

            String line = file.nextLine();
            Scanner strgs = new Scanner(line);

            while (strgs.hasNext()) {
                System.out.println(strgs.next() + " ");
            }
            System.out.println();
        }
    }

    /*
     * Write a method named readEntireFile that accepts a Scanner representing an input
     * file as its parameter, then reads that file and returns the entire text contents
     * of that file as a String.
     */
    public static String readEntireFile (Scanner text) {

        String outPut = "";

        while (text.hasNextLine()) {
            outPut += text.nextLine() + "\n";
        }
        return outPut;
    }

    /*
     * Write a method named flipLines that accepts as its parameter a Scanner for
     * an input file and that writes to the console the same file's contents with
     * successive pairs of lines reversed in order.
     */
    public static void flipLines (Scanner input) {

        while (input.hasNextLine()) {

            String line = input.nextLine();

            if(input.hasNextLine()){

                System.out.println(input.nextLine());
            }

            System.out.println(line);
        }

    }

    /*
     * Write a method named doubleSpace that accepts a Scanner for an input
     * file and a PrintStream for an output file as its parameters, writing
     * into the output file a double-spaced version of the text in the input
     * file. You can achieve this task by inserting a blank line between each
     * line of output.
     */
    public static void doubleSpace (Scanner input, PrintStream output) {
        while (input.hasNextLine()) {
            output.println(input.nextLine());
            output.println();
        }
    }


}
