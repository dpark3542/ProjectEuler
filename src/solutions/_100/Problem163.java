package solutions._100;

import utils.structs.Triple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Can get O(1) formula using casework.
 * Alternatively, build graph and count triangles in O(n^4). Barycentric coordinates simplifies implementation.
 */
public class Problem163 {
    private static final int n = 36;
    private static final Map<Triple<Integer, Integer, Integer>, Set<Triple<Integer, Integer, Integer>>> g = new HashMap<>();

    public static void main(String[] args) {
        int ans = 0;

        for (int i = 0; i < n; i++) {
            List<Triple<Integer, Integer, Integer>> a = new ArrayList<>(), b = new ArrayList<>(), c = new ArrayList<>();

            for (int j = 0; j < 2 * (n - i) + 1; j++) {
                a.add(new Triple<>(6 * (n - i) - 3 * j, 3 * j, 6 * i));
                b.add(new Triple<>(6 * i, 6 * (n - i) - 3 * j, 3 * j));
                c.add(new Triple<>(3 * j, 6 * i, 6 * (n - i) - 3 * j));
            }

            addEdges(a);
            addEdges(b);
            addEdges(c);

            ans -= nP3(a.size()) + nP3(b.size()) + nP3(c.size());
        }

        for (int i = 0; i < 2 * n; i++) {
            Triple<Integer, Integer, Integer> p = new Triple<>(6 * n - 3 * i, 3 * i, 0);
            Triple<Integer, Integer, Integer> q = new Triple<>(0, 6 * n - 3 * i, 3 * i);
            Triple<Integer, Integer, Integer> r = new Triple<>(3 * i, 0 , 6 * n - 3 * i);

            List<Triple<Integer, Integer, Integer>> pl = new ArrayList<>(), ql = new ArrayList<>(), rl = new ArrayList<>();
            pl.add(p);
            ql.add(q);
            rl.add(r);

            for (int j = 0; p.second() > 0; j++) {
                int m = (i + j) % 2 == 0 ? 2 : 1;
                pl.add(addVector(p, new Triple<>(-m, -m, 2 * m)));
                ql.add(addVector(q, new Triple<>(2 * m, -m, -m)));
                rl.add(addVector(r, new Triple<>(-m, 2 * m, -m)));

                p = addVector(p, new Triple<>(-3, -3, 6));
                q = addVector(q, new Triple<>(6, -3, -3));
                r = addVector(r, new Triple<>(-3, 6, -3));
                pl.add(p);
                ql.add(q);
                rl.add(r);
            }

            addEdges(pl);
            addEdges(ql);
            addEdges(rl);

            ans -= nP3(pl.size()) + nP3(ql.size()) + nP3(rl.size());
        }

        for (Set<Triple<Integer, Integer, Integer>> s : g.values()) {
            for (Triple<Integer, Integer, Integer> p : s) {
                for (Triple<Integer, Integer, Integer> q : s) {
                    if (g.get(p).contains(q)) {
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans / 6);
    }

    private static int nP3(int n) {
        return n * (n - 1) * (n - 2);
    }

    private static Triple<Integer, Integer, Integer> addVector(Triple<Integer, Integer, Integer> p, Triple<Integer, Integer, Integer> q) {
        return new Triple<>(p.first() + q.first(), p.second() + q.second(), p.third() + q.third());
    }

    private static void addEdges(List<Triple<Integer, Integer, Integer>> a) {
        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 1; j < a.size(); j++) {
                if (!g.containsKey(a.get(i))) {
                    g.put(a.get(i), new HashSet<>());
                }
                g.get(a.get(i)).add(a.get(j));

                if (!g.containsKey(a.get(j))) {
                    g.put(a.get(j), new HashSet<>());
                }
                g.get(a.get(j)).add(a.get(i));
            }
        }
    }
}
