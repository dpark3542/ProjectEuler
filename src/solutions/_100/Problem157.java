package solutions._100;

import static utils.NumberTheory.divisorCount;

public class Problem157 {
    public static void main(String[] args) {
        int MAX = 9;
        int[][] f = new int[MAX + 1][MAX + 1], g = new int[MAX + 1][MAX + 1];
        for (int i = 0, x = 1; i <= MAX; i++, x *= 2) {
            for (int j = 0, y = 1; j <= MAX; j++, y *= 5) {
                f[i][j] = divisorCount(x * y + 1);
                g[i][j] = divisorCount(x + y);
            }
        }
        int ans = 0;
        for (int n = 1; n <= 9; n++) {
            // a != c and b != d
            for (int a = 0; a <= n; a++) {
                for (int c = 0; c < a; c++) {
                    for (int b = 0; b <= n; b++) {
                        for (int d = 0; d < b; d++) {
                            ans += f[a - c][b - d];
                        }
                        for (int d = b + 1; d <= n; d++) {
                            ans += g[a - c][d - b];
                        }
                    }
                }
            }
            // a = c and b != d
            for (int b = 0; b <= n; b++) {
                for (int d = 0; d < b; d++) {
                    ans += (n + 2) * f[0][b - d] / 2;
                }
            }
            // a != c and b = d
            for (int a = 0; a <= n; a++) {
                for (int c = 0; c < a; c++) {
                    if ((a - c) % 4 == 2) {
                        ans += (n + 2) * f[a - c][0] / 2;
                    } else {
                        ans += (n + 1) * f[a - c][0];
                    }
                }
            }
            // a = c and b = d
            ans += (n + 1) * (n + 2);
        }
        System.out.println(ans);
    }
}
