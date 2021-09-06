package solutions._000;

import java.util.ArrayList;
import java.util.List;

import static utils.NumberTheory.isPrime;

/*
 * Generate all patterns for a set number of digits and test each pattern. Find the smallest prime from the valid
 * patterns.
 * Generating patterns can be done by generating k-combinations of a list, which is a well-known problem.
 * An optimization can be made in noticing that the number of replaced digits for some pattern must be a multiple of
 * 3, else there are less than 8 possible numbers that are not divisible by 3 and thus not prime.
 *
 */
public class Problem051 {
    public static void main(String[] args) {
        boolean flag = true;
        int min = Integer.MAX_VALUE;
        for (int n = 1; flag; n++) {
            for (int k = 3; k <= n; k += 3) {
                out:
                for (int[] p : generatePatterns(n, k)) {
                    int cnt = 0;
                    for (int d = 0; d <= 9; d++) {
                        if ((d == 0 && p[0] < Math.pow(10, n)) || !isPrime(p[0] + d * p[1])) {
                            cnt++;
                        }
                        if (cnt == 3) {
                            continue out;
                        }
                    }
                    if (isPrime(p[0])) {
                        min = Math.min(min, p[0]);
                    }
                    else if (isPrime(p[0] + p[1])) {
                        min = Math.min(min, p[0] + p[1]);
                    }
                    else {
                        min = Math.min(min, p[0] + 2 * p[1]);
                    }
                    flag = false;
                }
            }
        }
        System.out.println(min);
    }

    private static List<int[]> generatePatterns(int n, int k) {
        List<int[]> l = new ArrayList<>();
        int[] a = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = i;
        }
        while (true) {
            for (int i = 0; i < Math.pow(10, n - k); i++) {
                if (a[0] != 0 && i % 10 == 0) {
                    continue;
                }
                int j = i;
                int[] p = new int[2];
                int b = 0;
                for (int c = 0; c < n; c++) {
                    if (b < k && c == a[b]) {
                        p[1] += (int) Math.pow(10, n - c - 1);
                        b++;
                    }
                    else {
                        p[0] += (j % 10) * Math.pow(10, n - c - 1);
                        j /= 10;
                    }
                }
                l.add(p);
            }
            int i;
            for (i = k - 1; i >= 0; i--) {
                if (a[i] != n - k + i) {
                    a[i]++;
                    for (i++; i < k; i++) {
                        a[i] = a[i - 1] + 1;
                    }
                    break;
                }
            }
            if (i < 0) {
                break;
            }
        }
        return l;
    }
}
