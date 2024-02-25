package solutions._000;

import static java.lang.StrictMath.sqrt;

public class Problem094 {
    public static void main(String[] args) {
        long ans = 0;
        for (long a = 3; a <= 333333333; a += 2) {
            long b = (3 * a + 1) * (a - 1), sq = (long) sqrt(b);
            if (sq * sq == b) {
                ans += 3 * a + 1;
            }
            b = (3 * a - 1) * (a + 1);
            sq = (long) sqrt(b);
            if (sq * sq == b) {
                ans += 3 * a - 1;
            }
        }
        System.out.println(ans);
    }
}
