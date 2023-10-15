package solutions._100;

import utils.structs.BigFraction;

/**
 * Lagrangian interpolation.
 */
public class Problem101 {
    private static final int n = 10;

    public static void main(String[] args) {
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; ; j++) {
                BigFraction p = BigFraction.ZERO;
                for (int k = 1; k <= i; k++) {
                    BigFraction q = new BigFraction(u(k));
                    for (int l = 1; l <= i; l++) {
                        if (k != l) {
                            q = q.multiply(new BigFraction(j - l, k - l));
                        }
                    }
                    p = p.add(q);
                }
                if (!p.equals(new BigFraction(u(j)))) {
                    ans += p.longValue();
                    break;
                }
            }
        }
        System.out.println(ans);
    }

    public static long u(int x) {
        long ans = 0, p = 1;
        for (int i = 0; i <= n; i++) {
            ans += p;
            p *= -x;
        }
        return ans;
    }
}
