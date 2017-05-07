package solutions;

import java.io.*;

/**
 * Created by dpark on 5/6/2017.
 */
public class Problem008 {
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new FileReader("src/input/p008_string"));
        StringBuilder sb = new StringBuilder();
        while (br.ready()) {
            sb.append(br.readLine());
        }

        int[] a = new int[1000];
        for (int i = 0; i < 1000; i++) {
            a[i] = Integer.parseInt(sb.substring(i, i + 1));
        }
        long max = 0;
        for (int i = 0; i < 1000 - 13; i++) {
            long prod = 1;
            for (int j = 0; j < 13; j++) {
                prod *= a[i + j];
            }
            max = Math.max(max, prod);
        }
        System.out.println(max);
    }
}
