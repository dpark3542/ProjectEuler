package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by dpark on 5/10/2017.
 */
public class Problem018 {
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new FileReader("src/input/p018_triangle"));
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
