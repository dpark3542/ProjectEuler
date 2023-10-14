package solutions._000;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Problem099 {
    private static final int n = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/resource/p099_base_exp.txt"));
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(",");
            a[i][0] = Integer.parseInt(split[0]);
            a[i][1] = Integer.parseInt(split[1]);
        }

        double max = 0;
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            double log = a[i][1] * Math.log(a[i][0]);
            if (log > max) {
                max = log;
                ans = i;
            }
        }
        System.out.println(ans + 1);
    }
}
