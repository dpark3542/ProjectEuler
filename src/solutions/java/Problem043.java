package solutions.java;

/**
 * Created by dpark3542 on 5/20/2017.
 */
public class Problem043 {
    /*
     * Brute force: test each permutation for the desired properties.
     * Many algorithms exist for generating permutations.
     * Optimizations can be made in noticing that the fourth digit must be even and the sixth digit must be 0 or 5.
     *
     */
    public static void main(String[] args) {
        int f9 = 362881, f10 = 3628800;
        long sum = 0;
        int[] a = {0, 9, 8, 7, 6, 5, 4, 3, 2, 1}, p = {2, 3, 5, 7, 11, 13, 17};
        out:
        for (int i = f9 + 1; i < f10; i++) {
            a = generateNextPermutation(a);
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

    private static int[] generateNextPermutation(int[] a) {
        int n = a.length, k = n - 2;
        while (k >= 0 && a[k] >= a[k + 1]) {
            k--;
        }
        if (k < 0) {
            return a;
        }
        int l = n - 1;
        while (a[k] >= a[l]) {
            l--;
        }
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        for (int i = k + 1; i <= (k + n - 1) / 2; i++) {
            t = a[n - i + k];
            a[n - i + k] = a[i];
            a[i] = t;
        }
        return a;
    }
}
