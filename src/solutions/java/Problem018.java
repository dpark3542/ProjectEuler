package solutions.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Problem018 {
    /*
     * Brute force: compute all totals
     *
     * Dynamic programming:
     * Let a[i][j] be the jth number in the ith row of the triangle.
     * Let dp[i][j] be the greatest subtotal from the top to the jth number in the ith row.
     * Recursive formula: dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + a[i][j]
     * Loop formula over all i, j.
     */
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new FileReader("src/input/p018_triangle.txt"));
        StringTokenizer st;
        int[][] a = new int[15][15];
        for (int i = 0; i < 15; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int[][] dp = new int[15][15];
        dp[0][0] = a[0][0];
        for (int i = 1; i < 15; i++) {
            dp[i][0] = dp[i - 1][0] + a[i][0];
            dp[i][i] = dp[i - 1][i - 1] + a[i][i];
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + a[i][j];
            }
        }
        for (int i = 0; i < 15; i++) {
            max = Math.max(max, dp[14][i]);
        }
        System.out.println(max);
    }
}