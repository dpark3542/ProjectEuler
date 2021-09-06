package solutions._000;

import static utils.NumberTheory.gcd;

/**
 * Iterate through Pythagorean triples and keep count of perimeter.
 */
public class Problem075 {
    public static void main(String[] args) {
        int lim = 1500000;
        int[] cnt = new int[lim + 1];

        for (int m = 2; m <= 865; m++) {
            int lo = m % 2 == 0 ? 1 : 0;
            int hi = java.lang.Math.min(java.lang.Math.floorDiv(lim, 2 * m) - m, m - 1);
            for (int n = lo; n <= hi; n += 2) {
                if (gcd(n, m) == 1) {
                    int d = 2 * m * (m + n);
                    for (int i = d; i <= lim; i += d) {
                        cnt[i]++;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 12; i <= lim; i++) {
            if (cnt[i] == 1) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
