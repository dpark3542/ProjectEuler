package solutions._000;

import static java.lang.StrictMath.ceil;
import static java.lang.StrictMath.sqrt;

/**
 * Partitions are well known.
 */
public class Problem076 {
    public static void main(String[] args) {
        int n = 100;
        int[] p = new int[n + 1];
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int k = (int) ceil((1 - sqrt(24 * i + 1)) / 6); k <= (sqrt(24 * i + 1) + 1) / 6; k++) {
                if (k != 0) {
                    int j = i - k * (3 * k - 1) / 2;
                    if (k % 2 == 0) {
                        p[i] -= p[j];
                    } else {
                        p[i] += p[j];
                    }
                }
            }
        }
        System.out.println(p[n] - 1);
    }
}
