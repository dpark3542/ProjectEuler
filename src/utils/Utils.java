package utils;

/**
 * Various common utility functions used throughout solutions.
 */
public final class Utils {
    /**
     * Returns if a number is prime using trial division.
     * There exist many other well-known primality tests which are more efficient.
     * Storing primes up to some limit and using binary search may be more efficient.
     * (May implement this in the future and store primes in a text file somewhere.)
     * Often times trial division is fast and simplistic enough to justify being used.
     *
     * @param n integer to check
     * @return boolean if integer is prime
     */
    public static boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns gcd of two positive numbers using the Euclidean algorithm.
     * There exist other algorithms which are more efficient.
     * Java's BigInteger class also implements gcd.
     * The Euclidean algorithm is simplistic and usually fast enough.
     *
     * @param x first number
     * @param y second number
     * @return gcd of the two numbers
     */
    public static long gcd(long x, long y) {
        while (y > 0) {
            long t = y;
            y = x % y;
            x = t;
        }
        return x;
    }

    /**
     * Generates next lexicographic permutation.
     * Implementation from: https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order
     * Modifies permutation array in place.
     * If permutation is lexicographically last (reverse order), then the same permutation is returned.
     *
     * @param a permutation
     */
    public static void generateNextPermutation(int[] a) {
        int n = a.length, k = n - 2;
        // find largest k such that a[k] < a[k + 1]
        while (k >= 0 && a[k] >= a[k + 1]) {
            k--;
        }
        // return early if permutation is in reverse order
        if (k < 0) {
            return;
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
    }
}
