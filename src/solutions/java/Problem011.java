package solutions.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*
 * Created by dpark3542 on 5/7/2017.
 */
public class Problem011 {
    /*
     * Brute force: test all products.
     *
     */
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new FileReader("src/input/p011_grid"));
        StringTokenizer st;
        int[][] a = new int[20][20];
        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 20; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // up to down
        int max = 0;
        for (int i = 0; i < 20 - 4; i++) {
            for (int j = 0; j < 20; j++) {
                max = Math.max(max, a[i][j] * a[i + 1][j] * a[i + 2][j] * a[i + 3][j]);
            }
        }
        // left to right
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20 - 4; j++) {
                max = Math.max(max, a[i][j] * a[i][j + 1] * a[i][j + 2] * a[i][j + 3]);
            }
        }
        // top left to bottom right
        for (int i = 0; i < 20 - 4; i++) {
            for (int j = 0; j < 20 - 4; j++) {
                max = Math.max(max, a[i][j] * a[i + 1][j + 1] * a[i + 2][j + 2] * a[i + 3][j + 3]);
            }
        }
        // bottom left to top right
        for (int i = 3; i < 20; i++) {
            for (int j = 0; j < 20 - 4; j++) {
                max = Math.max(max, a[i][j] * a[i - 1][j + 1] * a[i - 2][j + 2] * a[i - 3][j + 3]);
            }
        }
        System.out.println(max);
    }
}
