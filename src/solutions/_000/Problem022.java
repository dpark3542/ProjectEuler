package solutions._000;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Problem022 {
    /*
     * Brute force: sort list, calculate each name score, and total the scores
     */
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new FileReader("src/input/p022_names.txt"));
        String[] a = br.readLine().split("(\\W)+");

        Arrays.sort(a);
        int tot = 0;
        for (int i = 1; i < a.length; i++) {
            int sc = 0;
            for (char c : a[i].toCharArray()) {
                sc += (int) c - 64;
            }
            tot += i * sc;
        }
        System.out.println(tot);
    }
}
