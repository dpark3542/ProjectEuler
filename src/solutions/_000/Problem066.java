package solutions._000;

import java.math.BigInteger;

public class Problem066 {
    public static void main(String[] args) {
        int ans = 0;
        BigInteger max = BigInteger.ZERO;
        for (int d = 2; d <= 1000; d++) {
            int sq = (int) Math.sqrt(d);
            if (sq * sq == d) {
                continue;
            }

            BigInteger p_prev = BigInteger.ONE, p_cur = BigInteger.valueOf(sq), q_prev = BigInteger.ZERO, q_cur = BigInteger.ONE;
            int a = sq, P = 0, Q = 1;

            while (!p_cur.multiply(p_cur).subtract(BigInteger.valueOf(d).multiply(q_cur).multiply(q_cur)).equals(BigInteger.ONE)) {
                BigInteger p_tmp = p_prev;
                BigInteger q_tmp = q_prev;

                P = a * Q - P;
                Q = (d - P * P) / Q;
                a = (sq + P) / Q;
                p_prev = p_cur;
                p_cur = p_cur.multiply(BigInteger.valueOf(a)).add(p_tmp);
                q_prev = q_cur;
                q_cur = q_cur.multiply(BigInteger.valueOf(a)).add(q_tmp);
            }

            if (p_cur.compareTo(max) > 0) {
                max = p_cur;
                ans = d;
            }
        }
        System.out.println(ans);
    }
}
