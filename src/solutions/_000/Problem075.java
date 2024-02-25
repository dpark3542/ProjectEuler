package solutions._000;

import static utils.NumberTheory.gcd;

/**
 * Iterate through Pythagorean triples and keep count of perimeter.
 */
public class Problem075 {
    private static final int LIM = 1500000;

    public static void main(String[] args) {
        int[] cnt = new int[LIM + 1];

        for (int m = 2; 2 * m * (m + 1) <= LIM; m++) {
            for (int n = m % 2 == 0 ? 1 : 2; n < m && 2 * m * (m + n) <= LIM; n += 2) {
                if (gcd(n, m) == 1) {
                    int d = 2 * m * (m + n);
                    for (int i = d; i <= LIM; i += d) {
                        cnt[i]++;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 12; i <= LIM; i++) {
            if (cnt[i] == 1) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
