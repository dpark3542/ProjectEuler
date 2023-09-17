package solutions._100;

import java.math.BigInteger;

/*
 * a_0a_1...a_(n-1) = a_0 10^(n-1) + ... + a_(n-1) 10^0
 * f(a_i 10^(n-i-1) + b) = (n-i-1) * a_i 10^(n-i-2) + f(b) + ...
 */
public class Problem156 {
    private static BigInteger[] ten;

    private static BigInteger f(int n, int d, int m, BigInteger l, BigInteger r, int i) {
        BigInteger ans = BigInteger.ZERO;
        if (i == n - 1) {
            for (int j = 0; j < d; j++) {
                BigInteger x = BigInteger.valueOf(j);
                if (l.add(x.multiply(BigInteger.valueOf(m))).equals(r.add(x))) {
                    ans = ans.add(r.add(x));
                }
            }
            for (int j = d; j <= 9; j++) {
                BigInteger x = BigInteger.valueOf(j);
                if (l.add(x.multiply(BigInteger.valueOf(m))).add(BigInteger.ONE).equals(r.add(x))) {
                    ans = ans.add(r.add(x));
                }
            }
        }
        else {
            BigInteger t = BigInteger.valueOf(n - i - 1), mm = BigInteger.valueOf(m), dd = BigInteger.valueOf(d);
            if (l.add(ten[n - i - 2].multiply(t).add(ten[n - i].subtract(BigInteger.ONE).multiply(mm))).compareTo(r) < 0) {
                return BigInteger.ZERO;
            }
            if (r.add(ten[n - i]).subtract(BigInteger.ONE).compareTo(l) < 0) {
                return BigInteger.ZERO;
            }
            // a_i < d
            for (int j = 0; j < d; j++) {
                BigInteger x = BigInteger.valueOf(j);
                ans = ans.add(f(n, d, m, l.add(x.multiply(t).multiply(ten[n - i - 2])).add(mm.multiply(x).multiply(ten[n - i - 1])), r.add(x.multiply(ten[n - i - 1])), i + 1));
            }
            // a_i = d
            ans = ans.add(f(n, d, m + 1, l.add(dd.multiply(t).multiply(ten[n - i - 2])).add(mm.multiply(dd).multiply(ten[n - i - 1])).add(BigInteger.ONE), r.add(dd.multiply(ten[n - i - 1])), i + 1));
            // a_i > d
            for (int j = d + 1; j <= 9; j++) {
                BigInteger x = BigInteger.valueOf(j);
                ans = ans.add(f(n, d, m, l.add(x.multiply(t).multiply(ten[n - i - 2])).add(mm.multiply(x).multiply(ten[n - i - 1])).add(ten[n - i -1]), r.add(x.multiply(ten[n - i - 1])), i + 1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 19;
        ten = new BigInteger[n + 1];
        ten[0] = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            ten[i] = ten[i - 1].multiply(BigInteger.TEN);
        }
        BigInteger ans = BigInteger.ZERO;
        for (int d = 1; d <= 9; d++) {
            ans = ans.add(f(n, d, 0, BigInteger.ZERO, BigInteger.ZERO, 0));
        }
        System.out.println(ans);
    }
}
