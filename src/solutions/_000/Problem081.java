package solutions._000;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Integer.parseInt;
import static java.lang.StrictMath.min;

public class Problem081 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new FileReader("src/resource/p081_matrix.txt"));
        int n = 80;
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(",");
            for (int j = 0; j < n; j++) {
                a[i][j] = parseInt(line[j]);
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = a[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + a[i][0];
            dp[0][i] = dp[0][i - 1] + a[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + a[i][j];
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }
}
