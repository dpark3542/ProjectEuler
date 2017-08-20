package solutions.java;

import java.util.Arrays;

public class Problem052 {
    /*
     * Brute force: test every number x.
     */
    public static void main(String[] args) {
        int x = 0;
        out:
        while (true) {
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
