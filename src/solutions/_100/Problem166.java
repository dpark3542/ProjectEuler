package solutions._100;

import static java.lang.StrictMath.max;
import static java.lang.StrictMath.min;

/**
 * Let the grid be:
 * \[\begin{bmatrix}
 *     a & b & c & d\\
 *     e & f & g & h\\
 *     i & j & k & l\\
 *     m & n & o & p
 * \end{bmatrix}.\]
 * One can show $a + p = g + j$ and $d + m = f + k$.
 */
public class Problem166 {
    private static final int n = 9;

    public static void main(String[] args) {
        int ans = 0;
        for (int a = 0; a <= n; a++) {
            for (int p = 0; p <= n; p++) {
                for (int g = max(0, a + p - n); g <= n && g <= a + p; g++) {
                    int j = a + p - g;
                    for (int f = 0; f <= n; f++) {
                        for (int k = 0; k <= n; k++) {
                            int sum = a + f + k + p;
                            for (int d = max(0, f + k - n); d <= n && d <= f + k; d++) {
                                int b_low = max4(sum - a - d - n, sum - f - j - n, g + k - a - d, 0);
                                int b_hi = min4(sum - a - d, sum - f - j, g + k - a - d + n, 9);
                                int h_low = max4(sum - d - p - n, sum - f - g - n, j + k - d - p, 0);
                                int h_hi = min4(sum - d - p, sum - f - g, j + k - d - p + n, 9);
                                if (b_low <= b_hi && h_low <= h_hi) {
                                    ans += (b_hi - b_low + 1) * (h_hi - h_low + 1);
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static int min4(int a, int b, int c, int d) {
        return min(min(a, b), min(c, d));
    }

    private static int max4(int a, int b, int c, int d) {
        return max(max(a, b), max(c, d));
    }
}
