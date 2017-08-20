package solutions.java;

import java.util.HashSet;
import java.util.Set;

public class Problem141 {
    public static void main(String[] args) {
        Set<Long> s = new HashSet<>();
        long sum = 0, lim = 1000000000000L;
        for (int a = 1; a <= (Math.sqrt(32 * lim + 1) - 1) / 16; a++) {
            long x;
            int b = 1, c;
            while (true) {
                for (c = b + 1; (x = (long) a * a * b * c * c * c + a * b * b) < lim; c++) {
                    if (Math.sqrt(x) == Math.floor(Math.sqrt(x))) {
                        s.add(x);
                    }
                }
                if (c == b + 1) {
                    break;
                }
                b++;
            }
        }
        for (long x : s) {
            sum += x;
        }
        System.out.println(sum);
    }
}
