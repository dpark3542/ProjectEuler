package solutions._000;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Problem042 {
    /*
     * Brute force: test each string. Solve t = n(n+1)/2 over the integers to test if a word value is a triangular
     * number.
     */
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
            double n = (Math.sqrt(1 + 8 * t) - 1) / 2;
            if (n == Math.floor(n)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
