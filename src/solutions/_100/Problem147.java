package solutions._100;

import static utils.Miscellaneous.binomial;

/**
 * O(1) formula exists. Brute force implemented below.
 */
public class Problem147 {
    private static final int n = 47, m = 43;

    public static void main(String[] args) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                boolean[][] a = new boolean[i + j - 2][i + j - 2];
                for (int y = 0; y < i - 1; y++) {
                    for (int dx = 0; dx < 2 * y + 2 && dx < 2 * j - 1; dx++) {
                        a[i - 2 - y + dx][y] = true;
                    }
                }

                for (int y = i - 1; y < i + j - 2; y++) {
                    for (int dx = 0; dx < 2 * (i + j - y - 2) && dx < 2 * i - 1; dx++) {
                        a[y - i + 1 + dx][y] = true;
                    }
                }

                for (int p = 0; p < i + j - 2; p++) {
                    for (int q = 0; q < i + j - 2; q++) {
                        if (!a[p][q]) {
                            continue;
                        }
                        for (int r = q; r < i + j - 2; r++) {
                            if (!a[p][r]) {
                                continue;
                            }
                            for (int s = p; s < i + j - 2; s++) {
                                if (a[s][q] && a[s][r]) {
                                    ans++;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(ans + binomial(n + 2, 3).multiply(binomial(m + 2, 3)).intValue());
    }
}
