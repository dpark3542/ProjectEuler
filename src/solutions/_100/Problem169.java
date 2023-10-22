package solutions._100;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * If $n$ is even, then the summation can only contain 0 or 2 1's.
 * The number of sums with 0 1's is $f(n/2)$.
 * The number of sums with 2 1's is $f(n/2 - 2)$.
 * If $n$ is odd, then the summation can only contain a single 1.
 * Thus $f$ is the recurrence relation:
 * \begin{align*}
 *     f(2n) &= f(n) + f(n - 1),\\
 *     f(2n + 1) &= f(n),\\
 *     f(1) &= 1.
 * \end{align*}
 * Compute $f(10^{25})$ directly with memoization.
 */
public class Problem169 {
    private static final Map<BigInteger, Long> MAP = new HashMap<>();

    public static void main(String[] args) {
        MAP.put(BigInteger.ONE, 1L);
        System.out.println(g(BigInteger.TEN.pow(25).add(BigInteger.ONE)));
    }

    private static long g(BigInteger x) {
        if (MAP.containsKey(x)) {
            return MAP.get(x);
        }

        BigInteger y = x.divide(BigInteger.TWO);
        long ans;
        if (x.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            ans = g(y);
        } else {
            ans = g(y) + g(y.add(BigInteger.ONE));
        }
        MAP.put(x, ans);
        return ans;
    }
}