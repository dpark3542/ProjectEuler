package solutions._000;

import static utils.Utils.gcd;

/*
 * Brute force: iterate through each denominator d and find corresponding numerator n minimizing the difference 3/7 - n/d.
 *
 */
public class Problem071 {
    public static void main(String[] args) {
        int p = 2, q = 5; // p/q is closest fraction less than 3/7
        for (int d = 6; d <= 1000000; d++) {
            // for all n such that p/q < n/d < 3/7
            for (int n = (int) Math.ceil((double) 3 * d / 7) - 1; n > (double) p * d / q; n--) {
                // if fraction reduced, update p/q
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
