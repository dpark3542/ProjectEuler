package solutions._000;

import java.util.ArrayList;
import java.util.List;

public class Problem060 {
    /*
     * Keep a list of pairs, triples, and quadruples of primes that can be concatenated in pairs to form a prime.
     * Iterate through the primes and continually update this list by testing each prime's compatibility with a double
     * to form a triple, with a triple to form a quadruple, and with a quadruple to form a quintuple.
     * For the quintuple with the current lowest sum, it is sufficient to check up to all primes less than sum to
     * confirm the quintuple has the lowest sum.
     */
    public static void main(String[] args) {
        List<Integer> pr = new ArrayList<>(), db = new ArrayList<>(), tr = new ArrayList<>(), qd = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int n = 2; n < min; n++) {
            if (!isPrime(n)) {
                continue;
            }
            boolean[] mkd = new boolean[pr.size() + 1];
            int a = pr.size(), b = db.size(), c = tr.size(), d = qd.size();
            pr.add(n);
            for (int i = 0; i < a; i++) {
                int p = pr.get(i);
                mkd[i] = isPrime(Long.parseLong(Integer.toString(n) + Integer.toString(p))) && isPrime(Long.parseLong(Integer.toString(p) + Integer.toString(n)));
                if (mkd[i]) {
                    db.add(i);
                    db.add(a);
                }
            }
            for (int i = 0; i < b / 2; i++) {
                int p = db.get(2 * i), q = db.get(2 * i + 1);
                if (mkd[p] && mkd[q]) {
                    tr.add(p);
                    tr.add(q);
                    tr.add(a);
                }
            }
            for (int i = 0; i < c / 3; i++) {
                int p = tr.get(3 * i), q = tr.get(3 * i + 1), r = tr.get(3 * i + 2);
                if (mkd[p] && mkd[q] && mkd[r]) {
                    qd.add(p);
                    qd.add(q);
                    qd.add(r);
                    qd.add(a);
                }
            }
            for (int i = 0; i < d / 4; i++) {
                int p = qd.get(4 * i), q = qd.get(4 * i + 1), r = qd.get(4 * i + 2), s = qd.get(4 * i + 3);
                if (mkd[p] && mkd[q] && mkd[r] && mkd[s]) {
                    min = Math.min(min, pr.get(p) + pr.get(q) + pr.get(r) + pr.get(s) + n);
                }
            }
        }
        System.out.println(min);
    }

    private static boolean isPrime(long x) {
        for (long i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
