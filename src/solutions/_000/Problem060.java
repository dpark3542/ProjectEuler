package solutions._000;

import java.util.ArrayList;
import java.util.List;

import static utils.NumberTheory.isPrime;

/*
 * Call two primes p, q compatible if the concatenations pq and qp are prime.
 * Iterating through the primes, we can construct a graph with primes as the vertices and edges between compatible primes.
 * A set of five pairwise compatible primes is a 5-clique in the graph.
 * Two approaches based on how cliques are searched for: offline and online
 *
 * Offline:
 * Generate graph up to some limit and find all 5-cliques.
 * If sum cannot be guaranteed as minimum, generate a larger graph.
 * Note: the clique problem is NP-Complete but 5 is a small constant. Other ad-hoc methods for finding cliques can also be used.
 * For example, use depth first search with backtracking can be used to find all cycles of length 5. Prune cycles that are not cliques.
 *
 * Online:
 * Keep running list of all 2-cliques, 3-cliques, and 4-cliques.
 * For each prime, iterate through all cliques and check if a larger clique can be formed by adding the new prime.
 * Stop when the minimum sum of all found 5-cliques is less than the largest prime checked.
 *
 * Online approach was implemented.
 *
 */
public class Problem060 {
    public static void main(String[] args) {
        // pr is list of primes
        // db is list of contiguous pairs of indices of compatible primes
        // tr is list of contiguous triples of indices of compatible primes
        // qd is list of contiguous quadruples of indices of compatible primes
        List<Integer> pr = new ArrayList<>(), db = new ArrayList<>(), tr = new ArrayList<>(), qd = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int n = 2; n <= min; n++) {
            if (!isPrime(n)) {
                continue;
            }
            boolean[] mkd = new boolean[pr.size() + 1];
            int a = pr.size(), b = db.size(), c = tr.size(), d = qd.size();
            pr.add(n);
            // create doubles
            for (int i = 0; i < a; i++) {
                int p = pr.get(i);
                mkd[i] = isPrime(concat(p, n)) && isPrime(concat(n, p));
                if (mkd[i]) {
                    db.add(i);
                    db.add(a);
                }
            }
            // create triples
            for (int i = 0; i < b / 2; i++) {
                int p = db.get(2 * i), q = db.get(2 * i + 1);
                if (mkd[p] && mkd[q]) {
                    tr.add(p);
                    tr.add(q);
                    tr.add(a);
                }
            }
            // create quadruples
            for (int i = 0; i < c / 3; i++) {
                int p = tr.get(3 * i), q = tr.get(3 * i + 1), r = tr.get(3 * i + 2);
                if (mkd[p] && mkd[q] && mkd[r]) {
                    qd.add(p);
                    qd.add(q);
                    qd.add(r);
                    qd.add(a);
                }
            }
            // create quintuples
            for (int i = 0; i < d / 4; i++) {
                int p = qd.get(4 * i), q = qd.get(4 * i + 1), r = qd.get(4 * i + 2), s = qd.get(4 * i + 3);
                if (mkd[p] && mkd[q] && mkd[r] && mkd[s]) {
                    min = Math.min(min, pr.get(p) + pr.get(q) + pr.get(r) + pr.get(s) + n);
                }
            }
        }
        System.out.println(min);
    }

    private static long concat(long a, long b) {
        int e = (int) Math.log10(b) + 1;
        return a * (long) Math.pow(10, e) + b;
    }
}
