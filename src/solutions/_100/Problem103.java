package solutions._100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Lots of ugly inequality manipulation will not be shown, but the following can be proven by hand.
 * Let $A=\{a_1 < \cdots < a_7}$.
 * - The sum is at least 180.
 * - Lower bounds on $a_{i+j} - a_i$ for each $j$ are in the offset variable below.
 * - $a_1 \geq 16$.
 * A depth first search with these constraints is fast enough.
 */
public class Problem103 {
    private static final int n = 7;
    private static final int[] OFFSET = {0, 1, 2, 4, 7, 8, 9};
    private static final int[] ACCUMULATE = {0, 0, 1, 3, 7, 14, 22, 31};
    public static void main(String[] args) {
        for (int sum = 180; ; sum++) {
            for (int i = 16; n * i + ACCUMULATE[n] <= sum; i++) {
                if (dfs(List.of(i), sum)) {
                    return;
                }
            }
        }
    }

    private static boolean dfs(List<Integer> a, int sum) {
        if (a.size() == n - 1) {
            List<Integer> b = new ArrayList<>(a);
            b.add(sum);
            if (isSpecial(b)) {
                for (int i = 0; i < n; i++) {
                    System.out.print(b.get(i));
                }
                System.out.println();
                return true;
            } else {
                return false;
            }
        }

        int lo = 0;
        for (int i = 0; i < a.size(); i++) {
            lo = Math.max(lo, a.get(i) + OFFSET[a.size() - i]);
        }
        for (int i = lo; (n - a.size()) * i + ACCUMULATE[n - a.size()] <= sum; i++) {
            List<Integer> b = new ArrayList<>(a);
            b.add(i);
            if (dfs(b, sum - i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSpecial(List<Integer> a) {
        for (int i = 1; 2 * i + 1 <= a.size(); i++) {
            int x = 0;
            for (int j = 0; j < i + 1; j++) {
                x += a.get(j);
            }

            int y = 0;
            for (int j = 0; j < i; j++) {
                y += a.get(a.size() - j - 1);
            }

            if (x < y) {
                return false;
            }
        }

        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < Math.pow(2, a.size()); i++) {
            int tot = 0;
            for (int j = 0, k = i; k > 0; k >>= 1, j++) {
                if ((k & 1) == 1) {
                    tot += a.get(j);
                }
            }
            if (s.contains(tot)) {
                return false;
            }
            s.add(tot);
        }

        return true;
    }
}
