package solutions._000;

import java.util.ArrayList;
import java.util.List;

import static java.lang.StrictMath.sqrt;

/*
 * Store all abundant numbers less than 28123 and calculate all possible sums. Total numbers that cannot be written
 * as a sum.
 * d can be calculated using prime factorization algorithms.
 *
 */
public class Problem023 {
    private static final int n = 28123;

    public static void main(String[] args){
        int sum = 0;
        boolean[] a = new boolean[n + 1];
        List<Integer> b = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (d(i) > i) {
                b.add(i);
            }
        }
        for (int x : b) {
            for (int y : b) {
                if (x + y <= n) {
                    a[x + y] = true;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!a[i]) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    private static int d(int x) {
        if (x == 1) {
            return 0;
        }
        int s = 1, sq = (int) sqrt(x);
        if (x == sq * sq) {
            s += sq;
        }
        for (int i = 2; i < sqrt(x); i++) {
            if (x % i == 0) {
                s += i + x / i;
            }
        }
        return s;
    }
}
