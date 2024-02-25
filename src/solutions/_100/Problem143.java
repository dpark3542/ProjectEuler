package solutions._100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.StrictMath.sqrt;

/**
 * $\angle ATB = 180 - \angle AOB = 120$ since $AOBT$ is a cyclic quadrilateral.
 * By Law of Cosines, $c^2=p^2+pr+r^2$.
 * Define a graph $G$ on $[120000]^2$ with $p,r$ adjacent if $c$ is integer.
 * Then $ABC$ is a Torricelli triangle if and only if $p,q,r$ form a triangle in $G$.
 */
public class Problem143 {
    private static final int n = 120000;

    public static void main(String[] args) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i + 2 <= n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 1; i + 2 <= n; i++) {
            for (int j = i; i + j + 1 <= n; j++) {
                if (isAdjacent(i, j)) {
                    g.get(i).add(j);
                    g.get(j).add(i);
                }
            }
        }

        Set<Integer> s = new HashSet<>();
        for (int i = 1; i + 2 <= n; i++) {
            for (int j : g.get(i)) {
                for (int k : g.get(i)) {
                    if (i + j + k <= n && isAdjacent(j, k)) {
                        s.add(i + j + k);
                    }
                }
            }
        }

        int ans = 0;
        for (int x : s) {
            ans += x;
        }
        System.out.println(ans);
    }

    private static boolean isAdjacent(long i, long j) {
        long x = i * i + i * j + j * j, sq = (long) sqrt(x);
        return sq * sq == x;
    }
}
