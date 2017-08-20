package solutions.java;

public class Problem015 {
    /*
     * Dynamic programming:
     * Let dp[i][j] be the number of ways to get to the intersection of the ith horizontal line and jth vertical line.
     * Recursive formula: dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
     * Loop formula over all i, j.
     *
     * Alternatively, notice all routes must go down a block 20 times and to the right a block 20 times.
     * Problem is equivalent to choosing when to go down 20 times out of the 40 possible times.
     * Answer is 40 choose 20.
     */
    public static void main(String[] args) {
        int n = 20;
        long[][] dp = new long[n + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i - 1 >= 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j - 1 >= 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        System.out.println(dp[n][n]);
    }
}
