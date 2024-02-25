package solutions._000;

import static java.lang.StrictMath.floorMod;
import static java.lang.StrictMath.pow;
import static utils.NumberTheory.powerMod;

/**
 * Let p be the prime.
 * The exponent 7830457 is close to phi(5^10) = 5^10 - 5^9 = 7812500.
 * With successive squaring, calculate p mod 5^10.
 * Combine with p = 1 mod 2^10 and Chinese Remainder Theorem to obtain p mod 10^10.
 */
public class Problem097 {
    public static void main(String[] args) {
        long e = 7830457, res = 28433;
        long a = (int) pow(5, 10), b = 1 << 10;

        res = (res * powerMod(2, e % (a - (a / 5)), a) + 1) % a;

        long inv = 0;
        for (int i = 1; i < b; i++) {
            if ((a * i) % b == 1) {
                inv = i;
                break;
            }
        }

        long ans = a * inv * (1 - res) + res;
        System.out.println(floorMod(ans, ((long) pow(10, 10))));
    }
}
