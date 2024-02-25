package solutions._000;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.StrictMath.max;
import static java.lang.StrictMath.sqrt;

public class Problem098 {
    private static final long LIMIT = 9876543210L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/resource/p098_words.txt"));
        String[] a = br.readLine().split("(\\W)+");


        long ans = 0;
        for (int i = 0; i < a.length; i++) {
            out: for (int j = i + 1; j < a.length; j++) {
                int n = a[i].length();
                if (a[j].length() != n) {
                    continue;
                }

                int[] cnt = new int[26];
                for (int k = 0; k < n; k++) {
                    cnt[a[i].charAt(k) - 'A']++;
                    cnt[a[j].charAt(k) - 'A']--;
                }

                for (int k = 0; k < 26; k++) {
                    if (cnt[k] != 0) {
                        continue out;
                    }
                }

                out2: for (int u = 1; (long) u * u <= LIMIT; u++) {
                    int[] forward = new int[26];
                    char[] backward = new char[10];
                    for (int k = 0; k < 26; k++) {
                        forward[k] = -1;
                    }

                    long v = (long) u * u;
                    for (int k = n - 1; k >= 0; k--, v /= 10) {
                        if (backward[(int) (v % 10)] == '\0') {
                            forward[a[i].charAt(k) - 'A'] = (int) (v % 10);
                            backward[(int) (v % 10)] = a[i].charAt(k);
                        } else if (backward[(int) (v % 10)] != a[i].charAt(k)) {
                            continue out2;
                        }
                    }

                    if (forward[a[i].charAt(0) - 'A'] == 0 || forward[a[j].charAt(0) - 'A'] == 0 || v != 0) {
                        continue;
                    }

                    long x = 0;
                    for (int k = 0; k < n; k++) {
                        x = 10 * x + forward[a[j].charAt(k) - 'A'];
                    }

                    long w = (long) sqrt(x);
                    if (w * w == x) {
                        ans = max(ans, (long) u * u);
                        ans = max(ans, x);
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
