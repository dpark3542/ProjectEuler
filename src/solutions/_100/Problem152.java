package solutions._100;

import utils.structs.BigFraction;

import java.util.ArrayList;
import java.util.List;

import static java.math.BigInteger.valueOf;
import static utils.NumberTheory.isPrime;

public class Problem152 {
    private static final int n = 80;
    private static final BigFraction HALF = new BigFraction(1, 2);
    private static final List<Integer> PRIMES = new ArrayList<>();
    private static final List<List<Integer>> a = new ArrayList<>();


    public static void main(String[] args) {
        for (int i = n; i >= 2; i--) {
            if (isPrime(i)) {
                PRIMES.add(i);
            }
        }

        for (int ignored : PRIMES) {
            a.add(new ArrayList<>());
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < PRIMES.size(); j++) {
                if (i % PRIMES.get(j) == 0) {
                    a.get(j).add(i);
                    break;
                }
            }
        }

        System.out.println(dfs(BigFraction.ZERO, 0));
    }

    private static int dfs(BigFraction f, int i) {
        int ans = 0;
        for (int j = 0; j < 1 << a.get(i).size(); j++) {
            BigFraction g = f;
            for (int k = j, l = 0; k > 0; k >>= 1, l++) {
                if ((k & 1) == 1) {
                    g = g.add(new BigFraction(1, (long) a.get(i).get(l) * a.get(i).get(l)));
                }
            }
            if (i + 1 == a.size()) {
                if (g.equals(HALF)) {
                    return 1;
                }
            } else if (g.getDenominator().mod(valueOf(PRIMES.get(i))).signum() != 0) {
                ans += dfs(g, i + 1);
            }
        }
        return ans;
    }
}
