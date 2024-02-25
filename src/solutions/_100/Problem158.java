package solutions._100;

import static java.lang.StrictMath.max;

/*
 * p(n) = (26 choose n) * (2^n - n - 1)
 */
public class Problem158 {
    private static final int n = 26;

    public static void main(String[] args) {
        int[] c = new int[n + 1];
        c[0] = 1;
        c[n] = 1;
        for (int i = 1; i <= n / 2; i++) {
            c[i] = (c[i - 1] * (n - i + 1)) / i;
            c[n - i] = c[i];
        }

        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = max(ans, c[i] * (long) ((1 << i) - i - 1));
        }
        System.out.println(ans);
    }
}
