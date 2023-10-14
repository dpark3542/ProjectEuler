package solutions._000;

import static utils.Miscellaneous.reverseString;

/**
 * Brute force: test all numbers less than one million.
 */
public class Problem036 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i < 1000000; i++) {
            if (isPalindrome(Integer.toString(i)) && isPalindrome(Integer.toBinaryString(i))) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    private static boolean isPalindrome(String s) {
        return s.equals(reverseString(s));
    }
}
