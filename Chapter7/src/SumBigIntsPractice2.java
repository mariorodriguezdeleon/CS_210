import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SumBigIntsPractice2 {

    public static final int MAX_DIGITS = 50;

    public static void main (String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(new File("src/sum.txt"));
        processFile(input);

    }

    public static void processFile(Scanner input) {



        while (input.hasNextLine()) {

            String line = input.nextLine();
//            int[] numsArray = new int[][line.length()];
            Scanner numbers = new Scanner(line);

            for (Scanner it = numbers; it.hasNext();) {
                String n = it.next();

                System.out.print(n + "  ");
            }
            System.out.println();
        }

    }

}
