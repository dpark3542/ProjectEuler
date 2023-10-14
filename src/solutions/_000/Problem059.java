package solutions._000;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/*
 * Brute force: test every possible key for a valid message.
 * A good heuristic for identifying a valid message are comparing the number of occurrences of common words such as
 * "the", "be", and "to". The number of spaces and periods can also be compared.
 *
 */
public class Problem059 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new FileReader("src/resource/p059_cipher.txt"));
        String[] split = br.readLine().split(",");
        int n = split.length;
        int[] txt = new int[n];
        for (int i = 0; i < n; i++) {
            txt[i] = Integer.parseInt(split[i]);
        }

        int cnt = 0, ans = 0;
        for (int a = (int) 'a'; a <= (int) 'z'; a++) {
            for (int b = (int) 'a'; b <= (int) 'z'; b++) {
                for (int c = (int) 'a'; c <= (int) 'z'; c++) {
                    int cur = 0;
                    int[] decr = new int[n];
                    for (int i = 0; i < n; i++) {
                        if (i % 3 == 0) {
                            decr[i] = txt[i] ^ a;
                        }
                        else if (i % 3 == 1) {
                            decr[i] = txt[i] ^ b;
                        }
                        else {
                            decr[i] = txt[i] ^ c;
                        }
                        if (decr[i] == (int) ' ') {
                            cur++;
                        }
                    }
                    if (cur > cnt) {
                        int sum = 0;
                        for (int i = 0; i < n; i++) {
                            sum += decr[i];
                        }
                        ans = sum;
                        cnt = cur;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
