package solutions._100;

import java.util.List;

import static utils.NumberTheory.toBase;

/**
 * Brute force. Grids with the same row, column, and diagonal sums can be uniquely determined by 9 entries $a_0,\ldots,a_9$:
 * \[\begin{bmatrix}
 *     a_0 & p & a_1 & a_2\\
 *     w & a_3 & q & a_4\\
 *     x & a_5 & a_6 & r\\
 *     a_7 & y & z & a_8
 * \end{bmatrix}\]
 */
public class Problem166 {
    private static final int n = 1000000000;

    public static void main(String[] args) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> a = toBase(i, 10);
            while (a.size() < 9) {
                a.add(0);
            }

            int s = a.get(0) + a.get(3) + a.get(6) + a.get(8);

            int p = s - a.get(0) - a.get(1) - a.get(2);
            if (p < 0 || p >= 10) {
                continue;
            }

            int q = s - a.get(2) - a.get(5) - a.get(7);
            if (q < 0 || q >= 10) {
                continue;
            }

            int r = s - a.get(2) - a.get(4) - a.get(8);
            if (r < 0 || r >= 10) {
                continue;
            }

            int w = s - a.get(3) - q - a.get(4);
            if (w < 0 || w >= 10) {
                continue;
            }

            int x = s - a.get(5) - a.get(6) - r;
            if (x < 0 || x >= 10) {
                continue;
            }

            if (a.get(0) + w + x + a.get(7) != s) {
                continue;
            }

            int y = s - p - a.get(3) - a.get(5);
            if (y < 0 || y >= 10) {
                continue;
            }

            int z = s - a.get(1) - q - a.get(6);
            if (z < 0 || z >= 10) {
                continue;
            }

            if (a.get(7) + y + z + a.get(8) != s) {
                continue;
            }

            ans++;
        }
        System.out.println(ans);
    }
}
