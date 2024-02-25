package solutions._000;

import static java.lang.StrictMath.floor;
import static java.lang.StrictMath.log10;

/*
 * nth perfect power a^n has n digits if and only if
 *
 * 10^(n-1) <= a^n < 10^n
 *
 * The second inequality gives a < 10.
 * The first inequality gives
 *
 * 10^n <= 10a^n
 * (10/a)^n <= 10
 * n log(10/a) <= log(10)
 * n <= 1/log(10/a)
 * n <= 1/(1-log a)
 *
 * Iterate over 1 <= a <= 9 and calculate the number of values for n where 1 <= n <= floor(1/(1-log a)).
 * Can alternatively get an upper bound for n and iterate over n.
 */
public class Problem063 {
    public static void main(String[] args) {
        int ans = 0;
        for (int a = 1; a < 10; a++) {
            ans += (int) floor(1 / (1 - log10(a)));
        }
        System.out.println(ans);
    }
}
