package solutions._000;

import static utils.Miscellaneous.generateNextPermutation;

/*
 * Brute force: test each permutation for the desired properties.
 * The fourth digit must be even and the sixth digit must be 0 or 5.
 *
 */
public class Problem043 {
    private static final int n = 10;
    private static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17};

    public static void main(String[] args) {
        int[] a = new int[n];
        for (int i = 1; i < n; i++) {
            a[i] = n - i;
        }

        long sum = 0;
        out: while (generateNextPermutation(a)) {
            for (int j = 0; j < 7; j++) {
                if ((100 * a[j + 1] + 10 * a[j + 2] + a[j + 3]) % PRIMES[j] != 0) {
                    continue out;
                }
            }
            long x = 0;
            for (int j = 0; j <= 9; j++) {
                x  = 10 * x + a[j];
            }
            sum += x;
        }
        System.out.println(sum);
    }
}
