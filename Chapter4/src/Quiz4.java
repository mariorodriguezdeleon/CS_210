public class Quiz4 {

    public static void main (String [] args) {

        System.out.println(convergentSeries(7));// -0.8312414965986396
        System.out.println(convergentSeries(777)); // -0.8224678605443936
        System.out.println(reverseStutter("12345"));// 5544332211
        System.out.println(reverseStutter("STOP")); // PPOOTTSS

    }

    public static double convergentSeries(int num) {

        double sum = 0.0;

        for (int i = 1; i <= num; i++) {
            sum += Math.pow(-1, i) / Math.pow(i, 2);
        }
        return sum;
    }

    public static String reverseStutter (String str) {

        StringBuilder reverseStr = new StringBuilder();
        char[] c = str.toCharArray();

            for (int i = str.length() ; i > 0; i--) {
//
                reverseStr.append(c[i - 1]);
                reverseStr.append(c[i - 1]);

            }

        return String.valueOf(reverseStr);

    }

}
