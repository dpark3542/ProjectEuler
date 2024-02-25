package solutions._000;

/*
 * Brute force: run through all possible combinations of coins.
 *
 * Dynamic programming:
 * Let dp[i][j] be the number of ways to get a sum of j pence using the first i types of coins.
 * Recursive formula: dp[i][j] = dp[i - 1][j] + dp[i][j - a[i]]
 * Loop formula over all i, j.
 */
public class Problem031 {
    private static final int n = 8, m = 200;
    private static final int[] a = {0, 1, 2, 5, 10, 20, 50, 100, 200};

    public static void main(String[] args) {
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= a[i]) {
                    dp[i][j] += dp[i][j - a[i]];
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
