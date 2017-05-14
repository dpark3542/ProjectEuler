package solutions.java;

/*
 * Created by dpark3542 on 5/13/2017.
 */
public class Problem036 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i  < 1000000; i++) {
            if (isPalindrome(Integer.toString(i)) && isPalindrome(Integer.toBinaryString(i))) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    private static boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
