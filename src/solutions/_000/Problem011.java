package solutions._000;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Problem011 {
    /*
     * Brute force: test all products.
     */
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new FileReader("src/input/p011_grid.txt"));
        int n = 20;
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("\\s");
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(split[j]);
            }
        }

        // up to down
        int max = 0;
        for (int i = 0; i < n - 4; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, a[i][j] * a[i + 1][j] * a[i + 2][j] * a[i + 3][j]);
            }
        }
        // left to right
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 4; j++) {
                max = Math.max(max, a[i][j] * a[i][j + 1] * a[i][j + 2] * a[i][j + 3]);
            }
        }
        // top left to bottom right
        for (int i = 0; i < n - 4; i++) {
            for (int j = 0; j < n - 4; j++) {
                max = Math.max(max, a[i][j] * a[i + 1][j + 1] * a[i + 2][j + 2] * a[i + 3][j + 3]);
            }
        }
        // bottom left to top right
        for (int i = 3; i < n; i++) {
            for (int j = 0; j < n - 4; j++) {
                max = Math.max(max, a[i][j] * a[i - 1][j + 1] * a[i - 2][j + 2] * a[i - 3][j + 3]);
            }
        }
        System.out.println(max);
    }
}
