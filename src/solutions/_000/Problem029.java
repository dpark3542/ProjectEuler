package solutions._000;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem029 {
    /*
     * Represent all numbers by their prime factorization and remove repeats.
     *
     * Alternatively, use Bignums to calculate and count all numbers.
     */
    public static void main(String[] args) {
        List<Integer> pr = new ArrayList<>();
        out:
        for (int p = 2; p <= 100; p++) {
            for (int q : pr) {
                if (p % q == 0) {
                    continue out;
                }
            }
            pr.add(p);
        }
        Set<List<Integer>> s = new HashSet<>();
        for (int a = 2; a <= 100; a++) {
            List<Integer> l = new ArrayList<>();
            for (int p : pr) {
                int e = 0;
                for (int c = a; c % p == 0; c /= p) {
                    e++;
                }
                l.add(e);
            }
            for (int b = 2; b <= 100; b++) {
                List<Integer> m = new ArrayList<>();
                for (int e : l) {
                    m.add(b * e);
                }
                s.add(m);
            }
        }
        System.out.println(s.size());
    }
}
