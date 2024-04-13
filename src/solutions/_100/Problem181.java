package solutions._100;

/**
 * Some nice recurrence likely exists similar to Pentagonal number theorem for partitions.
 * Generating functions are sufficient in O(max(n,m) * n^2 * m^2).
 */
public class Problem181 {
    private static final int n = 60, m = 40;

    public static void main(String[] args) {
        long[][] p = new long[n + 1][m + 1];
        p[0][0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                long[][] q = new long[n + 1][m + 1];
                for (int k = 0; i * k <= n && j * k <= m; k++) {
                    for (int a = 0; a + i * k <= n; a++) {
                        for (int b = 0; b + j * k <= m; b++) {
                            q[a + i * k][b + j * k] += p[a][b];
                        }
                    }
                }

                p = q;
            }
        }
        System.out.println(p[n][m]);
    }
}
