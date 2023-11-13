package solutions._100;

public class Problem150 {
    private static final int RADIUS = 1 << 19;
    private static final int n = 1000;
    private static final int a = 615949;
    private static final int b = 797807;

    public static void main(String[] args) {
        long ans = 0;
        int[][] s = new int[n][n];
        for (int t = 0, i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                t = Math.floorMod(a * t + b, RADIUS * 2);
                s[i][j] = t - RADIUS;
                ans = Math.min(ans, s[i][j]);
            }
        }

        long[][] dp = new long[n][n];
        dp[0][0] = s[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + s[i][0];
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + s[i][j];
            }
            dp[i][i] = dp[i][i - 1] + s[i][i];
        }

        long[][] dp2 = new long[n][n];
        dp2[0][0] = s[0][0];
        for (int i = 1; i < n; i++) {
            dp2[i][0] = s[i][0];
            for (int j = 1; j <= i; j++) {
                dp2[i][j] = dp2[i - 1][j - 1] + dp[i][j - 1] - dp[i - 1][j - 1] + s[i][j];
                ans = Math.min(ans, dp2[i][j]);
            }
        }

        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                for (int k = j + 1; k <= i; k++) {
                    ans = Math.min(ans, dp2[i][k] - dp[i][j - 1] + dp[i - k + j - 1][j - 1] - dp2[i - k + j - 1][j - 1]);
                }
            }
        }
        System.out.println(ans);
    }
}
