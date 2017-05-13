package solutions;

/**
 * Created by dpark on 5/6/2017.
 */
public class Problem004 {
    public static void main(String[] args) {
        int ans = 101 * 101;
        for (int i = 100; i < 999; i++) {
            for (int j = 100; j < 999; j++) {
                if (ans < i * j && isPalindrome(i * j)) {
                    ans = i * j;
                }
            }
        }
        System.out.println(ans);
    }

    private static boolean isPalindrome(int x) {
        return Integer.toString(x).equals(new StringBuilder(Integer.toString(x)).reverse().toString());
    }
}
