/* Mario Rodriguez, CS 210
 * November 18, 2020
 * Bellevue College
 * Coding Quiz #7 - Count Unique Values in an array
 */

import java.util.Arrays;

public class Quiz7 {

    public static void main (String[] args) {

        int[] list1 = {1, 11, 1, 1, 1, 1, 22};
        int[] list2 = {0, 11, 0, 0, 22,0, -3};
        int[] list3 = {2, 2, 5, 8, 9, 10, 10};
        int[] list4 = {16, -4, 5, -4, 9, 50, 17};

        int score = 20;

        System.out.println(countUniqueValues(list1));
        if (countUniqueValues(list1) == 3) score+=5;

        System.out.println(countUniqueValues(list2));
        if (countUniqueValues(list2) == 4) score+=5;

        System.out.println(countUniqueValues(list3));
        if (countUniqueValues(list3) == 5) score+=5;

        System.out.println(countUniqueValues(list4));
        if (countUniqueValues(list4) == 6) score+=5;

        System.out.println(score); // also need to test other arrays

    }

    public static int countUniqueValues (int[] array) {

        if (array.length == 1) {
            return 1;
        }

        if (array.length == 0) {
            return 0;
        }

        int numOfUniqueValues = 1;

        for (int i = 0; i < array.length; i++) { //sort array

            int min = array[i];

            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    array[i] = array[j];
                    array[j] = min;
                    min = array[i];
                }
            }
        }

        for (int i = 0; i < array.length - 1; i++) { //compare numbers until the end of the array, add 1 for offset

            if (array[i] != array[i + 1]) {
                numOfUniqueValues++;
            }
        }

        return numOfUniqueValues;
    }
}
