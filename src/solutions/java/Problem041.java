package solutions.java;

/**
 * Created by dpark3542 on 5/20/2017.
 */
public class Problem041 {
    /*
     * Brute force: test each permutation for primality.
     * Many algorithms exist for generating permutations and testing primality.
     * An optimization can be made in noticing that 9-digit and 8-digit pandigitals are always divisible by 3 and therefore not prime.
     *
     */
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
                p = generatePreviousPermutation(p);
            }
        }
    }

    private static boolean isPrime(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int[] generatePreviousPermutation(int[] a) {
        int n = a.length, k = n - 2;
        while (k >= 0 && a[k] <= a[k + 1]) {
            k--;
        }
        if (k < 0) {
            return a;
        }
        int l = n - 1;
        while (a[k] <= a[l]) {
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
