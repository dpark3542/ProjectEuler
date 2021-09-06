package solutions._000;

import java.util.*;

import static utils.Miscellaneous.generateNextPermutation;

/*
 * Formula for nth s-gonal number can be derived as (n^2(s-2) - n(s-4))/2.
 * For each s, generate all 4-digit s-gonal numbers.
 * Treat each s-gonal number as a vertex in a graph and create directed edges between different s-gonal numbers if they satisfy the first condition.
 * Go through each permutation of the range of values of s, {3, 4, 5, 6, 7, 8}.
 * For each permutation {s_1, s_2, ...}, search for a cycle that passes through an s_1-gonal number, then an s_2-gonal number, etc.
 * Stop when the unique cycle is found. Sum the vertices in the cycle.
 *
 */
public class Problem061 {
    public static void main(String[] args) {
        // a.get(s).get(x) returns a list of 4-digit s-gonal numbers that begin with x.
        // b.get(s).get(x) returns a list of 4-digit s-gonal numbers that end with x.
        // this ad-hoc data structure provides the functionality needed for our graph
        // initialize a and b
        List<Map<Integer, List<Integer>>> a = new ArrayList<>(), b = new ArrayList<>();
        for (int s = 0; s <= 8; s++) {
            a.add(new HashMap<>());
            b.add(new HashMap<>());
        }
        // fill a and b
        for (int s = 3; s <= 8; s++) {
            for (int n = 1, p = 1; p <= 9999; n++, p = polygonal(s, n)) {
                if (1000 <= p) {
                    int x = p / 100, y = p % 100;
                    // fill a
                    if (a.get(s).containsKey(x)) {
                        a.get(s).get(x).add(p);
                    }
                    else {
                        List<Integer> l = new ArrayList<>();
                        l.add(p);
                        a.get(s).put(x, l);
                    }
                    // fill b
                    if (b.get(s).containsKey(y)) {
                        b.get(s).get(y).add(p);
                    }
                    else {
                        List<Integer> l = new ArrayList<>();
                        l.add(p);
                        b.get(s).put(y, l);
                    }
                }
            }
        }
        // search for cycle
        // start cycle search (without loss of generality) with a 3-gonal number
        // c is the permutation of s values
        // initialize c to first lexicographic permutation
        int[] c = {4, 5, 6, 7, 8};
        while (true) {
            // start bfs
            // each level corresponds to an s value in the permutation c
            // initialize queue
            Deque<List<Integer>> q = new ArrayDeque<>();
            for (List<Integer> l : b.get(3).values()) {
                for (int p : l) {
                    List<Integer> m = new ArrayList<>();
                    m.add(p);
                    q.addFirst(m);
                }
            }
            // traverse by level/s value
            for (int s : c) {
                int len = q.size();
                for (int i = 0; i < len; i++) {
                    List<Integer> m = q.pollLast();
                    int x = m.get(m.size() - 1) % 100;
                    if (!a.get(s).containsKey(x)) {
                        continue;
                    }
                    for (int p : a.get(s).get(x)) {
                        List<Integer> k = new ArrayList<>(m);
                        k.add(p);
                        q.addFirst(k);
                    }
                }
            }
            // check if path is a cycle
            for (List<Integer> l : q) {
                if (l.get(l.size() - 1) % 100 == l.get(0) / 100) {
                    int sum = 0;
                    for (int e : l) {
                        sum += e;
                    }
                    System.out.println(sum);
                    return;
                }
            }
            generateNextPermutation(c);
        }
    }

    /**
     * Returns nth s-gonal number.
     *
     * @param s s
     * @param n n
     * @return nth s-gonal number
     */
    private static int polygonal(int s, int n) {
        return (n * n * (s - 2) - n * (s - 4)) / 2;
    }
}
