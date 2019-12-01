package solutions._100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static utils.Utils.gcd;

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
        List<Set<Fraction>> a = new ArrayList<>();

        // initialize a
        a.add(new HashSet<>());
        Set<Fraction> s = new HashSet<>();
        s.add(new Fraction(1, 1));
        a.add(s);

        for (int i = 2; i <= n; i++) {
            Set<Fraction> t = new HashSet<>();
            for (int j = 1; j <= i / 2; j++) {
                for (Fraction f : a.get(j)) {
                    for (Fraction g : a.get(i - j)) {
                        // parallel
                        t.add(f.add(g));
                        // series
                        t.add(f.inverse().add(g.inverse()).inverse());
                    }
                }
            }
            a.add(t);
        }

        Set<Fraction> union = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            union.addAll(a.get(i));
        }

        System.out.println(union.size());
    }

    /**
     * Class for positive rationals.
     */
    private static class Fraction {
        public int n, d;

        public Fraction(int a, int b) {
            int g = (int) gcd(a, b);
            n = a / g;
            d = b / g;
        }

        public Fraction inverse() {
            return new Fraction(d, n);
        }

        public Fraction add(Fraction f) {
            return new Fraction(n * f.d + d * f.n, d * f.d);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            else if (!(obj instanceof Fraction)) {
                return false;
            }
            Fraction f = (Fraction) obj;
            return n == f.n && d == f.d;
        }

        @Override
        public int hashCode() {
            return n * 31 + d;
        }
    }
}
