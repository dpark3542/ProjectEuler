package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by dpark on 5/10/2017.
 */
public class Problem022 {
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new FileReader("src/input/p022_names"));
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