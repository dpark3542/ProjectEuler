package solutions._100;

import java.util.ArrayList;
import java.util.List;

import static utils.NumberTheory.isPrime;

/**
 * Equation factors to $(x - n)(y - n) = n^2$.
 * Each factor of $n^2$ corresponds to two solutions except for $(2n, 2n)$.
 * The number of total factors for any $m=p_1^{e_1}\cdots p_k^{e_k}$ is well known to be $\prod_{i=1}^k (e_i+1)$.
 */
public class Problem108 {
    private static final long MIN = 1000;
    private static long ANS;
    private static List<Integer> PRIMES;

    public static void main(String[] args) {
        ANS = 1;
        PRIMES = new ArrayList<>();
        for (int i = 2; Math.pow(3, PRIMES.size()) <= 2 * MIN - 1; i++) {
            if (isPrime(i)) {
                ANS *= i;
                PRIMES.add(i);
            }
        }

        long ap = 4;
        for (int i = 2; ap < ANS; i++, ap *= 2) {
            dfs(List.of(i), ap, 2 * i + 1);
        }

        System.out.println(ANS);
    }

    private static void dfs(List<Integer> a, long ap, int ep) {
        if (ep > 2 * MIN - 1) {
            ANS = Math.min(ANS, ap);
        } else {
            long nap = ap * PRIMES.get(a.size());
            for (int i = 1; i <= a.get(a.size() - 1) && nap < ANS; i++, nap *= PRIMES.get(a.size())) {
                List<Integer> b = new ArrayList<>(a);
                b.add(i);
                int nep = ep * (2 * i + 1);

                dfs(b, nap, nep);

                if (nep >= MIN) {
                    break;
                }
            }
        }
    }
}
