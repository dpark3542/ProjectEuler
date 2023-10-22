package solutions._100;

import java.math.BigInteger;

/**
 * \[\dbinom{n+9}{9}+\dbinom{n+10}{10}-10n-2\]
 */
public class Problem113 {
    private static final int n = 100;
    public static void main(String[] args) {
        System.out.println(binomial(n + 9, n) + binomial(n + 10, n) - 10 * n - 2);
    }

    private static long binomial(int a, int b) {
        BigInteger ans = BigInteger.ONE;
        for (int i = b + 1; i <= a; i++) {
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        for (int i = 2; i <= a - b; i++) {
            ans = ans.divide(BigInteger.valueOf(i));
        }
        return ans.longValue();
    }
}
