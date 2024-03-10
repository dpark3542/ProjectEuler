package solutions._100;

import java.math.BigInteger;

import static java.lang.StrictMath.max;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TEN;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;

/**
 * Let the number be $10a+b$ where $0\leq b\leq 9$. Let $10^n\leq a\leq 10^{n+1}-1$.
 * Then $10a+b\mid b\cdot 10^{n+1}+a$. Let $k$ be the quotient.
 * Then $a=\dfrac{b(10^{n+1}-k)}{10k-1}$ must be an integer. Iterate over all $n,b,k$.
 */
public class Problem168 {
    private static final int n = 100, MOD = 100000;
    public static void main(String[] args) {
        BigInteger[] pow = new BigInteger[n];
        pow[0] = ONE;
        for (int i = 1; i < n; i++) {
            pow[i] = pow[i - 1].multiply(TEN);
        }

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int k = 1; k <= 9; k++) {
                BigInteger x = valueOf(10 * k - 1);
                BigInteger y = pow[i + 1].subtract(valueOf(k));
                int lo = ceilDiv(pow[i].multiply(x), y).intValue();
                int hi = pow[i + 1].subtract(ONE).multiply(x).divide(y).intValue();
                for (int b = max(lo, 1); b <= hi && b <= 9; b++) {
                    BigInteger t = y.multiply(valueOf(b));
                    if (t.mod(x).signum() == 0) {
                        ans += 10 * t.divide(x).mod(valueOf(MOD / 10)).intValue() + b;
                        ans %= MOD;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static BigInteger ceilDiv(BigInteger n, BigInteger d) {
        BigInteger[] qr = n.divideAndRemainder(d);
        if (qr[1].signum() == 0) {
            return qr[0];
        } else {
            return qr[0].add(ONE);
        }
    }
}
