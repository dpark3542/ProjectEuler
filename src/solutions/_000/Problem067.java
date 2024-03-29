package solutions._000;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Integer.parseInt;
import static java.lang.StrictMath.max;

/*
 * See Problem 18.
 *
 * Brute force: compute all totals
 *
 * Dynamic programming:
 * Let a[i][j] be the jth number in the ith row of the triangle.
 * Let dp[i][j] be the greatest subtotal from the top to the jth number in the ith row.
 * Recursive formula: dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + a[i][j]
 * Loop formula over all i, j.
 */
public class Problem067 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new FileReader("src/resource/p067_triangle.txt"));
        int n = 100;
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("\\s");
            for (int j = 0; j <= i; j++) {
                a[i][j] = parseInt(split[j]);
            }
        }

        int max = 0;
        int[][] dp = new int[n][n];
        dp[0][0] = a[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + a[i][0];
            dp[i][i] = dp[i - 1][i - 1] + a[i][i];
            for (int j = 1; j < i; j++) {
                dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + a[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            max = max(max, dp[n - 1][i]);
        }
        System.out.println(max);
    }
}
