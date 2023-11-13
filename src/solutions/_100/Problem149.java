package solutions._100;

import java.util.ArrayList;
import java.util.List;

public class Problem149 {
    private static final int n = 2000;
    private static final long POW = 100000;

    public static void main(String[] args) {
        long[][] s = new long[n][n];
        for (int k = 1; k <= 55; k++) {
            s[0][k - 1] = Math.floorMod(POW + 3 - (2 * POW + 3) * k + (3 * POW + 7) * k * k * k, 10 * POW) - 5 * POW;
        }
        for (int k = 55; k < n * n; k++) {
            s[k / n][k % n] = Math.floorMod(s[(k - 24) / n][(k - 24) % n] + s[(k - 55) / n][(k - 55) % n], 10 * POW) - 5 * POW;
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            List<Long> a = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                a.add(s[i][j]);
            }
            ans = Math.max(ans, maxSumSubsequence(a));

            a.clear();
            for (int j = 0; j < n; j++) {
                a.add(s[j][i]);
            }
            ans = Math.max(ans, maxSumSubsequence(a));

            a.clear();
            for (int j = 0; j <= i; j++) {
                a.add(s[i - j][j]);
            }
            ans = Math.max(ans, maxSumSubsequence(a));

            a.clear();
            for (int j = 0; i + j < n; j++) {
                a.add(s[i + j][j]);
            }
            ans = Math.max(ans, maxSumSubsequence(a));

            a.clear();
            for (int j = 0; j <= i; j++) {
                a.add(s[i - j][n - j - 1]);
            }
            ans = Math.max(ans, maxSumSubsequence(a));

            a.clear();
            for (int j = 0; i + j < n; j++) {
                a.add(s[i + j][n - j - 1]);
            }
            ans = Math.max(ans, maxSumSubsequence(a));
        }

        System.out.println(ans);
    }

    private static long maxSumSubsequence(List<Long> a) {
        long[] dp = new long[a.size()];
        dp[0] = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            dp[i] = dp[i - 1] + a.get(i);
        }
        long ans = 0;
        for (int i = 0; i < a.size(); i++) {
            for (int j = i; j < a.size(); j++) {
                ans = Math.max(ans, i == 0 ? dp[j] : dp[j] - dp[i - 1]);
            }
        }
        return ans;
    }
}
