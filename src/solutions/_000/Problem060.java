package solutions._000;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.parseLong;
import static java.lang.StrictMath.min;
import static utils.NumberTheory.isPrime;

/*
 * Consider a graph on the primes with two vertices p, q adjacent if their concatenations pq and qp are prime.
 * Compute list of all k-cliques with k < 5.
 * Iterate on primes. For each new prime p, update list of k-cliques.
 * Stop when the smallest sum of all found 5-cliques is less than p.
 */
public class Problem060 {
    public static void main(String[] args) {
        // pr is list of vertices
        // db is list of edges
        // tr is list of triangles
        // qd is list of 4-cliques
        List<Integer> pr = new ArrayList<>(), db = new ArrayList<>(), tr = new ArrayList<>(), qd = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int n = 2; n <= min; n++) {
            if (!isPrime(n)) {
                continue;
            }
            boolean[] mkd = new boolean[pr.size() + 1];
            int a = pr.size(), b = db.size(), c = tr.size(), d = qd.size();
            pr.add(n);
            // update edges
            for (int i = 0; i < a; i++) {
                int p = pr.get(i);
                mkd[i] = isDirectedEdge(p, n) && isDirectedEdge(n, p);
                if (mkd[i]) {
                    db.add(i);
                    db.add(a);
                }
            }
            // update triangles
            for (int i = 0; i < b / 2; i++) {
                int p = db.get(2 * i), q = db.get(2 * i + 1);
                if (mkd[p] && mkd[q]) {
                    tr.add(p);
                    tr.add(q);
                    tr.add(a);
                }
            }
            // update 4-cliques
            for (int i = 0; i < c / 3; i++) {
                int p = tr.get(3 * i), q = tr.get(3 * i + 1), r = tr.get(3 * i + 2);
                if (mkd[p] && mkd[q] && mkd[r]) {
                    qd.add(p);
                    qd.add(q);
                    qd.add(r);
                    qd.add(a);
                }
            }
            // check 5-cliques
            for (int i = 0; i < d / 4; i++) {
                int p = qd.get(4 * i), q = qd.get(4 * i + 1), r = qd.get(4 * i + 2), s = qd.get(4 * i + 3);
                if (mkd[p] && mkd[q] && mkd[r] && mkd[s]) {
                    min = min(min, pr.get(p) + pr.get(q) + pr.get(r) + pr.get(s) + n);
                }
            }
        }
        System.out.println(min);
    }

    private static boolean isDirectedEdge(long a, long b) {
        return isPrime(parseLong(String.format("%d%d", a, b)));
    }
}
