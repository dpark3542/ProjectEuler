package solutions._000;

import java.math.BigInteger;

/*
 * Brute force: test all digit sums.
 * Some small optimizations can be made such as recursively calculating a^b by storing previous power(s).
 * Also, exclude powers a^b whose maximal possible digit sum based on the number of digits is less than the current maximum.
 * Bignums are necessary.
 *
 */
public class Problem056 {
    public static void main(String[] args) {
        int max = 0;
        for (int a = 2; a < 100; a++) {
            BigInteger x = BigInteger.valueOf(a).pow(99);
            for (int b = 99; b > 0; b--) {
                if (9 * x.toString().length() <= max) {
                    break;
                }
                max = Math.max(max, digitSum(x));
                x = x.divide(BigInteger.valueOf(a));
            }
        }
        System.out.println(max);
    }

    private static int digitSum(BigInteger x) {
        int ds = 0;
        while (!x.equals(BigInteger.ZERO)) {
            ds += x.mod(BigInteger.TEN).intValue();
            x = x.divide(BigInteger.TEN);
        }
        return ds;
    }
}
