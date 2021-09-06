package solutions._000;

import java.util.ArrayList;
import java.util.List;

/*
 * Let sqrt(N) = a_0 + 1/(a_1 + 1/...) with each a_i a positive integer.
 * Let f_i = a_i + 1/(a_(i+1) + 1/...).
 * Note that f_i - a_i = 1/(a_(i+1) + 1/...) is strictly between 0 and 1, thus a_i = floor(f_i).
 * Then,
 *
 * f_i = a_i + 1/(a_(i+1) + 1/...) = a_i + 1/f_(i+1)
 * f_(i+1) = 1/(f_i - a_i)
 *
 * By induction, each f_i is in the field extension Q(sqrt(N)).
 * Then by creating a custom class for numbers in Q(sqrt(N)) with all necessary operations defined, one may use the recursive formulas,
 *
 * f_(i+1) = 1/(f_i - a_i)
 * a_(i+1) = floor(f_(i+1))
 *
 * to generate the continued fraction for sqrt(N).
 *
 * A simpler implementation exists.
 * Notice f_i is of the form (p_i + sqrt(N))/q_i where each p_i and q_i are integers.
 * (In fact, a well-known result by Euler and Lagrange states that all periodic continued fractions are irrational roots of an integer quadratic and vice versa.)
 * Proof by induction:
 * Base case is trivial. Suppose f_i = (p_i + sqrt(N))/q_i for some integers p_i, q_i.
 *
 * f_i = a_i + 1/f_(i+1)
 * (p_i + sqrt(N))/q_i - a_i = 1/f_(i+1)
 *
 * Let f_(i+1) = (p_(i+1) + sqrt(N)) / q_(i+1). It is sufficient to prove p_(i+1), q_(i+1) are integer.
 *
 * (p_i + sqrt(N))/q_i - a_i = q_(i+1) / (p_(i+1) + sqrt(N))
 * (p_i + sqrt(N))/q_i - a_i = q_(i+1)(p_(i+1) - sqrt(N)) / (p_(i+1)^2 - N)
 *
 * Since {1, sqrt(N)} is a basis for the field Q(sqrt(N)), match coefficients,
 *
 * p_i/q_i - a_i = p_(i+1)q_(i+1) / (p_(i+1)^2 - N)
 * 1/q_i = -q_(i+1) / (p_(i+1)^2 - N)
 *
 * The second equation gives the recursive formula q_(i+1) = (N - p_(i+1)^2) / q_i.
 * Substituting the second equation into the first gives the necessary recursive formula for p_(i+1),
 *
 * p_i/q_i - a_i = -p_(i+1)/q_i
 * p_(i+1) = a_i * q_i - p_i
 *
 * Also, we have a_(i+1) = floor(f_(i+1)) = floor((p_(i+1) + sqrt(N)) / q_(i+1)).
 * To finish the induction, it is left to prove p_(i+1), q_(i+1) are integer.
 * Since each of a_i, p_i, q_i are integer, p_(i+1) is integer.
 * For q_(i+1),
 *
 * q_(i+1) = (N - p_(i+1)^2) / q_i = (N - (a_i * q_i - p_i)^2) / q_i
 *
 * Clearly q_(i+1) is integer if and only if (N - p_i^2) / q_i is integer.
 * Note (N - p_i^2) / q_i = q_(i-1) is integer by an equation above, finishing the induction.
 *
 */
public class Problem064 {
    public static void main(String[] args) {
        int cnt = 0;
        for (int n = 2; n <= 10000; n++) {
            // first remove perfect squares n
            int sq = (int) Math.sqrt(n);
            if (n == sq * sq) {
                continue;
            }
            // initialize sequences p, q, a
            List<Integer> pl = new ArrayList<>(), ql = new ArrayList<>(), al = new ArrayList<>();
            pl.add(0);
            ql.add(1);
            al.add(sq);
            out:
            while (true) {
                // load p_i, q_i, a_i
                int p = pl.get(pl.size() - 1), q = ql.get(ql.size() - 1), a = al.get(al.size() - 1);
                // calculate p_(i+1), q_(i+1), a_(i+1)
                // p_(i+1) = a_i * q_i - p_i
                p = a * q - p;
                // q_(i+1) = (N - p_(i+1)^2) / q_i
                q = (n - p * p) / q;
                // a_(i+1) = floor((p_(i+1) + sqrt(N)) / q_(i+1))
                a = (int) Math.floor((p + Math.sqrt(n)) / q);
                // check if f_i was repeated
                // quadratic algorithm is fast enough
                for (int i = 0; i < pl.size(); i++) {
                    if (p == pl.get(i) && q == ql.get(i)) {
                        // check if period odd
                        if ((al.size() - i) % 2 == 1) {
                            cnt++;
                        }
                        break out;
                    }
                }
                // store p_(i+1), q_(i+1), a_(i+1)
                pl.add(p);
                ql.add(q);
                al.add(a);
            }
        }
        System.out.println(cnt);
    }
}
