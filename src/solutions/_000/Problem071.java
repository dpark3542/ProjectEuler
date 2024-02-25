package solutions._000;

import static java.lang.StrictMath.ceilDiv;
import static utils.NumberTheory.gcd;

/*
 * Brute force: iterate through each denominator d and find corresponding numerator n minimizing the difference 3/7 - n/d.
 */
public class Problem071 {
    private static final int m = 1000000;

    public static void main(String[] args) {
        int p = 2, q = 5;
        for (int d = 6; d <= m; d++) {
            for (int n = ceilDiv(3 * d, 7) - 1; p * d < q * n; n--) {
                if (gcd(n, d) == 1) {
                    p = n;
                    q = d;
                    break;
                }
            }
        }
        System.out.println(p);
    }
}
