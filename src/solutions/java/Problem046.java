package solutions.java;

/**
 * Created by dpark3542 on 5/22/2017.
 */
public class Problem046 {
    /*
     * Brute force: run through every number and test possible sums of primes and squares.
     *
     */
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

    private static boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
