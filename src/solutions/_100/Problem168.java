package solutions._100;

import java.math.BigInteger;

/**
 * Let the number be $10a+b$ where $0\leq b\leq 9$. Let $10^n\leq a\leq 10^{n+1}-1$.
 * Then $10a+b\mid b\cdot 10^{n+1}+a$. Let $k$ be the quotient.
 * Then $a=\dfrac{b(10^{n+1}-k)}{10k-1}$ must be an integer. Iterate over all $n,b,k$.
 */
public class Problem168 {
    private static final int n = 100, MOD = 100000;
    public static void main(String[] args) {
        BigInteger[] pow = new BigInteger[n];
        pow[0] = BigInteger.ONE;
        for (int i = 1; i < n; i++) {
            pow[i] = pow[i - 1].multiply(BigInteger.TEN);
        }

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int k = 1; k <= 9; k++) {
                BigInteger x = BigInteger.valueOf(10 * k - 1);
                BigInteger y = pow[i + 1].subtract(BigInteger.valueOf(k));
                int lo = ceilDiv(pow[i].multiply(x), y).intValue();
                int hi = pow[i + 1].subtract(BigInteger.ONE).multiply(x).divide(y).intValue();
                for (int b = Math.max(lo, 1); b <= hi && b <= 9; b++) {
                    BigInteger t = y.multiply(BigInteger.valueOf(b));
                    if (t.mod(x).equals(BigInteger.ZERO)) {
                        ans += 10 * t.divide(x).mod(BigInteger.valueOf(MOD / 10)).intValue() + b;
                        ans %= MOD;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static BigInteger ceilDiv(BigInteger n, BigInteger d) {
        BigInteger[] qr = n.divideAndRemainder(d);
        if (qr[1].equals(BigInteger.ZERO)) {
            return qr[0];
        } else {
            return qr[0].add(BigInteger.ONE);
        }
    }
}
