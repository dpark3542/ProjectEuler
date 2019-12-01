package utils;

/**
 * Package for various common utility functions used throughout solutions.
 */
public final class Utils {
    /**
     * Returns if a number is prime using trial division.
     * There exist many other well-known algorithms which are more efficient.
     * Storing primes up to some limit and using binary search may even be more efficient for some problems which call this function.
     * (May implement this in the future and store primes in a text file somewhere.)
     * Often times trial division is fast and simplistic enough to justify being used.
     *
     * @param x integer to check
     * @return boolean if integer is prime
     */
    public static boolean isPrime(long x) {
        if (x < 2) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns gcd of two numbers using the Euclidean algorithm.
     * There exist other algorithms which are more efficient.
     * Often times the Euclidean algorithm is fast and simplistic enough to justify being used.
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
}
