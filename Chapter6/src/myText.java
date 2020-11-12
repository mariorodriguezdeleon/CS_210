import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class myText {

    public static void main (String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(new File("src/BCwebSiteHTML.txt"));
        System.out.println(countHref(input));

    }

    public static int countHref (Scanner input) {

        int count = 0;

        while (input.hasNext()) {

            String text = input.next();
            String url = null;

            if (text.contains("href=\"http")) {

                url = text.substring(6);
//                System.out.println(url);

                if (url.contains("%")) {
                    String fixedText = cleanText(url);
                    System.out.println(fixedText);
                } else {
                    System.out.println(url);
                }

                count += 1;

            }
        }

        return count;

    }

    public static String cleanText (String text) {

        StringBuilder fixedString = new StringBuilder();

        char[] chars = text.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            StringBuilder hexString = new StringBuilder();

            if (chars[i] == '%') {

                hexString.append(chars[i+1]);
                hexString.append(chars[i+2]);

                String hex = String.valueOf(hexString);

                int decimal = Integer.parseInt(hex, 16);
                char c = (char) decimal;

                fixedString.append(c);

//                System.out.println(chars[i+1] + " " + chars[i+2] + " " + hexString + " " + decimal + " " + c);
                i+=2;

            } else {
                fixedString.append(chars[i]);
            }
        }
        return String.valueOf(fixedString);
    }

}
