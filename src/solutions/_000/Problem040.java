package solutions._000;

import static java.lang.Integer.parseInt;

/*
 * Brute force: find the decimal representation of the constant to enough decimal places to find the desired digits.
 */
public class Problem040 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; sb.length() < 1000000; i++) {
            sb.append(i);
        }
        int prod = 1;
        for (int i = 1; i <= 1000000; i *= 10) {
            prod *= parseInt(sb.substring(i - 1, i));
        }
        System.out.println(prod);
    }
}
