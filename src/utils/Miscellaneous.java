package utils;

import utils.structs.BigFraction;

import java.math.BigInteger;
import java.util.List;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.valueOf;

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
     * @param a matrix
     */
    public static void rowReduce(BigFraction[][] a) {
        int n = a.length, m = a[0].length;
        for (int i = 0, j = 0; i < n && j < m; j++) {
            for (int k = i; k < n; k++) {
                if (!a[k][j].equals(BigFraction.ZERO)) {
                    BigFraction[] b = a[i];
                    a[i] = a[k];
                    a[k] = b;
                    break;
                }
            }

            if (a[i][j].equals(BigFraction.ZERO)) {
                continue;
            }

            for (int k = j + 1; k < m; k++) {
                a[i][k] = a[i][k].divide(a[i][j]);
            }
            a[i][j] = BigFraction.ONE;

            for (int k = 0; k < n; k++) {
                if (k == i) {
                    continue;
                }

                for (int l = j + 1; l < m; l++) {
                    a[k][l] = a[k][l].subtract(a[i][l].multiply(a[k][j]));
                }
                a[k][j] = BigFraction.ZERO;
            }

            i++;
        }
    }

    public static int digitSum(BigInteger x) {
        if (x.signum() < 0) {
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

    public static boolean isPalindrome(long x) {
        if (x < 0) {
            throw new IllegalArgumentException();
        }

        return Long.toString(x).equals(reverseString(Long.toString(x)));
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

        BigInteger ans = ONE;
        for (int i = 0; i < k; i++) {
            ans = ans.multiply(valueOf(n - i)).divide(valueOf(i + 1));
        }
        return ans;
    }

    /**
     * Slow calculation of multinomial coefficient of $\dbinom{a_1+\cdots+a_n}{a_1,\ldots,a_n}$.
     *
     * @param a a
     * @return multinomial coefficient
     */
    public static BigInteger multinomial(List<Integer> a) {
        if (a.size() < 2) {
            throw new IllegalArgumentException();
        }

        int sum = a.getFirst() + a.get(1);
        BigInteger ans = binomial(sum, a.get(1));
        for (int i = 2; i < a.size(); i++) {
            sum += a.get(i);
            ans = ans.multiply(binomial(sum, a.get(i)));
        }
        return ans;
    }
}
