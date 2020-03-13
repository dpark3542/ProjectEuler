package solutions._000;

import static utils.Utils.generateNextPermutation;

/*
 * Brute force: test each permutation for the desired properties.
 * Many algorithms exist for generating permutations.
 * Optimizations can be made in noticing that the fourth digit must be even and the sixth digit must be 0 or 5.
 *
 */
public class Problem043 {
    public static void main(String[] args) {
        int f9 = 362881, f10 = 3628800;
        long sum = 0;
        int[] a = {0, 9, 8, 7, 6, 5, 4, 3, 2, 1}, p = {2, 3, 5, 7, 11, 13, 17};
        out:
        for (int i = f9 + 1; i < f10; i++) {
            generateNextPermutation(a);
            for (int j = 0; j < 7; j++) {
                if ((100 * a[j + 1] + 10 * a[j + 2] + a[j + 3]) % p[j] != 0) {
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
