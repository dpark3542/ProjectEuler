package solutions._100;

import java.util.List;

import static utils.NumberTheory.toBase;

/**
 * Pascal's triangle mod p is well known to be a fractal similar to Sierpinski's triangle due to Lucas's theorem.
 */
public class Problem148 {
    private static final int n = 1000000000, p = 7;

    public static void main(String[] args) {
        List<Integer> a = toBase(n, p);
        long[] pow = new long[a.size()];
        pow[0] = 1;
        for (int i = 1; i < a.size(); i++) {
            pow[i] = pow[i - 1] * (p + 1) * p / 2;
        }

        long ans = 0, prod = 1;
        for (int i = a.size() - 1; i >= 0; i--) {
            prod *= a.get(i) + 1;
            ans += a.get(i) * pow[i] * prod / 2;
        }
        System.out.println(ans);
    }
}
