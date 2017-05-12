package solutions;

import java.math.BigInteger;

/**
 * Created by dpark on 5/11/2017.
 */
public class Problem026 {
    public static void main(String[] args) {
        int ans = 2, max = 1;
        for (int d = 2; d < 1000; d++) {
            if (d % 2 == 0 || d % 5 == 0) {
                continue;
            }
            int n = 1;
            while (!BigInteger.TEN.modPow(BigInteger.valueOf(n), BigInteger.valueOf(d)).equals(BigInteger.ONE)) {
                n++;
            }
            if (n > max) {
                ans = d;
                max = n;
            }
        }
        System.out.println(ans);
    }
}
