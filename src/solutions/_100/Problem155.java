package solutions._100;

import utils.structs.BigFraction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * First generate a(i), the set of distinct capacitance values using exactly n capacitors.
 * a(i) can be generated using recursion.
 * Go through each j + k = i and loop through each value in a(j) and a(k), treating each capacitance value as a single capacitor.
 * Add the result of putting the two capacitors in parallel and series to a(i).
 * Print the size of the union of all a(i).
 *
 */
public class Problem155 {
    public static void main(String[] args) {
        int n = 18;
        List<Set<BigFraction>> a = new ArrayList<>();

        // initialize a
        a.add(new HashSet<>());
        Set<BigFraction> s = new HashSet<>();
        s.add(BigFraction.ONE);
        a.add(s);

        for (int i = 2; i <= n; i++) {
            Set<BigFraction> t = new HashSet<>();
            for (int j = 1; j <= i / 2; j++) {
                for (BigFraction f : a.get(j)) {
                    for (BigFraction g : a.get(i - j)) {
                        // parallel
                        t.add(f.add(g));
                        // series
                        t.add(f.inverse().add(g.inverse()).inverse());
                    }
                }
            }
            a.add(t);
        }

        Set<BigFraction> union = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            union.addAll(a.get(i));
        }

        System.out.println(union.size());
    }
}
