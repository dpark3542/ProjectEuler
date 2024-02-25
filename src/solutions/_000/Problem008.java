package solutions._000;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Integer.parseInt;
import static java.lang.StrictMath.max;

/*
 * Brute force: test all products
 */
public class Problem008 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new FileReader("src/resource/p008_string.txt"));
        StringBuilder sb = new StringBuilder();
        while (br.ready()) {
            sb.append(br.readLine());
        }

        int[] a = new int[1000];
        for (int i = 0; i < 1000; i++) {
            a[i] = parseInt(sb.substring(i, i + 1));
        }
        long max = 0;
        for (int i = 0; i < 1000 - 13; i++) {
            long prod = 1;
            for (int j = 0; j < 13; j++) {
                prod *= a[i + j];
            }
            max = max(max, prod);
        }
        System.out.println(max);
    }
}
