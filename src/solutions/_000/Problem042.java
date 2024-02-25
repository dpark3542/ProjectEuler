package solutions._000;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.StrictMath.floor;
import static java.lang.StrictMath.sqrt;

/*
 * Brute force: test each string. Solve t = n(n+1)/2 over the integers to test if a word value is a triangular
 * number.
 */
public class Problem042 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new FileReader("src/resource/p042_words.txt"));
        String[] a = br.readLine().split("(\\W)+");

        int cnt = 0;
        for (int i = 1; i < a.length; i++) {
            int t = 0;
            for (char c : a[i].toCharArray()) {
                t += (int) c - 64;
            }
            double n = (sqrt(1 + 8 * t) - 1) / 2;
            if (n == floor(n)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
