package solutions._100;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TEN;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;

/*
 * a_0a_1...a_(n-1) = a_0 10^(n-1) + ... + a_(n-1) 10^0
 * f(a_i 10^(n-i-1) + b) = (n-i-1) * a_i 10^(n-i-2) + f(b) + ...
 */
public class Problem156 {
    private static BigInteger[] POW;

    public static void main(String[] args) {
        int n = 19;
        POW = new BigInteger[n + 1];
        POW[0] = ONE;
        for (int i = 1; i <= n; i++) {
            POW[i] = POW[i - 1].multiply(TEN);
        }
        BigInteger ans = ZERO;
        for (int d = 1; d <= 9; d++) {
            ans = ans.add(f(n, d, 0, ZERO, ZERO, 0));
        }
        System.out.println(ans);
    }

    private static BigInteger f(int n, int d, int m, BigInteger l, BigInteger r, int i) {
        BigInteger ans = ZERO;
        if (i == n - 1) {
            for (int j = 0; j < d; j++) {
                BigInteger x = valueOf(j);
                if (l.add(x.multiply(valueOf(m))).equals(r.add(x))) {
                    ans = ans.add(r.add(x));
                }
            }
            for (int j = d; j <= 9; j++) {
                BigInteger x = valueOf(j);
                if (l.add(x.multiply(valueOf(m))).add(ONE).equals(r.add(x))) {
                    ans = ans.add(r.add(x));
                }
            }
        }
        else {
            BigInteger t = valueOf(n - i - 1), mm = valueOf(m), dd = valueOf(d);
            if (l.add(POW[n - i - 2].multiply(t).add(POW[n - i].subtract(ONE).multiply(mm))).compareTo(r) < 0) {
                return ZERO;
            }
            if (r.add(POW[n - i]).subtract(ONE).compareTo(l) < 0) {
                return ZERO;
            }
            // a_i < d
            for (int j = 0; j < d; j++) {
                BigInteger x = valueOf(j);
                ans = ans.add(f(n, d, m, l.add(x.multiply(t).multiply(POW[n - i - 2])).add(mm.multiply(x).multiply(POW[n - i - 1])), r.add(x.multiply(POW[n - i - 1])), i + 1));
            }
            // a_i = d
            ans = ans.add(f(n, d, m + 1, l.add(dd.multiply(t).multiply(POW[n - i - 2])).add(mm.multiply(dd).multiply(POW[n - i - 1])).add(ONE), r.add(dd.multiply(POW[n - i - 1])), i + 1));
            // a_i > d
            for (int j = d + 1; j <= 9; j++) {
                BigInteger x = valueOf(j);
                ans = ans.add(f(n, d, m, l.add(x.multiply(t).multiply(POW[n - i - 2])).add(mm.multiply(x).multiply(POW[n - i - 1])).add(POW[n - i -1]), r.add(x.multiply(POW[n - i - 1])), i + 1));
            }
        }
        return ans;
    }
}
