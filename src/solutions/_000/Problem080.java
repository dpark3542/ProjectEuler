package solutions._000;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * There are many methods from the field of numerical analysis.
 * Use the bisection method on x^2 - a over the interval [0, 10].
 */
public class Problem080 {
    public static void main(String[] args) {
        MathContext mc = new MathContext(102);
        int tot = 0;
        for (int i = 1; i <= 100; i++) {
            int sq = (int) Math.sqrt(i);
            if (sq * sq != i) {
                BigDecimal lo = BigDecimal.ZERO, hi = BigDecimal.TEN;
                while (!lo.round(mc).equals(hi.round(mc))) {
                    BigDecimal mid = lo.add(hi).divide(BigDecimal.valueOf(2));
                    if (mid.pow(2).subtract(BigDecimal.valueOf(i)).signum() == -1) {
                        lo = mid;
                    } else {
                        hi = mid;
                    }
                }
                char[] c = lo.toString().toCharArray();
                tot += sq;
                for (int j = 0; j < 99; j++) {
                    tot += c[j + 2] - '0';
                }
            }
        }
        System.out.println(tot);
    }
}
