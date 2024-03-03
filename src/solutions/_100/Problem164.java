package solutions._100;

/**
 * Dynamic programming.
 * Let dp[i][j][k] = number of i digit numbers x that end with digits j, k and no 3 consecutive digits of x have sum greater than 9.
 */
public class Problem164 {
    private static final int n = 20;

    public static void main(String[] args) {
        long[][][] dp = new long[n + 1][10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; 1 + i + j <= 9; j++) {
                dp[3][i][j] = 9 - i - j;
            }
        }
        for (int i = 3; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; j + k + l <= 9; l++) {
                        dp[i + 1][k][l] += dp[i][j][k];
                    }
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ans += dp[n][i][j];
            }
        }
        System.out.println(ans);
    }
}
