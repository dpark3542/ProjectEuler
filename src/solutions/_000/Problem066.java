package solutions._000;

import java.math.BigInteger;

import static utils.NumberTheory.pellSolve;

public class Problem066 {
    public static void main(String[] args) {
        int ans = 0;
        BigInteger max = BigInteger.ZERO;
        for (int d = 2; d <= 1000; d++) {
            int sq = (int) Math.sqrt(d);
            if (sq * sq == d) {
                continue;
            }

            BigInteger cur = pellSolve(d, 1).next().first();
            if (cur.compareTo(max) > 0) {
                ans = d;
                max = cur;
            }
        }
        System.out.println(ans);
    }
}
