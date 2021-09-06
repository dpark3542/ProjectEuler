package solutions._000;

import static utils.NumberTheory.isPrime;

/*
 * Brute force: run through every number and test possible sums of primes and squares.
 *
 */
public class Problem046 {
    public static void main(String[] args) {
        int n = 1;
        out:
        while (true) {
            n += 2;
            if (isPrime(n)) {
                continue;
            }
            for (int i = 1; i <= Math.sqrt(n / 2 - 1); i++) {
                if (isPrime(n - 2 * i * i)) {
                    continue out;
                }
            }
            break;
        }
        System.out.println(n);
    }
}
