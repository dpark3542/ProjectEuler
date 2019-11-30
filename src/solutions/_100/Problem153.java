package solutions._100;

import java.math.BigInteger;

/*
 * First, the sum of the real factors are sigma(n), where sigma(n) is the sum of the divisors of n.
 *
 * Next, we calculate the sum of the complex factors.
 * If x, y coprime, it can be proven that each complex factor x + yi divides n if and only if x^2 + y^2 divides n.
 * Each complex factor is a multiple of some x + yi.
 * We will sum the complex factors in groups based on x + yi.
 *
 * Iterate through all possible x + yi and find how many multiples of x^2 + y^2 are within upper bound 10^8.
 * For each multiple n, we have n = m(x^2 + y^2) = m(x + yi)(x - yi).
 * We want to sum the complex factors of n which are multiples of x + yi. Each multiple p(x + yi) must therefore satisfy p | m.
 * Sum over all p in which the sum is sigma(m) * x.
 * The complex factors come in conjugates, so we can ignore the imaginary part yi and only sum the real part x.
 *
 * Sum this over all multiples n, or from m = 1 to floor(n / (x^2 + y^2)).
 * We can make some optimizations/simplifications.
 * Then sum for each x is [sigma(1) + ... + sigma(floor(n / (x^2 + y^2)))]x.
 * We can compute sigma(1) + ... + sigma(t) using dynamic programming (stored in array a below).
 * Each sigma(t) is computed by using the fact that sigma is multiplicative and finding a prime power which divides t.
 * Also, restrict y > 0 and for each factor that is a multiple of x + yi, include the corresponding factor which is the same multiple of x - yi.
 * Then sum for each x is 2[sigma(1) + ... + sigma(floor(n / (x^2 + y^2)))]x.
 *
 */
public class Problem153 {
    public static void main(String[] args) {
        int n = 100000000;
        BigInteger s = BigInteger.ZERO;
        long[] a = new long[n / 2 + 1];
        // compute a[i], the sum of the divisors of i
        a[1] = 1;
        for (int i = 1; i < a.length; i++) {
            for (int d = 2; d <= Math.sqrt(i); d++) {
                if (i % d != 0) {
                    continue;
                }
                int j = i;
                while (j % d == 0) {
                    j /= d;
                }
                // prime power
                if (j == 1) {
                    a[i] = a[i / d] + i;
                }
                else {
                    a[i] = a[j] * a[i / j];
                }
                break;
            }
            // prime
            if (a[i] == 0) {
                a[i] = i + 1;
            }
        }
        // accumulate a
        for (int i = 2; i < a.length; i++) {
            a[i] += a[i - 1];
        }
        // go through each complex factor x + yi
        for (int x = 1; x < Math.sqrt(n); x++) {
            for (int y = 1; x * x + y * y <= n; y++) {
                if (gcd(x, y) == 1) {
                    s = s.add(BigInteger.TWO.multiply(BigInteger.valueOf(a[n / (x * x + y * y)]).multiply(BigInteger.valueOf(x))));
                }
            }
        }
        // go through each real factor d
        for (int d = 1; d <= n; d++) {
            s = s.add(BigInteger.valueOf((n / d) * d));
        }
        System.out.println(s);
    }

    private static int gcd(int x, int y) {
        while (y > 0) {
            int t = y;
            y = x % y;
            x = t;
        }
        return x;
    }
}
