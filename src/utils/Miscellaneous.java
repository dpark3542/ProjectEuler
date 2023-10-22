package utils;

import utils.structs.BigFraction;

import java.math.BigInteger;

public final class Miscellaneous {
    /**
     * Generates the next lexicographic permutation in place.
     * Implementation from <a href="https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order">here</a>.
     * Permutation array can contain any integers since comparisons are used.
     * If permutation is lexicographically last (reverse order), then no change is made.
     *
     * @param a permutation
     * @return if array was modified
     */
    public static boolean generateNextPermutation(int[] a) {
        int n = a.length, k = n - 2;

        // find largest k such that a[k] < a[k + 1]
        while (k >= 0 && a[k] >= a[k + 1]) {
            k--;
        }

        // return early if permutation is in reverse order
        if (k < 0) {
            return false;
        }

        // find largest l such that a[k] < a[l]
        int l = n - 1;
        while (a[k] >= a[l]) {
            l--;
        }

        // swap a[k] and a[l]
        int t = a[l];
        a[l] = a[k];
        a[k] = t;

        // reverse a[k+1..l]
        for (int i = k + 1; i <= (k + n - 1) / 2; i++) {
            t = a[n - i + k];
            a[n - i + k] = a[i];
            a[i] = t;
        }

        return true;
    }

    /**
     * Generates previous permutation in place.
     * Permutation array can contain any integers since comparisons are used.
     * If permutation is lexicographically first, then the same permutation is returned.
     *
     * @param a permutation
     */
    public static boolean generatePreviousPermutation(int[] a) {
        int n = a.length, k = n - 2;
        while (k >= 0 && a[k] <= a[k + 1]) {
            k--;
        }
        if (k < 0) {
            return false;
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
        return true;
    }

    /**
     * Uses Gaussian elimination to row reduce matrices to reduced echelon form in place.
     * @param a m by n matrix
     */
    public static void rowReduce(BigFraction[][] a) {
        int m = a.length, n = a[0].length;
        for (int h = 0, k = 0; h < m && k < n; k++) {
            if (a[h][k].compareTo(BigFraction.ZERO) != 0) {
                for (int i = 0; i < m; i++) {
                    if (i != h) {
                        BigFraction q = a[i][k].multiply(a[h][k].inverse());
                        a[i][k] = BigFraction.ZERO;
                        for (int j = k + 1; j < n; j++) {
                            a[i][j] = a[i][j].add(a[h][j].multiply(q).negate());
                        }
                    }
                }
                for (int j = k + 1; j < n; j++) {
                    a[h][j] = a[h][j].multiply(a[h][k].inverse());
                }
                a[h][k] = BigFraction.ONE;
                h++;
            }
        }
    }

    public static int digitSum(BigInteger x) {
        if (x.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException();
        }

        int sum = 0;
        for (char c : x.toString().toCharArray()) {
            sum += c - '0';
        }
        return sum;
    }

    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    /**
     * Slow calculation of binomial coefficient n choose k.
     *
     * @param n n
     * @param k k
     * @return n choose k
     */
    public static BigInteger binomial(int n, int k) {
        if (k < 0 || k > n) {
            throw new IllegalArgumentException();
        }

        if (2 * k > n) {
            k = n - k;
        }

        BigInteger ans = BigInteger.ONE;
        for (int i = 0; i < k; i++) {
            ans = ans.multiply(BigInteger.valueOf(n - i)).divide(BigInteger.valueOf(i + 1));
        }
        return ans;
    }
}
