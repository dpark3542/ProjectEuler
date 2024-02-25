package solutions._000;

import static java.lang.StrictMath.ceilDiv;
import static utils.NumberTheory.gcd;

/**
 * Brute force.
 */
public class Problem073 {
    private static final int n = 12000;

    public static void main(String[] args) {
        int ans = 0;
        for (int b = 4; b <= n; b++) {
            for (int a = ceilDiv(b, 3); 2 * a < b; a++) {
                if (gcd(a, b) == 1) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
