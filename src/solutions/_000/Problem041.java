package solutions._000;

import static utils.Miscellaneous.generatePreviousPermutation;
import static utils.NumberTheory.isPrime;

/**
 * Brute force: test if each permutation is prime.
 * An optimization can be made in noticing that 9-digit and 8-digit pandigitals are always divisible by 3 and therefore not prime.
 */
public class Problem041 {
    public static void main(String[] args) {
        for (int d = 7; d >= 1; d--) {
            int f = 1;
            for (int i = 1; i <= d; i++) {
                f *= i;
            }
            int[] p = new int[d];
            for (int i = 0; i < d; i++) {
                p[i] = d - i;
            }
            for (int i = 0; i < f; i++) {
                int x = 0;
                for (int j = 0; j < d; j++) {
                    x = 10 * x + p[j];
                }
                if (isPrime(x)) {
                    System.out.println(x);
                    return;
                }
                generatePreviousPermutation(p);
            }
        }
    }
}
