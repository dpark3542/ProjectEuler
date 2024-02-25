package solutions._000;

import java.util.Arrays;

/*
 * Brute force: test every number x.
 */
public class Problem052 {
    public static void main(String[] args) {
        int x = 0;
        out: while (true) {
            x += 9;
            String s = toSortedString(x);
            for (int i = 2; i <= 6; i++) {
                if (!s.equals(toSortedString(i * x))) {
                    continue out;
                }
            }
            break;
        }
        System.out.println(x);
    }

    private static String toSortedString(int x) {
        char[] c = Integer.toString(x).toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
