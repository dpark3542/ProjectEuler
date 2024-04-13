package solutions._100;

import utils.structs.BigFraction;

import java.util.HashSet;
import java.util.Set;

import static java.lang.StrictMath.sqrt;
import static utils.structs.BigFraction.ONE;
import static utils.structs.BigFraction.ZERO;

/**
 * $f_n(x,y,z) = (x + y + z)(x^n + y^n - z^n)$.
 * By Fermat's Last Theorem, $n$ is either -2, -1, 1, or 2.
 */
public class Problem180 {
    private static final int n = 35;
    private static final BigFraction TWO = new BigFraction(2);

    public static void main(String[] args) {
        Set<BigFraction> s = new HashSet<>();
        for (int a = 1; a < n; a++) {
            for (int b = a + 1; b <= n; b++) {
                BigFraction f = new BigFraction(a, b);
                if (f.getNumerator().intValue() != a) {
                    continue;
                }
                for (int c = 1; c < n; c++) {
                    for (int d = c + 1; d <= n && a * d <= b * c; d++) {
                        BigFraction g = new BigFraction(c, d);
                        if (g.getNumerator().intValue() != c) {
                            continue;
                        }

                        // n = 1
                        BigFraction sum = f.add(g);
                        if (sum.compareTo(ONE) < 0 && sum.getDenominator().intValue() <= n) {
                            s.add(sum.multiply(TWO));
                        }

                        // n = -1
                        BigFraction h = f.inverse().add(g.inverse()).inverse();
                        if (h.getDenominator().intValue() <= n) {
                            s.add(sum.add(h));
                        }

                        int x = a * a * d * d + b * b * c * c, sq = (int) sqrt(x);
                        if (sq * sq == x) {
                            // n = 2
                            h = new BigFraction(sq, b * d);
                            if (h.compareTo(ONE) < 0 && h.getDenominator().intValue() <= n) {
                                s.add(sum.add(h));
                            }

                            // n = -2
                            h = new BigFraction(a * c, sq);
                            if (h.compareTo(ONE) < 0 && h.getDenominator().intValue() <= n) {
                                s.add(sum.add(h));
                            }
                        }
                    }
                }
            }
        }

        BigFraction t = ZERO;
        for (BigFraction f : s) {
            t = t.add(f);
        }
        System.out.println(t.getNumerator().add(t.getDenominator()));
    }
}
