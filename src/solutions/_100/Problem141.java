package solutions._100;

import java.util.HashSet;
import java.util.Set;

import static java.lang.StrictMath.sqrt;

public class Problem141 {
    public static void main(String[] args) {
        Set<Long> s = new HashSet<>();
        long sum = 0, lim = 1000000000000L;
        for (int a = 1; a <= (sqrt(32 * lim + 1) - 1) / 16; a++) {
            for (int b = 1, c = -1; c != b + 1; b++) {
                c = b + 1;
                for (long x = -1; x < lim; c++) {
                    x = (long) a * a * b * c * c * c + a * b * b;
                    long sq = (long) sqrt(x);
                    if (x == sq * sq) {
                        s.add(x);
                    }
                }
            }
        }
        for (long x : s) {
            sum += x;
        }
        System.out.println(sum);
    }
}
