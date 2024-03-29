package solutions._000;

import static java.lang.Integer.toBinaryString;
import static utils.Miscellaneous.isPalindrome;
import static utils.Miscellaneous.reverseString;

/**
 * Brute force: test all numbers less than one million.
 */
public class Problem036 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i < 1000000; i++) {
            if (isPalindrome(i)) {
                String s = toBinaryString(i);
                if (s.equals(reverseString(s))) {
                    sum += i;
                }
            }
        }
        System.out.println(sum);
    }
}
