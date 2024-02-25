package solutions._000;

import static java.lang.StrictMath.log10;
import static java.lang.StrictMath.pow;
import static utils.NumberTheory.isPrime;

/**
 * Brute force: test primes until 11 truncatable primes are found.
 */
public class Problem037 {
    public static void main(String[] args) {
        int sum = 0, cnt = 0;
        out: for (int p = 10; cnt < 11; p++) {
            for (int q = p; q > 0; q /= 10) {
                if (!isPrime(q)) {
                    continue out;
                }
            }
            for (int q = p; q > 0; q %= (int) pow(10, (int) log10(q))) {
                if (!isPrime(q)) {
                    continue out;
                }
            }
            sum += p;
            cnt++;
        }
        System.out.println(sum);
    }
}
