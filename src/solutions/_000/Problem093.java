package solutions._000;

import utils.structs.BigFraction;

import java.util.List;
import java.util.function.BiFunction;

import static utils.Miscellaneous.generateNextPermutation;

public class Problem093 {
    private static final List<BiFunction<BigFraction, BigFraction, BigFraction>> OPERATORS = List.of(
            BigFraction::add,
            BigFraction::subtract,
            BigFraction::multiply,
            BigFraction::divide
    );
    private static final List<QuinFunction> TREES = List.of(
            (a, b, c, d, o, p, q) -> q.apply(p.apply(o.apply(a, b), c), d),
            (a, b, c, d, o, p, q) -> q.apply(p.apply(a, o.apply(b, c)), d),
            (a, b, c, d, o, p, q) -> q.apply(o.apply(a, b), p.apply(c, d)),
            (a, b, c, d, o, p, q) -> q.apply(a, p.apply(o.apply(b, c), d)),
            (a, b, c, d, o, p, q) -> q.apply(a, p.apply(b, o.apply(c, d)))
    );
    private static final int N_MAX = 7680; // C_3 * 4! * 4^3 where C_n is the nth Catalan number

    private interface QuinFunction {
        BigFraction apply(BigFraction a, BigFraction b, BigFraction c, BigFraction d,
                          BiFunction<BigFraction, BigFraction, BigFraction> o,
                          BiFunction<BigFraction, BigFraction, BigFraction> p,
                          BiFunction<BigFraction, BigFraction, BigFraction> q);
    }

    public static void main(String[] args) {
        int mn = 0, ma = 0, mb = 1, mc = 2, md = 3;
        for (int a = 0; a < 10; a++) {
            for (int b = a + 1; b < 10; b++) {
                for (int c = b + 1; c < 10; c++) {
                    for (int d = c + 1; d < 10; d++) {
                        int n = f(a, b, c, d);
                        if (n > mn) {
                            ma = a;
                            mb = b;
                            mc = c;
                            md = d;
                            mn = n;
                        }
                    }
                }
            }
        }
        System.out.printf("%d%d%d%d\n", ma, mb, mc, md);
    }

    private static int f(int a, int b, int c, int d) {
        boolean[] mkd = new boolean[N_MAX + 1];
        for (BiFunction<BigFraction, BigFraction, BigFraction> o : OPERATORS) {
            for (BiFunction<BigFraction, BigFraction, BigFraction> p : OPERATORS) {
                for (BiFunction<BigFraction, BigFraction, BigFraction> q : OPERATORS) {
                    for (QuinFunction t : TREES) {
                        int[] l = {a, b, c, d};
                        while (true) {
                            try {
                                int x = t.apply(new BigFraction(l[0]),
                                                new BigFraction(l[1]),
                                                new BigFraction(l[2]),
                                                new BigFraction(l[3]),
                                                o, p, q).intValue();
                                if (0 <= x && x <= N_MAX) {
                                    mkd[x] = true;
                                }
                            } catch (ArithmeticException ignored) {

                            }

                            if (!generateNextPermutation(l)) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        int ans = 1;
        while (mkd[ans]) {
            ans++;
        }
        return ans - 1;
    }
}
