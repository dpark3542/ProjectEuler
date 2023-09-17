package solutions._100;

public class Problem159 {
    public static void main(String[] args) {
        int n = 1000000, tot = 0;
        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            dp[i] = i;
            while (dp[i] > 9) {
                int tmp = 0;
                for (int x = dp[i]; x > 0; x /= 10) {
                    tmp += x % 10;
                }
                dp[i] = tmp;
            }
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + dp[i / j]);
                }
            }
            tot += dp[i];
        }
        System.out.println(tot);
    }
}
